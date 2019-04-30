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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Ashan Tharuka
 */
@Entity
public class Payment extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;

    @OneToOne
    @JoinColumn(name = "Pay_Id")
    private PayAdd payAdd;

    private double price;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public PayAdd getPayAdd() {
        return payAdd;
    }

    public void setPayAdd(PayAdd payAdd) {
        this.payAdd = payAdd;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
