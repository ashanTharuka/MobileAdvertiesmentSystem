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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Ashan Tharuka
 */
@Entity
public class MainCategory extends SuperModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mainCategoryId;

    private String mainCategoryName;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "mainCategorys")
    private Set<Brand> brands = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainCategory")
    private Set<SpecificationType> specificationType;

    public MainCategory() {
    }

    public int getMainCategoryId() {
        return mainCategoryId;
    }

    public void setMainCategoryId(int mainCategoryId) {
        this.mainCategoryId = mainCategoryId;
    }

    public String getMainCategoryName() {
        return mainCategoryName;
    }

    public void setMainCategoryName(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }

    public Set<SpecificationType> getSpecificationType() {
        return specificationType;
    }

    public void setSpecificationType(Set<SpecificationType> specificationType) {
        this.specificationType = specificationType;
    }

    @Override
    public String toString() {
        return "MainCategory{" + "mainCategoryId=" + mainCategoryId + ", mainCategoryName=" + mainCategoryName + ", brands=" + brands + ", specificationType=" + specificationType + '}';
    }

}
