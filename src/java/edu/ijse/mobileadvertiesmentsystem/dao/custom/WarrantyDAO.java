/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom;

import edu.ijse.mobileadvertiesmentsystem.dao.SuperDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Warranty;

/**
 *
 * @author Ashan Tharuka
 */
public interface WarrantyDAO extends SuperDAO<Warranty>{
    public int deleteWaranty(String shopId,String modelId);
}
