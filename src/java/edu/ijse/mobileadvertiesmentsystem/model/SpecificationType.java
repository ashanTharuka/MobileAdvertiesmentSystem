/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ashan Tharuka
 */
@Entity
public class SpecificationType extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int specificationTypeId;
    private String specificationType;
   

    @ManyToOne
    @JoinColumn(name = "mainCategory_Id",nullable = false)
    private MainCategory mainCategory;

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


    public MainCategory getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(MainCategory mainCategory) {
        this.mainCategory = mainCategory;
    }

}
