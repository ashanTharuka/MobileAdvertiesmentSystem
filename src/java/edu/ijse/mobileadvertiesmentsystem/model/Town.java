/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Town extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int townId;

    @OneToOne(mappedBy = "town")
    private Branch branch;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "district_Id",nullable = false)
    private District district;

    private int postalCode;
    
    @Column(name = "townName",nullable = false)
    private String townName;

    public int getTownId() {
        return townId;
    }

    public void setTownId(int townId) {
        this.townId = townId;
    }

 

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

}
