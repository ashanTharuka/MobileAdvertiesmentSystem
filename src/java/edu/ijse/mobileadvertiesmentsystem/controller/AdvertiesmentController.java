/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import com.google.gson.Gson;
import edu.ijse.mobileadvertiesmentsystem.dto.AddDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.AdvertiesmentDTO;
import edu.ijse.mobileadvertiesmentsystem.service.AdvertiesmentService;
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
public class AdvertiesmentController {

    @Autowired
    private AdvertiesmentService adService;

    @RequestMapping(value = "/Advertiesment", method = RequestMethod.GET)
    public String navigation() {

        return "Advertiesment";
    }

    @RequestMapping(value = "/AllAddBySearch", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAllAddBySearch() {
        ArrayList<AddDTO> list = adService.getAllAddBySearch();

        Gson g = new Gson();
        return g.toJson(list);
    }

    @RequestMapping(value = "/deleteAddDetail", method = RequestMethod.POST)
    public @ResponseBody
    String deleteBrand(@RequestParam(value = "shopName") String shopName, @RequestParam(value = "modelName") String modelName) {

        String ans = adService.deleteAddDetail(shopName, modelName);

        return ans;
    }

    @RequestMapping(value = "/getAllAddsByShop", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String getAllAddsByShop(@RequestParam(value = "shopName") String shopName) {

        ArrayList<AdvertiesmentDTO> list = adService.getAllAddByShop(shopName);
        Gson g = new Gson();
        return g.toJson(list);
    }

    @RequestMapping(value = "/addAdddvertiesment", method = RequestMethod.POST)
    public @ResponseBody
    String addAdddvertiesment(@RequestParam(value = "s") String shop, @RequestParam(value = "m") String mName,
            @RequestParam(value = "c") String c, @RequestParam(value = "p") String p, @RequestParam(value = "wa") String wa, @RequestParam(value = "mo") String mo, @RequestParam(value = "mp") String mp) {

        AdvertiesmentDTO add = new AdvertiesmentDTO();
        add.setColor(c);
        add.setModelName(mName);
        add.setMonth(mo);
        add.setPrice(Double.parseDouble(p));
        add.setShopName(shop);
        add.setWarrantyType(wa);
        add.setmPrice(mp);

        return adService.saveAdd(add);

    }

}
