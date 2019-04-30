/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.ShopDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.ShopDTO;
import edu.ijse.mobileadvertiesmentsystem.model.Owner;
import edu.ijse.mobileadvertiesmentsystem.service.ShopService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ashan Tharuka
 */
@Transactional
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDAO shopDAO;

    @Override
    public ShopDTO checkUser(String email, String password) {
        ShopDTO shop = null;
        List<Object[]> list = shopDAO.checkUser(email, password);
        if (list.size() > 0) {
            shop = new ShopDTO();

            for (int i = 0; i < list.size(); i++) {
                Object[] ar = list.get(i);
                shop.setShopId(ar[0].toString());
                shop.setEmail(ar[1].toString());
                shop.setOwnerName(ar[2].toString());
                shop.setPassword(ar[3].toString());
                shop.setShopImg(ar[4].toString());
                System.out.println("shop imge path :::::::::::    " + ar[4].toString());
                shop.setShopName(ar[5].toString());
                shop.setUrl(ar[6].toString());
            }

        }

        return shop;
    }

    @Override
    public ArrayList<ShopDTO> getAll() {

        ArrayList<Owner> list = shopDAO.getAll();
        ArrayList<ShopDTO> shopList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            ShopDTO shop = new ShopDTO();
            Owner ar = list.get(i);

            shop.setShopId(Integer.toString(ar.getOwnerId()));
            shop.setEmail(ar.getEmail());
            shop.setOwnerName(ar.getOwnerName());
            shop.setShopName(ar.getShopName());
            shop.setUrl(ar.getUrl());

            shopList.add(shop);
        }

        return shopList;
    }

    @Override
    public ShopDTO searchByID(String id) {
        Owner o = shopDAO.searchById(id);
        ShopDTO shop = new ShopDTO();

        shop.setAdvertiesmentDetails(o.getAdvertiesmentDetails());
        shop.setBranch(o.getBranch());
        shop.setEmail(o.getEmail());
        shop.setOwnerName(o.getOwnerName());
        shop.setPassword(o.getPassword());
        shop.setPayAdds(o.getPayAdds());
        shop.setShopId(Integer.toString(o.getOwnerId()));
        shop.setShopImg(o.getShopImg());
        shop.setShopName(o.getShopName());
        shop.setUrl(o.getUrl());

        return shop;

    }

    @Override
    public String searchByName(String name) {

        List<Object[]> list = shopDAO.searchByName(name);
        String id = null;

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object[] ar = list.get(i);
                id = ar[0].toString();

            }
            return id;
        } else {

            return null;
        }
    }

    @Override
    public String addShop(ShopDTO shop) {
        Owner o = new Owner();
        o.setEmail(shop.getEmail());
        o.setOwnerName(shop.getOwnerName());
        o.setPassword(shop.getPassword());
        o.setShopName(shop.getShopName());
        o.setShopImg(shop.getShopImg());
        o.setUrl(shop.getUrl());

        Serializable ser = shopDAO.add(o);
        if (ser != null) {
            return "success";
        } else {
            return "fail";

        }
    }

    @Override
    public String updateShop(ShopDTO shop) {
        Owner o = new Owner();
        o.setOwnerId(Integer.parseInt(shop.getShopId()));
        o.setEmail(shop.getEmail());
        o.setPassword(shop.getPassword());
        o.setShopName(shop.getShopName());
        o.setUrl(shop.getUrl());
        o.setShopImg(shop.getShopImg());

        int val = shopDAO.update(o);

        if (val > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    @Override
    public String sendPassword(String email) {
        List<Object[]> list = shopDAO.getPassword(email);
        if (list.size() > 0) {

            for (int i = 0; i < list.size(); i++) {
                Object[] ar = list.get(i);
                return ar[3].toString();
            }
            return "fail";
        } else {
            return "fail";
        }

    }

}
