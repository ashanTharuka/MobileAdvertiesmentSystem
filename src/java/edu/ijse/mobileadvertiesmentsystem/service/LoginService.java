/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.dto.AdminDTO;

/**
 *
 * @author Ashan Tharuka
 */
public interface LoginService {
     public AdminDTO checkUser(String email,String password);
     public String sendPassword(String email);
}
