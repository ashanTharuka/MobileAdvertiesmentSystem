/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import com.google.gson.Gson;
import edu.ijse.mobileadvertiesmentsystem.dto.BrandDTO;
import edu.ijse.mobileadvertiesmentsystem.service.BrandService;
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
public class BrandController {
    
    @Autowired
    BrandService brandService;
    
    @RequestMapping(value = "/Brand", method = RequestMethod.GET)
    public String navigation() {
        
        return "Brand";
    }
    
    @RequestMapping(value = "/addBrand", method = RequestMethod.POST)
    public @ResponseBody
    String addBrand(@RequestParam(value = "spName") String spName, @RequestParam(value = "mName") String mName) {
        BrandDTO sp = new BrandDTO();
       
        sp.setBrandName(spName);
        sp.setMainCategoryName(mName);
        return brandService.addBrand(sp);
    }
    
    @RequestMapping(value = "/updateBrand", method = RequestMethod.POST)
    public @ResponseBody
    String updateBrand(@RequestParam(value = "spId") String spId, @RequestParam(value = "spName") String spName, @RequestParam(value = "mName") String mName) {
        BrandDTO s = new BrandDTO();
        s.setId(spId);
        s.setBrandName(spName);
        s.setMainCategoryName(mName);
        return brandService.updateBrand(s);
    }

    @RequestMapping(value = "/deleteBrand", method = RequestMethod.POST)
    public @ResponseBody
    String deleteBrand(@RequestParam(value = "id") String id) {
        return brandService.deleteBrand(id);
    }

    @RequestMapping(value = "/getAllBrand", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAllBrands() {
        
        ArrayList<BrandDTO> list = brandService.getAll();
        
        return new Gson().toJson(list);
        
    }

    @RequestMapping(value = "/selectedBrand", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAllBrandsByMainCategoryName(@RequestParam(value = "mname") String mName) {
        ArrayList<BrandDTO> list = brandService.getAll(mName);
        
        return new Gson().toJson(list);
        
    }
    
    
    
}
