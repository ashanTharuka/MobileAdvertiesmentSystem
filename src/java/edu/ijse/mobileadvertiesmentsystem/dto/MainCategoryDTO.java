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
public class MainCategoryDTO implements Serializable{

    private String id;
    private String mainCategoryName;

    public MainCategoryDTO() {
    }
    public MainCategoryDTO(String mainCategoryName) {
        this.mainCategoryName=mainCategoryName;
    }

    public MainCategoryDTO(String id, String mainCategoryName) {
        this.id = id;
        this.mainCategoryName = mainCategoryName;
    }

    public String getMainCategoryName() {
        return mainCategoryName;
    }

    public void setMainCategoryName(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
