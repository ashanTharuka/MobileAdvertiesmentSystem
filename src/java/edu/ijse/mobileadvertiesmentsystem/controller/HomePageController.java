/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author student
 */
@Transactional
@Controller
public class HomePageController {

    @RequestMapping(value = "/Customer_Shop")
    public String Customer_Shop() {

        return "Customer_Shop";
    }

    @RequestMapping(value = "/Customer_Branch")
    public String Customer_Branch() {

        return "Customer_Branch";
    }

    @RequestMapping(value = "/Customer_Advertiesment")
    public String Customer_Advertiesment() {

        return "Customer_Advertiesment";
    }

}
