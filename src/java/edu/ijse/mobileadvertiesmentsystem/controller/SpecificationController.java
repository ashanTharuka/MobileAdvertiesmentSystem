/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ashan Tharuka
 */
@Controller 
@Scope(value = "application")
public class SpecificationController {
    @RequestMapping(value = "/Specification", method = RequestMethod.GET)
    public String navigation() {

        return "Specification";
    }
    
    
}
