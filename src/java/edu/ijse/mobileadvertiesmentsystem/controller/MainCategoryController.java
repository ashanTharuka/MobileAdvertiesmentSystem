/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import com.google.gson.Gson;
import edu.ijse.mobileadvertiesmentsystem.dto.MainCategoryDTO;
import edu.ijse.mobileadvertiesmentsystem.service.MainCategoryService;
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
public class MainCategoryController {

    @Autowired
    private MainCategoryService mainCategoryService;

    @RequestMapping(value = "/MainCategory", method = RequestMethod.GET)
    public String navigation() {

        return "MainCategory";
    }

    @RequestMapping(value = "/addMainCategory", method = RequestMethod.POST)
    public @ResponseBody
    String addMainCategory(@RequestParam(value = "name") String name) {
        MainCategoryDTO m = new MainCategoryDTO(name);
        return mainCategoryService.addMainCategory(m);
    }

    @RequestMapping(value = "/updateMainCategory", method = RequestMethod.POST)
    public @ResponseBody
    String updateMainCategory(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name) {
        MainCategoryDTO m = new MainCategoryDTO(id, name);
        return mainCategoryService.updateMainCategory(m);
    }

    @RequestMapping(value = "/deleteMainCategory", method = RequestMethod.POST)
    public @ResponseBody
    String deleteMainCategory(@RequestParam(value = "id") String id) {
        return mainCategoryService.deleteMainCategory(id);
    }

    @RequestMapping(value = "/getAllMainCategory", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAllMainCategory() {

        ArrayList<MainCategoryDTO> list = mainCategoryService.getAll();

        return new Gson().toJson(list);

    }

}
