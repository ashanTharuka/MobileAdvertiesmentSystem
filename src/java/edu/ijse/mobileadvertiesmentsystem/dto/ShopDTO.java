/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dto;

import edu.ijse.mobileadvertiesmentsystem.model.AdvertiesmentDetail;
import edu.ijse.mobileadvertiesmentsystem.model.Branch;
import edu.ijse.mobileadvertiesmentsystem.model.PayAdd;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ashan Tharuka
 */
public class ShopDTO implements Serializable {

    private String shopId;
    private Set<Branch> branch = new HashSet<>();
    private Set<AdvertiesmentDetail> AdvertiesmentDetails = new HashSet<>();
    private Set<PayAdd> payAdds = new HashSet<>();
    private String ownerName;
    private String shopName;
    private String email;
    private String url;
    private String shopImg;
    private String password;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Set<Branch> getBranch() {
        return branch;
    }

    public void setBranch(Set<Branch> branch) {
        this.branch = branch;
    }

    public Set<AdvertiesmentDetail> getAdvertiesmentDetails() {
        return AdvertiesmentDetails;
    }

    public void setAdvertiesmentDetails(Set<AdvertiesmentDetail> AdvertiesmentDetails) {
        this.AdvertiesmentDetails = AdvertiesmentDetails;
    }

    public Set<PayAdd> getPayAdds() {
        return payAdds;
    }

    public void setPayAdds(Set<PayAdd> payAdds) {
        this.payAdds = payAdds;
    }
}
