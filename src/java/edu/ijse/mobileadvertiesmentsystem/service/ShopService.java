/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.dto.ShopDTO;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface ShopService {

    public ShopDTO checkUser(String email, String password);

    public ArrayList<ShopDTO> getAll();

    public ShopDTO searchByID(String id);

    public String addShop(ShopDTO shop);

    public String searchByName(String name);

    public String sendPassword(String email);

    public String updateShop(ShopDTO shop);
}
