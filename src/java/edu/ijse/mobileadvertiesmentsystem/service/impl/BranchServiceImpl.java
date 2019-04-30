/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.BranchDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.BranchDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.DistrictDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.ShopDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.TownDTO;
import edu.ijse.mobileadvertiesmentsystem.model.Branch;
import edu.ijse.mobileadvertiesmentsystem.model.District;
import edu.ijse.mobileadvertiesmentsystem.model.Owner;
import edu.ijse.mobileadvertiesmentsystem.model.Town;
import edu.ijse.mobileadvertiesmentsystem.service.BranchService;
import edu.ijse.mobileadvertiesmentsystem.service.CityService;
import edu.ijse.mobileadvertiesmentsystem.service.DistrictService;
import edu.ijse.mobileadvertiesmentsystem.service.ShopService;
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
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchDAO branchDAO;

    @Autowired
    private CityService cityService;

    @Autowired
    private ShopService shopService;
    
    @Autowired
    private DistrictService districtService;

    @Override
    public String addBranch(BranchDTO dto) {

        TownDTO town = cityService.searchByName(dto.getCity());
        ShopDTO shop = shopService.searchByID(dto.getOwnerId());
        
        
        System.out.println("ddddddddddddd : "+town.getDistrictId());
        DistrictDTO dis = districtService.getDistrict(town.getDistrictId());
        
        District d=new District();
        d.setDisctrictName(dis.getDisctrictName());
        d.setDistrictCode(dis.getDistrictCode());
        d.setDistrictId(dis.getDistrictId());
        d.setTowns(dis.getTowns());
        
        
        
        
        Owner o = new Owner();
        o.setEmail(shop.getEmail());
        o.setOwnerId(Integer.parseInt(shop.getShopId()));
        o.setOwnerName(shop.getOwnerName());
        o.setPassword(shop.getPassword());
        o.setShopImg(shop.getShopImg());
        o.setUrl(shop.getUrl());

        Town t = new Town();
        t.setDistrict(town.getDistrict());
        t.setPostalCode(town.getPostalCode());
        t.setTownId(town.getTownId());
        t.setTownName(town.getTownName());
        t.setDistrict(d);

        Branch b = new Branch();
        b.setTown(t);
        b.setAddressLine1(dto.getAddressLine1());
        b.setAddressLine2(dto.getAddressLine2());
        b.setCity(dto.getCity());
        b.setTel1(dto.getTel1());
        b.setTel2(dto.getTel2());
        b.setOwner(o);
        
        

        int val = branchDAO.insertBranch(b);
        if (val>0) {
            return "success";
        } else {
            return "fail";
        }
    }

    @Override
    public ArrayList<BranchDTO> getAll() {
        List<Object[]> list = branchDAO.searchByName("");
          

        ArrayList<BranchDTO> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Object[] ar = list.get(i);
            BranchDTO s = new BranchDTO();
            s.setBranchId(Integer.parseInt(ar[0].toString()));
            s.setCity(ar[3].toString());
            s.setTel1(ar[4].toString());
            s.setTel2(ar[5].toString());
            s.setAddressLine1(ar[1].toString());
            s.setAddressLine2(ar[2].toString());
            newList.add(s);
        }

        return newList;
       
    }

}
