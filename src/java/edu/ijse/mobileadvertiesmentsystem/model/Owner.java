
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
public class Owner extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ownerId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Branch> branch = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<AdvertiesmentDetail> AdvertiesmentDetails = new HashSet<>();


    @OneToMany(mappedBy = "owner")
    private Set<PayAdd> payAdds = new HashSet<>();

    
    private String ownerName;
    private String shopName;
    private String email;
    private String url;
    private String shopImg;
    private String password;

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

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }


    public Set<PayAdd> getPayAdds() {
        return payAdds;
    }

    public void setPayAdds(Set<PayAdd> payAdds) {
        this.payAdds = payAdds;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    
}
