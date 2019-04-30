/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import com.google.gson.Gson;
import edu.ijse.mobileadvertiesmentsystem.dto.BranchDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.BrandDTO;
import edu.ijse.mobileadvertiesmentsystem.service.BranchService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BranchController {

    @Autowired
    private BranchService branchService;

    @RequestMapping(value = "/addBranch", method = RequestMethod.POST)
    public @ResponseBody
    String addBranch(@RequestParam(value = "id") String id, @RequestParam(value = "add1") String add1,
            @RequestParam(value = "add2") String add2,
            @RequestParam(value = "city") String city,
            @RequestParam(value = "tel1") String tel1,
            @RequestParam(value = "tel2") String tel2) {
        BranchDTO sp = new BranchDTO();
        sp.setAddressLine1(add1);
        sp.setAddressLine2(add2);
        sp.setCity(city);
        sp.setTel1(tel1);
        sp.setTel2(tel2);
        sp.setOwnerId(id);
        return branchService.addBranch(sp);
    }

    @RequestMapping(value = "/getAllBranch", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAllBrands() {

        ArrayList<BranchDTO> list = branchService.getAll();

        return new Gson().toJson(list);

    }

}
