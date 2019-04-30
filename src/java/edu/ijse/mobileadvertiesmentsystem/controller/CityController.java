/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import com.google.gson.Gson;
import edu.ijse.mobileadvertiesmentsystem.dto.TownDTO;
import edu.ijse.mobileadvertiesmentsystem.service.CityService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Ashan Tharuka
 */
@Controller
public class CityController {
    
    @Autowired
    private CityService cityService;
    
    @RequestMapping(value = "/getAllTown", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAllTowns() {
        
        ArrayList<TownDTO> list = cityService.getAllTown();
        
        return new Gson().toJson(list);
        
    }
}
