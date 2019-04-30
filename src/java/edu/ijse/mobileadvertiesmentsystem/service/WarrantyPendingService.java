/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.dto.WarrantyPenddingDTO;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface WarrantyPendingService {
    public String deleteWarrantyPendding(String modelId,String shopId);
       public ArrayList<WarrantyPenddingDTO> getWarrantyPendding(String shopId,String modelId);
   
}
