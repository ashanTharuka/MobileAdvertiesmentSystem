/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import edu.ijse.mobileadvertiesmentsystem.dto.AdminDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.BrandDTO;
import edu.ijse.mobileadvertiesmentsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ashan Tharuka
 */
@Controller
@Scope(value = "application")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/Admin", method = RequestMethod.GET)
    public String navigation() {

        return "Admin";
    }

  

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public @ResponseBody
    String addAdmin(Model model) {

        return "";
    }

    @RequestMapping(value = "/updateAdmin", method = RequestMethod.POST)
    public @ResponseBody
    String updateAdmin(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name, @RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        AdminDTO admin = new AdminDTO();
        admin.setAdminId(Integer.parseInt(id.trim()));
        admin.setAdminName(name);
        admin.setEmail(email);
        admin.setPassword(password);

        return adminService.updateAdmin(admin);

    }

}
