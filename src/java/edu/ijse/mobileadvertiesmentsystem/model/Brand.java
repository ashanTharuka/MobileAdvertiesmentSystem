/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Ashan Tharuka
 */
@Entity
public class Brand extends SuperModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int brandId;
    private String brandName;

    @ManyToMany
    @JoinTable(name = "brand_detail", joinColumns = {
        @JoinColumn(name = "brand_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "mainCategory_id", nullable = false, updatable = false)}
    )
    private Set<MainCategory> mainCategorys = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private Set<Model> models = new HashSet<>();

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Set<MainCategory> getMainCategorys() {
        return mainCategorys;
    }

    public void setMainCategorys(Set<MainCategory> mainCategorys) {
        this.mainCategorys = mainCategorys;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        return "Brand{" + "brandId=" + brandId + ", brandName=" + brandName + ", mainCategorys=" + mainCategorys + ", models=" + models + '}';
    }

    
}
