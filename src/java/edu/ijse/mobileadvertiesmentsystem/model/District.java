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
import javax.persistence.OneToMany;

/**
 *
 * @author Ashan Tharuka
 */
@Entity
public class District extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
            
    private int districtId;
    private String districtCode;
    private String disctrictName;

    @OneToMany(mappedBy = "district",cascade = CascadeType.ALL)
    private Set<Town> towns = new HashSet<>();

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDisctrictName() {
        return disctrictName;
    }

    public void setDisctrictName(String disctrictName) {
        this.disctrictName = disctrictName;
    }

    public Set<Town> getTowns() {
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }
    
    
}
