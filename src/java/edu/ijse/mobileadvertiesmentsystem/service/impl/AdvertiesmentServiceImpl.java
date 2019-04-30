/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.AdvertiesmentDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.AddDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.AdvertiesmentDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.MBDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.ModelDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.ShopDTO;
import edu.ijse.mobileadvertiesmentsystem.model.AdvertiesmentDetail;
import edu.ijse.mobileadvertiesmentsystem.model.Model;
import edu.ijse.mobileadvertiesmentsystem.model.ModelDetailId;
import edu.ijse.mobileadvertiesmentsystem.model.Owner;
import edu.ijse.mobileadvertiesmentsystem.model.Pendding;
import edu.ijse.mobileadvertiesmentsystem.model.Warranty;
import edu.ijse.mobileadvertiesmentsystem.model.WarrantyPendding;
import edu.ijse.mobileadvertiesmentsystem.service.AdvertiesmentService;
import edu.ijse.mobileadvertiesmentsystem.service.ModelService;
import edu.ijse.mobileadvertiesmentsystem.service.ShopService;
import edu.ijse.mobileadvertiesmentsystem.service.WarrantyService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ashan Tharuka
 */
@Transactional
@Service
public class AdvertiesmentServiceImpl implements AdvertiesmentService {

    @Autowired
    private AdvertiesmentDAO advertiesmentDAO;

    @Autowired
    private ShopService shopService;

    @Autowired
    private ModelService modelService;

    @Autowired
    private WarrantyService warrantyService;

    @Override
    public ArrayList<AddDTO> getAllAddBySearch() {

        ArrayList<AdvertiesmentDetail> list = advertiesmentDAO.getAll();
        ArrayList<AddDTO> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            AddDTO add = new AddDTO();

            MBDTO mb = modelService.SearchQuery(Integer.toString(list.get(i).getModel().getModelId()));
            add.setBrandName(mb.getBrandName());
            add.setModelName(mb.getModelName());
            add.setPrice(Double.toString(list.get(i).getPrice()));
            ShopDTO shop = shopService.searchByID(Integer.toString(list.get(i).getOwner().getOwnerId()));
            if (shop == null) {
                return null;
            }
            add.setShopName(shop.getShopName());
            newList.add(add);
        }

        return newList;
    }

    @Override
    public String deleteAddDetail(String shopName, String modelName) {

        String modelId = modelService.searchByName(modelName);

        if (modelId != null) {

            String shopId = shopService.searchByName(shopName);
            if (shopId != null) {

                String ans = warrantyService.deleteWarranty(shopId, modelId);
                if (ans.equals("success")) {
                    int val = advertiesmentDAO.deleteAddDetail(shopId, modelId);

                    if (val > 0) {
                        return "success";
                    }
                }

            }
        }
        return "fail";
    }

    @Override
    public String saveAdd(AdvertiesmentDTO add) {

        Pendding addD = new Pendding();

        String shopId = shopService.searchByName(add.getShopName());
        ShopDTO shopDTO = shopService.searchByID(shopId);
        String modelId = modelService.searchByName(add.getModelName());

        ModelDTO model = modelService.searchById(shopId);

        Model m = new Model();
        m.setAdvertiesmentDetails(model.getAdvertiesmentDetails());
        m.setBrand(model.getBrand());
        m.setImgPath_1(model.getImgPath_1());
        m.setImgPath_2(model.getImgPath_2());
        m.setImgPath_3(model.getImgPath_2());
        m.setMaxPrice(model.getMaxPrice());
        m.setMinPrice(model.getMinPrice());
        m.setModelId(model.getModelId());
        m.setModelName_1(model.getModelName_1());
        m.setModelName_2(model.getModelName_2());
        m.setModelYear(model.getModelYear());
        m.setRate(model.getRate());
        m.setSearchLine(model.getSearchLine());
        m.setSpecialCategoryName(model.getSpecialCategoryName());
        m.setSpecifications(model.getSpecifications());
        m.setStoreCount(model.getStoreCount());

        Owner o = new Owner();
        o.setAdvertiesmentDetails(shopDTO.getAdvertiesmentDetails());
        o.setBranch(shopDTO.getBranch());
        o.setEmail(shopDTO.getEmail());
        o.setOwnerId(Integer.parseInt(shopDTO.getShopId()));
        o.setOwnerName(shopDTO.getShopName());
        o.setPassword(shopDTO.getPassword());
        o.setShopImg(shopDTO.getShopImg());
        o.setUrl(shopDTO.getUrl());

        WarrantyPendding warranty = new WarrantyPendding();
        warranty.setPendding(addD);
        warranty.setNumOfMonth(add.getMonth());
        warranty.setPrice(Double.parseDouble(add.getmPrice()));
        warranty.setWarrantyType(add.getWarrantyType());

        ModelDetailId mdi = new ModelDetailId();

        mdi.setModelId(model.getModelId());

        mdi.setOwnerId(o.getOwnerId());

        addD.setModel(m);

        addD.setOwner(o);
        addD.getWarrantys().add(warranty);
        addD.setModelDetailId(mdi);
        addD.setColor(add.getColor());
        addD.setPrice(add.getPrice());

        Serializable ser = advertiesmentDAO.addPenddniigAdd(addD);
        if (ser != null) {
            return "success";
        } else {
            return "fail";
        }

    }

    @Override
    public String saveAdd(String modelId, String ownerId, String color, String price) {

        Serializable ser = advertiesmentDAO.saveAdd(modelId, ownerId, color, price);

        if (ser != null) {
            return "success";
        } else {
            return "fail";
        }

    }

    @Override
    public ArrayList<AdvertiesmentDTO> getAllAddByShop(String shopName) {

        List<Object[]> list = advertiesmentDAO.getAllAddByShop(shopName);
        ArrayList<AdvertiesmentDTO> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Object[] ar = list.get(i);
            AdvertiesmentDTO add = new AdvertiesmentDTO();
            add.setModelName(ar[0].toString());
            add.setColor(ar[1].toString());
            add.setPrice(Double.parseDouble(ar[2].toString()));
            newList.add(add);
        }

        return newList;
    }

}
