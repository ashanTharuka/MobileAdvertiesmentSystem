/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.dto.MainCategoryDTO;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface MainCategoryService {

    public String addMainCategory(MainCategoryDTO mainCategory);

    public String updateMainCategory(MainCategoryDTO mainCategory);

    public MainCategoryDTO searchMainCategory(String id);

    public String deleteMainCategory(String id);

    public String isExist(String key, String id);

    public ArrayList<MainCategoryDTO> getAll();

    public MainCategoryDTO searchByName(String name);
}
