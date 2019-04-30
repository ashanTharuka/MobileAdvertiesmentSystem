/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Ashan Tharuka
 */
@Entity
public class AddType extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addTypeId;
    
    @OneToOne(mappedBy = "addType")
    private PayAdd payAdd;

    private String size;
    private String addPower;//Paltinum/Gold/Silver
    private String location;
    private int month;
    private double price;

    public int getAddTypeId() {
        return addTypeId;
    }

    public void setAddTypeId(int addTypeId) {
        this.addTypeId = addTypeId;
    }

    public PayAdd getPayAdd() {
        return payAdd;
    }

    public void setPayAdd(PayAdd payAdd) {
        this.payAdd = payAdd;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAddPower() {
        return addPower;
    }

    public void setAddPower(String addPower) {
        this.addPower = addPower;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    

}
