/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.AdvertiesmentDAO;
import edu.ijse.mobileadvertiesmentsystem.dao.custom.PenddingDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.AddDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.MBDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.ModelDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.ShopDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.WarrantyPenddingDTO;
import edu.ijse.mobileadvertiesmentsystem.model.AdvertiesmentDetail;
import edu.ijse.mobileadvertiesmentsystem.model.Model;
import edu.ijse.mobileadvertiesmentsystem.model.ModelDetailId;
import edu.ijse.mobileadvertiesmentsystem.model.Owner;
import edu.ijse.mobileadvertiesmentsystem.model.Pendding;
import edu.ijse.mobileadvertiesmentsystem.model.Warranty;
import edu.ijse.mobileadvertiesmentsystem.service.AdvertiesmentService;
import edu.ijse.mobileadvertiesmentsystem.service.ModelService;
import edu.ijse.mobileadvertiesmentsystem.service.PenddingService;
import edu.ijse.mobileadvertiesmentsystem.service.ShopService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.ijse.mobileadvertiesmentsystem.service.WarrantyPendingService;
import edu.ijse.mobileadvertiesmentsystem.service.WarrantyService;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ashan Tharuka
 */
@Transactional
@Service
public class PenddingServiceImpl implements PenddingService {

    @Autowired
    private PenddingDAO penddingDAO;

    @Autowired
    private ShopService shopService;

    @Autowired
    private ModelService modelService;

    @Autowired
    private AdvertiesmentService advertiesmentService;

    @Autowired
    private WarrantyPendingService warrantyPendingService;

    @Autowired
    private WarrantyService warrantyService;

    @Override
    public ArrayList<AddDTO> getAllPenddingSearch() {

        ArrayList<Pendding> list = penddingDAO.getAll();
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
    public String deletePendding(String shopName, String modelName) {
        String modelId = modelService.searchByName(modelName);

        if (modelId != null) {

            String shopId = shopService.searchByName(shopName);
            if (shopId != null) {
                String ans = warrantyPendingService.deleteWarrantyPendding(modelId, shopId);

    
                if (ans.equals("success")) {
                    int val = penddingDAO.deletePendding(shopId, modelId);
                    if (val > 0) {
                        
                        return "success";
                    }

                }

            }
        }
        return "fail";
    }

    @Override
    public String acceptPennding(String shopName, String modelName) {
        String modelId = modelService.searchByName(modelName);

        if (modelId != null) {

            String shopId = shopService.searchByName(shopName);
            if (shopId != null) {

                Object[] ar = penddingDAO.getPendding(shopId, modelId).get(0);

                AdvertiesmentDetail add = new AdvertiesmentDetail();
                ModelDTO md = modelService.searchById(modelId);
                Model m = new Model();
                ShopDTO sd = shopService.searchByID(shopId);
                Owner o = new Owner();
                ModelDetailId mdi = new ModelDetailId();
                Set<Warranty> newList = new HashSet<>();
                ArrayList<WarrantyPenddingDTO> waList = warrantyPendingService.getWarrantyPendding(shopId, modelId);
                if (waList != null) {
                    o.setAdvertiesmentDetails(o.getAdvertiesmentDetails());
                    o.setBranch(sd.getBranch());
                    o.setEmail(sd.getEmail());
                    o.setOwnerName(sd.getOwnerName());
                    o.setPassword(sd.getPassword());
                    o.setPayAdds(sd.getPayAdds());
                    o.setOwnerId(Integer.parseInt(sd.getShopId()));
                    o.setShopImg(sd.getShopImg());
                    o.setShopName(sd.getShopName());
                    o.setUrl(sd.getUrl());

                    m.setAdvertiesmentDetails(md.getAdvertiesmentDetails());
                    m.setBrand(md.getBrand());
                    m.setImgPath_1(md.getImgPath_1());
                    m.setImgPath_2(md.getImgPath_2());
                    m.setImgPath_3(md.getImgPath_3());
                    m.setMaxPrice(md.getMaxPrice());
                    m.setMinPrice(md.getMinPrice());
                    m.setModelId(md.getModelId());
                    m.setModelName_1(md.getModelName_1());
                    m.setModelName_2(md.getModelName_2());
                    m.setModelYear(md.getModelYear());
                    m.setRate(md.getRate());
                    m.setSearchLine(md.getSearchLine());
                    m.setSpecialCategoryName(md.getSpecialCategoryName());
                    m.setSpecifications(md.getSpecifications());
                    m.setStoreCount(md.getStoreCount());

                    mdi.setModelId(m.getModelId());
                    mdi.setOwnerId(o.getOwnerId());

                    add.setOwner(o);
                    add.setModelDetailId(mdi);
                    add.setModel(m);
                    add.setPrice(Double.parseDouble(ar[3].toString()));
                    add.setColor(ar[2].toString());
                    add.setWarrantys(newList);

                    for (int i = 0; i < waList.size(); i++) {
                        WarrantyPenddingDTO wp = waList.get(i);
                        Warranty w = new Warranty();
                       
                        w.setNumOfMonth(wp.getNumOfMonth());
                        w.setAdvertiesmentDetail(add);
                        w.setPrice(wp.getPrice());
                        w.setWarrantyType(wp.getWarrantyType());
                        newList.add(w);

                    }

                    String ans = advertiesmentService.saveAdd(modelId, shopId, ar[2].toString(), ar[3].toString());
                    if (ans.equals("success")) {
                        int count = 0;

                        for (Warranty w : newList) {
                            int val = warrantyService.saveWarranty(w);
                            if (val > 0) {
                                count++;
                            }
                        }
                       
                        if (count == newList.size()) {
                            String val = deletePendding(shopName, modelName);
                            if (val.equals("success")) {
                                return "success";
                            }
                        }
                    }

                }

            }
        }
        return "fail";
    }

}
