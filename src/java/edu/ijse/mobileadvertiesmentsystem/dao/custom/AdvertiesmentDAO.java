/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom;

import edu.ijse.mobileadvertiesmentsystem.dao.SuperDAO;
import edu.ijse.mobileadvertiesmentsystem.model.AdvertiesmentDetail;
import edu.ijse.mobileadvertiesmentsystem.model.Pendding;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ashan Tharuka
 */
public interface AdvertiesmentDAO extends SuperDAO<AdvertiesmentDetail> {

    public int deleteAddDetail(String shopId, String modelId);

    public Serializable addPenddniigAdd(Pendding model);

    public Serializable saveAdd(String modelId, String ownerId, String color, String price);
    
    public  List<Object[]> getAllAddByShop(String shopName);
}
