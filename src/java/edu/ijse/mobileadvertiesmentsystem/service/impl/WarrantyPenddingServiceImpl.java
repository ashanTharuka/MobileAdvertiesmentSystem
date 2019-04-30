/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.ijse.mobileadvertiesmentsystem.dao.custom.WarrantyPenddingDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.WarrantyPenddingDTO;
import edu.ijse.mobileadvertiesmentsystem.model.WarrantyPendding;
import edu.ijse.mobileadvertiesmentsystem.service.WarrantyPendingService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashan Tharuka
 */
@Transactional
@Service
public class WarrantyPenddingServiceImpl implements WarrantyPendingService {

    @Autowired
    private WarrantyPenddingDAO warrantyPenddingDAO;

    @Override
    public String deleteWarrantyPendding(String modelId, String shopId) {
        int val = warrantyPenddingDAO.deleteWarrantyPendding(modelId, shopId);
        if (val > 0) {
            return "success";
        } else {
            return "fail";
        }

    }

    @Override
    public ArrayList<WarrantyPenddingDTO> getWarrantyPendding(String shopId, String modelId) {
        List<Object[]> list = warrantyPenddingDAO.getWarrantyPendding(shopId, modelId);

        ArrayList<WarrantyPenddingDTO> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Object[] ar = list.get(i);
            WarrantyPenddingDTO w = new WarrantyPenddingDTO();
            w.setNumOfMonth(ar[1].toString());
            w.setPrice(Double.parseDouble(ar[2].toString()));
            w.setWarrantyType(ar[3].toString());
            newList.add(w);

        }
        System.out.println("ccccccccccccccccccccccccccccccc ++++++ "+newList.size());
        System.out.println("ccccccccccccccccccccccccccccccc ++++++ "+newList.size());
        System.out.println("ccccccccccccccccccccccccccccccc ++++++ "+newList.size());
      

        System.out.println("/////////////////////////////////");

        return newList;
    }

}
