/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dto;

import edu.ijse.mobileadvertiesmentsystem.model.AdvertiesmentDetail;
import edu.ijse.mobileadvertiesmentsystem.model.Brand;
import edu.ijse.mobileadvertiesmentsystem.model.Specification;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ashan Tharuka
 */
public class ModelDTO implements Serializable {

    private int modelId;

    private Brand brand;
    private String brandName;

    private Set<Specification> specifications = new HashSet<>();

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
    private String mainCategoryName;

    /**
     * @return the modelId
     */
    public int getModelId() {
        return modelId;
    }

    /**
     * @param modelId the modelId to set
     */
    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    /**
     * @return the brand
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * @return the specifications
     */
    public Set<Specification> getSpecifications() {
        return specifications;
    }

    /**
     * @param specifications the specifications to set
     */
    public void setSpecifications(Set<Specification> specifications) {
        this.specifications = specifications;
    }

    /**
     * @return the AdvertiesmentDetails
     */
    public Set<AdvertiesmentDetail> getAdvertiesmentDetails() {
        return AdvertiesmentDetails;
    }

    /**
     * @param AdvertiesmentDetails the AdvertiesmentDetails to set
     */
    public void setAdvertiesmentDetails(Set<AdvertiesmentDetail> AdvertiesmentDetails) {
        this.AdvertiesmentDetails = AdvertiesmentDetails;
    }

    /**
     * @return the modelName_1
     */
    public String getModelName_1() {
        return modelName_1;
    }

    /**
     * @param modelName_1 the modelName_1 to set
     */
    public void setModelName_1(String modelName_1) {
        this.modelName_1 = modelName_1;
    }

    /**
     * @return the modelName_2
     */
    public String getModelName_2() {
        return modelName_2;
    }

    /**
     * @param modelName_2 the modelName_2 to set
     */
    public void setModelName_2(String modelName_2) {
        this.modelName_2 = modelName_2;
    }

    /**
     * @return the specialCategoryName
     */
    public String getSpecialCategoryName() {
        return specialCategoryName;
    }

    /**
     * @param specialCategoryName the specialCategoryName to set
     */
    public void setSpecialCategoryName(String specialCategoryName) {
        this.specialCategoryName = specialCategoryName;
    }

    /**
     * @return the searchLine
     */
    public String getSearchLine() {
        return searchLine;
    }

    /**
     * @param searchLine the searchLine to set
     */
    public void setSearchLine(String searchLine) {
        this.searchLine = searchLine;
    }

   
    /**
     * @return the storeCount
     */
    public int getStoreCount() {
        return storeCount;
    }

    /**
     * @param storeCount the storeCount to set
     */
    public void setStoreCount(int storeCount) {
        this.storeCount = storeCount;
    }

    /**
     * @return the modelYear
     */
    public String getModelYear() {
        return modelYear;
    }

    /**
     * @param modelYear the modelYear to set
     */
    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    /**
     * @return the imgPath_1
     */
    public String getImgPath_1() {
        return imgPath_1;
    }

    /**
     * @param imgPath_1 the imgPath_1 to set
     */
    public void setImgPath_1(String imgPath_1) {
        this.imgPath_1 = imgPath_1;
    }

    /**
     * @return the imgPath_2
     */
    public String getImgPath_2() {
        return imgPath_2;
    }

    /**
     * @param imgPath_2 the imgPath_2 to set
     */
    public void setImgPath_2(String imgPath_2) {
        this.imgPath_2 = imgPath_2;
    }

    /**
     * @return the imgPath_3
     */
    public String getImgPath_3() {
        return imgPath_3;
    }

    /**
     * @param imgPath_3 the imgPath_3 to set
     */
    public void setImgPath_3(String imgPath_3) {
        this.imgPath_3 = imgPath_3;
    }

    /**
     * @return the maxPrice
     */
    public double getMaxPrice() {
        return maxPrice;
    }

    /**
     * @param maxPrice the maxPrice to set
     */
    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * @return the minPrice
     */
    public double getMinPrice() {
        return minPrice;
    }

    /**
     * @param minPrice the minPrice to set
     */
    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * @return the rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(int rate) {
        this.rate = rate;
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
