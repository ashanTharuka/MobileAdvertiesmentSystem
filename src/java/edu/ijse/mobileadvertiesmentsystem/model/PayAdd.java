/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Ashan Tharuka
 */
@Entity
public class PayAdd extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int payAddId;

    @ManyToOne(cascade = CascadeType.ALL)
    private Owner owner;

    @OneToOne(mappedBy = "payAdd")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "addType_Id")
    private AddType addType;
    
    private String imgPath;

    public int getPayAddId() {
        return payAddId;
    }

    public void setPayAddId(int payAddId) {
        this.payAddId = payAddId;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public AddType getAddType() {
        return addType;
    }

    public void setAddType(AddType addType) {
        this.addType = addType;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
