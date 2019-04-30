/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.dto.BrandDTO;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface BrandService {
     public String addBrand(BrandDTO brand);

    public String updateBrand(BrandDTO brand);

    public BrandDTO searchBrand(String id);

    public String deleteBrand(String id);

    public String isExist(String key, String id);

    public ArrayList<BrandDTO> getAll();

    public ArrayList<BrandDTO> getAll(String mName);
    
    public BrandDTO searchByName(String name);
    
    
}
