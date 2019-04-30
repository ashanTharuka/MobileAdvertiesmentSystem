/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.dto.AddDTO;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface PenddingService {
       public ArrayList<AddDTO> getAllPenddingSearch();
       public String deletePendding(String shopName,String modelName);
       public String acceptPennding(String shopName,String modelName);
}
