/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import com.google.gson.Gson;
import edu.ijse.mobileadvertiesmentsystem.dto.AddDTO;
import edu.ijse.mobileadvertiesmentsystem.service.PenddingService;
import java.util.ArrayList;
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
@Controller
@Scope(value = "application")
public class PenddingController {

    @Autowired
    private PenddingService penddingService;
    
    @RequestMapping(value = "/Pendding", method = RequestMethod.GET)
    public String navigation() {

        return "Pendding";
    }
    
    
    
     @RequestMapping(value = "/AllPenddingAds", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAllpenddingAds() {
  
        ArrayList<AddDTO> list = penddingService.getAllPenddingSearch();

        Gson g = new Gson();
        return g.toJson(list);
    }
    
    
    @RequestMapping(value = "/deletePendding", method = RequestMethod.POST)
    public @ResponseBody
    String deletePendding(@RequestParam(value = "shopName") String shopName, @RequestParam(value = "modelName") String modelName) {

     return penddingService.deletePendding(shopName, modelName);

    }
    @RequestMapping(value = "/acceptPendding", method = RequestMethod.POST)
    public @ResponseBody
    String acceptPendding(@RequestParam(value = "shopName") String shopName, @RequestParam(value = "modelName") String modelName) {

        
        System.out.println("acceptPendding callllllllllllllllllllllllllll");
        
        
     return penddingService.acceptPennding(shopName, modelName);

    }
}
