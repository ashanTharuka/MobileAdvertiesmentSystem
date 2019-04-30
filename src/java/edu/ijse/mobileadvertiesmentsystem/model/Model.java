/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Ashan Tharuka
 */
@Entity
public class Model extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int modelId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_Id")
    private Brand brand;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private Set<Specification> specifications = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private Set<AdvertiesmentDetail> AdvertiesmentDetails = new HashSet<>();

  
    private String modelName_1;
    private String modelName_2;
    private String specialCategoryName;// Ex: (laptop),(tv)
    private String searchLine;// every detail included

    private int storeCount;
    private String modelYear;
    private String imgPath_1;//default img
    private String imgPath_2;
    private String imgPath_3;
    private double maxPrice;
    private double minPrice;
    private int rate;

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModelName_1() {
        return modelName_1;
    }

    public void setModelName_1(String modelName_1) {
        this.modelName_1 = modelName_1;
    }

    public String getModelName_2() {
        return modelName_2;
    }

    public void setModelName_2(String modelName_2) {
        this.modelName_2 = modelName_2;
    }

    public int getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(int storeCount) {
        this.storeCount = storeCount;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getImgPath_1() {
        return imgPath_1;
    }

    public void setImgPath_1(String imgPath_1) {
        this.imgPath_1 = imgPath_1;
    }

    public String getImgPath_2() {
        return imgPath_2;
    }

    public void setImgPath_2(String imgPath_2) {
        this.imgPath_2 = imgPath_2;
    }

    public String getImgPath_3() {
        return imgPath_3;
    }

    public void setImgPath_3(String imgPath_3) {
        this.imgPath_3 = imgPath_3;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Set<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Set<Specification> specifications) {
        this.specifications = specifications;
    }

    public Set<AdvertiesmentDetail> getAdvertiesmentDetails() {
        return AdvertiesmentDetails;
    }

    public void setAdvertiesmentDetails(Set<AdvertiesmentDetail> AdvertiesmentDetails) {
        this.AdvertiesmentDetails = AdvertiesmentDetails;
    }

    public String getSearchLine() {
        return searchLine;
    }

    public void setSearchLine(String searchLine) {
        this.searchLine = searchLine;
    }

    public String getSpecialCategoryName() {
        return specialCategoryName;
    }

    public void setSpecialCategoryName(String specialCategoryName) {
        this.specialCategoryName = specialCategoryName;
    }


}
