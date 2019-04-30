/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import com.google.gson.Gson;
import edu.ijse.mobileadvertiesmentsystem.dto.MainCategoryDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.SpecificationDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.SpecificationTypeDTO;
import edu.ijse.mobileadvertiesmentsystem.service.SpecificationTypeService;
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
public class SpecificationTypeController {

    @Autowired
    private SpecificationTypeService specificationTypeService;

    @RequestMapping(value = "/SpecificationType", method = RequestMethod.GET)
    public String navigation2() {

        return "SpecificationType";
    }

    @RequestMapping(value = "/addSpecificationType", method = RequestMethod.POST)
    public @ResponseBody
    String addSpecificationType(@RequestParam(value = "spId") String spId, @RequestParam(value = "spName") String spName, @RequestParam(value = "mName") String mName) {
        SpecificationTypeDTO sp = new SpecificationTypeDTO();
        sp.setMainCategoryName(mName);
        sp.setSpecificationType(spName);
        return specificationTypeService.addSpecificationType(sp);
    }

    @RequestMapping(value = "/updateSpecificationType", method = RequestMethod.POST)
    public @ResponseBody
    String updateSpecificationType(@RequestParam(value = "spId") String spId, @RequestParam(value = "spName") String spName, @RequestParam(value = "mName") String mName) {
        SpecificationTypeDTO s = new SpecificationTypeDTO(Integer.parseInt(spId), spName, mName);
        return specificationTypeService.updateSpecificationType(s);
    }

    @RequestMapping(value = "/deleteSpecificationType", method = RequestMethod.POST)
    public @ResponseBody
    String deleteSpecificationType(@RequestParam(value = "id") String id) {
        return specificationTypeService.deleteSpecificationType(id);
    }

    @RequestMapping(value = "/getAllSpecificationType", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAllSpecificationType(@RequestParam(value = "mName") String mName) {

        ArrayList<SpecificationTypeDTO> list = specificationTypeService.getAll();

        return new Gson().toJson(list);

    }

    @RequestMapping(value = "/selectedSpecificationType", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAllSpecificationTypeByMainCategoryName(@RequestParam(value = "mname") String mName) {
        ArrayList<SpecificationTypeDTO> list = specificationTypeService.getAll(mName);

        return new Gson().toJson(list);

    }

    @RequestMapping(value = "/getSpecifications", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getSpecifications(@RequestParam(value = "mname") String mName) {

        ArrayList<SpecificationDTO> list = specificationTypeService.getAllByName(mName);

        return new Gson().toJson(list);

    }

    @RequestMapping(value = "/updateSpec", method = RequestMethod.POST)
    public @ResponseBody
    String updateSpec(@RequestParam(value = "id") String id, @RequestParam(value = "desc") String desc) {
        SpecificationDTO s = new SpecificationDTO();
        s.setSpecificationId(Integer.parseInt(id));
        s.setSpecificationDescription(desc);

        return specificationTypeService.updatSpec(s);

    }

}
