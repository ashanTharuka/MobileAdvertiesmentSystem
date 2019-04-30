/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.WarrantyDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Warranty;
import edu.ijse.mobileadvertiesmentsystem.service.WarrantyService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ashan Tharuka
 */
@Transactional
@Service
public class WarrantyServiceImpl implements WarrantyService {

    @Autowired
    private WarrantyDAO warrantyDAO;

    @Override
    public int saveWarranty(Warranty warranty) {

        Serializable ser = warrantyDAO.add(warranty);
        if (ser != null) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public String deleteWarranty(String shopId, String modelId) {
        int val = warrantyDAO.deleteWaranty(shopId, modelId);

        if (val > 0) {
            return "success";
        } else {
            return "fail";
        }
    }
}
