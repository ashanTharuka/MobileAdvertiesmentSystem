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
import javax.persistence.ManyToOne;

/**
 *
 * @author Ashan Tharuka
 */
@Entity
public class Warranty extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int warrantyId;
    
    @ManyToOne
    private AdvertiesmentDetail advertiesmentDetail;

    private String warrantyType;
    private String numOfMonth;
    private double price;

    

    public int getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(int warrantyId) {
        this.warrantyId = warrantyId;
    }

    public String getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(String warrantyType) {
        this.warrantyType = warrantyType;
    }

    public String getNumOfMonth() {
        return numOfMonth;
    }

    public void setNumOfMonth(String numOfMonth) {
        this.numOfMonth = numOfMonth;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public AdvertiesmentDetail getAdvertiesmentDetail() {
        return advertiesmentDetail;
    }

    public void setAdvertiesmentDetail(AdvertiesmentDetail advertiesmentDetail) {
        this.advertiesmentDetail = advertiesmentDetail;
    }

    

}
