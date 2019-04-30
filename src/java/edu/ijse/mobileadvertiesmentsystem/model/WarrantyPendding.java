/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

/**
 *
 * @author Ashan Tharuka
 */
@Entity
public class WarrantyPendding extends SuperModel implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int WarrantyPenddingId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Pendding pendding;

    private String warrantyType;
    private String numOfMonth;
    private double price;

 
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

    public Pendding getPendding() {
        return pendding;
    }

    public void setPendding(Pendding pendding) {
        this.pendding = pendding;
    }

    public void setWarrantyPenddingId(int WarrantyPenddingId) {
        this.WarrantyPenddingId = WarrantyPenddingId;
    }

  

}
