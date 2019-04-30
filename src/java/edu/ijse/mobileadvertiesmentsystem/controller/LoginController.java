/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import edu.ijse.mobileadvertiesmentsystem.dto.AdminDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.ShopDTO;
import edu.ijse.mobileadvertiesmentsystem.service.LoginService;
import edu.ijse.mobileadvertiesmentsystem.service.ShopService;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ashan Tharuka
 */
@Scope("session")
@Controller
public class LoginController implements Serializable{

    private HttpSession ss;
    @Autowired
    private LoginService loginService;

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    String login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password, HttpServletRequest request) {
        ss = request.getSession();

        AdminDTO admin = loginService.checkUser(email, password);
        ShopDTO shop = shopService.checkUser(email, password);
        
        if (admin != null) {
            ss.setAttribute("name", admin.getAdminName());
            ss.setAttribute("email", admin.getEmail());
            ss.setAttribute("adminId", Integer.toString(admin.getAdminId()));
           
            return "admin";
        } else if (shop != null) {
            ss.setAttribute("shop", shop.getShopName());
            ss.setAttribute("path", shop.getShopImg());
            ss.setAttribute("email", shop.getEmail());
            ss.setAttribute("url", shop.getUrl());
            ss.setAttribute("id",shop.getShopId());
            System.out.println("name :::::::::: " +shop.getShopName());
            System.out.println("path :::::::::: " +shop.getShopImg());
            return "shop";
        } else {
            return "noOne";
        }
    }

    @RequestMapping(value = "/sessionDelete", method = RequestMethod.GET)
    public @ResponseBody
    String sessionDelete(@RequestParam(value = "name") String name, HttpServletRequest request) {

        ss.removeAttribute("name");
        ss.removeAttribute("email");
        ss.removeAttribute("adminId");

        if (null == ss.getAttribute("name") && null == ss.getAttribute("email") && null == ss.getAttribute("adminId")) {
            return "success";
        }
        return "fail";
    }
    @RequestMapping(value = "/forgotPass", method = RequestMethod.POST)
    public @ResponseBody
    String forgotPass(@RequestParam(value = "email") String email) {

        return loginService.sendPassword(email);
       
    }
    @RequestMapping(value = "/sessionDeleteShop", method = RequestMethod.GET)
    public @ResponseBody
    String sessionDeleteShop(@RequestParam(value = "name") String name, HttpServletRequest request) {

        ss.removeAttribute("shop");
        ss.removeAttribute("path");
        ss.removeAttribute("email");
        ss.removeAttribute("url");
        ss.removeAttribute("id");

        if (null == ss.getAttribute("shop") && null == ss.getAttribute("path") && null == ss.getAttribute("email")) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping(value = "/logInAdminPage", method = RequestMethod.GET)
    public String navigation() {
        return "Admin";
    }

}
