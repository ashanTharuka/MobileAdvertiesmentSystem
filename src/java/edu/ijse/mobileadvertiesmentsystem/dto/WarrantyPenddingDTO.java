/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dto;

import edu.ijse.mobileadvertiesmentsystem.model.Pendding;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ashan Tharuka
 */
public class WarrantyPenddingDTO implements Serializable {

 private int WarrantyPenddingId;
    private Pendding pendding;
    private String warrantyType;
    private String numOfMonth;
    private double price;

   

    public Pendding getPendding() {
        return pendding;
    }

    public void setPendding(Pendding pendding) {
        this.pendding = pendding;
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

    public int getWarrantyPenddingId() {
        return WarrantyPenddingId;
    }

    public void setWarrantyPenddingId(int WarrantyPenddingId) {
        this.WarrantyPenddingId = WarrantyPenddingId;
    }

}
