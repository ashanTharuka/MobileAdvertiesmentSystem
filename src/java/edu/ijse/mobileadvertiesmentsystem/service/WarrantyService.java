/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.model.Warranty;

/**
 *
 * @author Ashan Tharuka
 */
public interface WarrantyService {
    public int saveWarranty(Warranty warranty);
    public String deleteWarranty(String shopId,String modelId);
    
}
