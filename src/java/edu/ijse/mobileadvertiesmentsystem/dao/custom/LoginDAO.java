/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom;

import java.util.List;

/**
 *
 * @author Ashan Tharuka
 */
public interface LoginDAO {
    public  List<Object[]> checkUser(String email, String password);
    public List<Object[]> getPassword(String email);
}
