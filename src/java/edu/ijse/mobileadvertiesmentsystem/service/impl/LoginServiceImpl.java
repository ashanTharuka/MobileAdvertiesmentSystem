/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.LoginDAO;
import edu.ijse.mobileadvertiesmentsystem.dao.custom.ShopDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.AdminDTO;
import edu.ijse.mobileadvertiesmentsystem.service.LoginService;
import edu.ijse.mobileadvertiesmentsystem.util.Email;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ashan Tharuka
 */
@Transactional
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDAO loginDAO;

    @Autowired
    private ShopDAO shopDAO;

    @Override
    public AdminDTO checkUser(String email, String password) {
        AdminDTO admin = null;

        List<Object[]> list = loginDAO.checkUser(email, password);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("id :::::::::::::::::: " + list.get(i)[0]);
            System.out.println("email :::::::::::::::::: " + list.get(i)[2]);
            System.out.println("name :::::::::::::::::: " + list.get(i)[1]);
            System.out.println("password :::::::::::::::::: " + list.get(i)[3]);
//            System.out.println("name :::::::::::::::::: "+list.get(i)[3]);
        }

        if (list.size() > 0) {
            admin = new AdminDTO();

            for (int i = 0; i < list.size(); i++) {
                Object[] ar = list.get(i);
                admin.setAdminId(Integer.parseInt(ar[0].toString()));
                admin.setEmail(ar[2].toString());
                admin.setAdminName(ar[1].toString());
                admin.setPassword(ar[3].toString());
                System.out.println("email : " + admin.getEmail());
                System.out.println("password : " + admin.getPassword());
            }
        }
        return admin;
    }

    @Override
    public String sendPassword(String email) {

        List<Object[]> list = shopDAO.getPassword(email);
        String password = "";
        if (list.size() > 0) {

            for (int i = 0; i < list.size(); i++) {
                Object[] ar = list.get(i);
                password = ar[3].toString();
            }

        } else {
            List<Object[]> list2 = loginDAO.getPassword(email);
            for (int i = 0; i < list2.size(); i++) {
                Object[] ar = list2.get(i);
                password = ar[3].toString();
            }
        }
        boolean isTrue = false;
        if (password != null) {
            try {
                isTrue = Email.generateAndSendEmail(email, password);
            } catch (MessagingException ex) {
                Logger.getLogger(LoginServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return "fail";
        }
        
        if (isTrue) {
            return "success";
        } else {
            return "fail";
        }
    }

}
