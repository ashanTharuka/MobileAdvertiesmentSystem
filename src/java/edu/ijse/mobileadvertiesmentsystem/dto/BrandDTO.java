/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dto;

import java.io.Serializable;

/**
 *
 * @author Ashan Tharuka
 */
public class BrandDTO implements Serializable{

    private String id;
    private String brandName;
    private String mainCategoryName;

    public BrandDTO() {
    }

    public BrandDTO(String id, String brandName, String mainCategoryName) {
        this.id = id;
        this.brandName = brandName;
        this.mainCategoryName = mainCategoryName;
    }

 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getMainCategoryName() {
        return mainCategoryName;
    }

    public void setMainCategoryName(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

}
