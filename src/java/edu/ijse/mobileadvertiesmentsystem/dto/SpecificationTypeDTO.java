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
public class SpecificationTypeDTO implements Serializable{

    private int specificationTypeId;
    private String specificationType;
    private String mainCategoryName;

    public SpecificationTypeDTO() {
    }

    public SpecificationTypeDTO(int specificationTypeId, String specificationType, String mainCategoryName) {
        this.specificationTypeId = specificationTypeId;
        this.specificationType = specificationType;
        this.mainCategoryName = mainCategoryName;
    }

    public int getSpecificationTypeId() {
        return specificationTypeId;
    }

    public void setSpecificationTypeId(int specificationTypeId) {
        this.specificationTypeId = specificationTypeId;
    }

    public String getSpecificationType() {
        return specificationType;
    }

    public void setSpecificationType(String specificationType) {
        this.specificationType = specificationType;
    }

    public String getMainCategoryName() {
        return mainCategoryName;
    }

    public void setMainCategoryName(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }
    
}
