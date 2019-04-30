/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dto;

import edu.ijse.mobileadvertiesmentsystem.model.Town;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ashan Tharuka
 */
public class DistrictDTO {

    private int districtId;
    private String districtCode;
    private String disctrictName;

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
