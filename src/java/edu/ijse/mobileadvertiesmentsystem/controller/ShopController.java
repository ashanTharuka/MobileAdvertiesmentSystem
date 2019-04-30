/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import com.google.gson.Gson;
import edu.ijse.mobileadvertiesmentsystem.dto.ShopDTO;
import edu.ijse.mobileadvertiesmentsystem.service.ShopService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ashan Tharuka
 */
@Controller
public class ShopController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/Shop", method = RequestMethod.GET)
    public String navigation() {
        return "Shop";
    }

    @RequestMapping(value = "/Customer_Dashbord", method = RequestMethod.GET)
    public String customerDashBoard() {
        return "Customer_Dashbord";
    }

    @RequestMapping(value = "/Congratz", method = RequestMethod.GET)
    public String navigationa() {
        return "Congratz";
    }

    @RequestMapping(value = "/getAllShops", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAll() {

        ArrayList<ShopDTO> list = shopService.getAll();
        Gson g = new Gson();
        return g.toJson(list);

    }

    @RequestMapping(value = "/register-shop", method = RequestMethod.POST)
    public ModelAndView navishop(@RequestParam("image") MultipartFile image, @RequestParam(value = "oname") String oname,
            @RequestParam(value = "bname") String bname,
            @RequestParam(value = "be") String be,
            @RequestParam(value = "web") String web,
            @RequestParam(value = "pwd") String pwd) {

//        File F1 = new File("C:/Users/Ashan Tharuka/Desktop/File Upload/Shop/"+bname+"/");
//        F1.mkdirs();
        File F1 = new File("E:\\My_Project\\Project UI vertions\\MobileAdvertiesmentSystem\\web\\static\\SystemPhoto\\Shop\\" + bname + "\\");
        F1.mkdirs();
//   
        String fileName = image.getOriginalFilename();
//        File uploadFile = new File("C:/Users/Ashan Tharuka/Desktop/File Upload/Shop/"+bname+"/" + fileName);
        File uploadFile = new File("E:\\My_Project\\Project UI vertions\\MobileAdvertiesmentSystem\\web\\static\\SystemPhoto\\Shop\\" + bname + "\\" + fileName);
        String path = "static\\SystemPhoto\\Shop\\" + bname + "\\" + fileName;

        System.out.println("Path ::::::::::::::  " + path);
        String absolutePath = uploadFile.getAbsolutePath();
        System.out.println("absolutePath :::::::::::;;  " + absolutePath);

        try {
            image.transferTo(uploadFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }

        ShopDTO s = new ShopDTO();
        s.setOwnerName(oname);
        s.setEmail(be);
        s.setPassword(pwd);
        s.setShopImg(path);
        s.setShopName(bname);
        s.setUrl(web);

        String ans = shopService.addShop(s);

        if (ans.equals("success")) {
            return new ModelAndView("Congratz");
        } else {
            return new ModelAndView("Register");
        }

    }

    @RequestMapping(value = "/update-shop", method = RequestMethod.POST)
    public String updateShop(@RequestParam("image") MultipartFile image, @RequestParam(value = "id") String id,
            @RequestParam(value = "shopName") String shopName,
            @RequestParam(value = "url") String url,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "pass") String pass) {

//        File F1 = new File("C:/Users/Ashan Tharuka/Desktop/File Upload/Shop/"+bname+"/");
//        F1.mkdirs();
        File F1 = new File("E:\\My_Project\\Project UI vertions\\MobileAdvertiesmentSystem\\web\\static\\SystemPhoto\\Shop\\"+shopName.trim() +"\\");
        F1.mkdirs();
//   
        String fileName = image.getOriginalFilename();
//        File uploadFile = new File("C:/Users/Ashan Tharuka/Desktop/File Upload/Shop/"+bname+"/" + fileName);
       File uploadFile = new File("E:\\My_Project\\Project UI vertions\\MobileAdvertiesmentSystem\\web\\static\\SystemPhoto\\Shop\\"+shopName.trim() +"\\"+fileName.trim());
        String path = "static\\SystemPhoto\\Shop\\" + shopName.trim() + "\\" + fileName.trim();

        System.out.println("Path ::::::::::::::  " + path);
        String absolutePath = uploadFile.getAbsolutePath();
        System.out.println("absolutePath :::::::::::;;  " + absolutePath);

        try {
            image.transferTo(uploadFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        }

        ShopDTO s = new ShopDTO();
        s.setEmail(email);
        s.setPassword(pass);
        s.setShopImg(path);
        s.setShopName(shopName);
        s.setUrl(url);
        s.setShopId(id.trim());

        String ans = shopService.updateShop(s);

        if (ans.equals("success")) {
            return  ("Customer_Shop");
        } else {
            return ("Customer_Shop");
        }

    }

}
