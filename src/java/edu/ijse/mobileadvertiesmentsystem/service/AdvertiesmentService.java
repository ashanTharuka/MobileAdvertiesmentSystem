/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.dto.AddDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.AdvertiesmentDTO;
import edu.ijse.mobileadvertiesmentsystem.model.AdvertiesmentDetail;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashan Tharuka
 */
public interface AdvertiesmentService {

    public ArrayList<AddDTO> getAllAddBySearch();
    
    public String deleteAddDetail(String shopName,String modelName);
    public String saveAdd(AdvertiesmentDTO add);
    public String saveAdd(String modelId,String ownerId,String color,String price);
    public ArrayList<AdvertiesmentDTO> getAllAddByShop(String shopName);
}
