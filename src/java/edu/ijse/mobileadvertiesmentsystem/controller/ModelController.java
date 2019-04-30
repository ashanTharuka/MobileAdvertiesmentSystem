/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.controller;

import com.google.gson.Gson;
import edu.ijse.mobileadvertiesmentsystem.dto.BrandDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.ModelDTO;
import edu.ijse.mobileadvertiesmentsystem.service.ModelService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
@Scope(value = "application")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @RequestMapping(value = "/Model", method = RequestMethod.GET)
    public String navigation() {
        return "Model";
    }

    @RequestMapping(value = "/addModel", method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView uploadMultipleFilesHandler(@RequestParam("file") MultipartFile[] files, @RequestParam(value = "mname") String mname,
            @RequestParam(value = "bname") String bname, @RequestParam(value = "mn1name") String mn1name,
            @RequestParam(value = "mn2name") String mn2name, @RequestParam(value = "sName") String sName,
            @RequestParam(value = "myname") String myname) {

        String path = "";
//       

        System.out.println("file size ::::::::::::::;; " + files.length);
        String[] filenames = {"1.jpg", "2.jpg", "3.jpg"};

        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String filename = filenames[i];
            try {

                byte[] bytes = file.getBytes();
                OutputStream out = null;

                try {
                    File F1 = new File("E:\\My_Project\\Project UI vertions\\MobileAdvertiesmentSystem\\web\\static\\SystemPhoto\\" + mname + "\\" + mn1name + "\\");
                    F1.mkdirs();

                    out = new BufferedOutputStream(new FileOutputStream(new File(("E:\\My_Project\\Project UI vertions\\MobileAdvertiesmentSystem\\web\\static\\SystemPhoto\\" + mname + "\\" + mn1name + "") + "\\" + filename)));
                    out.write(bytes);
                    System.out.println("path : " + "E:\\My_Project\\Project UI vertions\\MobileAdvertiesmentSystem\\web\\static\\SystemPhoto\\" + mname + "\\" + mn1name + "\\" + filename);
                    path = "static\\SystemPhoto\\" + mname + "\\" + mn1name + "\\";
                } finally {
                    if (out != null) {
                        out.close();
                    }
                }
            } catch (Exception e) {
//                return "You failed to upload " + filename + " => " + e.getMessage();
                e.printStackTrace();
            }
        }

        ModelDTO m = new ModelDTO();
        m.setMainCategoryName(mname);
        m.setBrandName(bname);
        m.setImgPath_1(path + filenames[0]);
        m.setImgPath_2(path + filenames[1]);
        m.setImgPath_3(path + filenames[2]);
        m.setModelName_1(mn1name);
        m.setModelName_2(mn2name);
        m.setModelYear(myname);
        m.setSpecialCategoryName(sName);

        String ans = modelService.addModelDTO(m);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Model");
        mav.addObject("ans", ans);

        return mav;

    }

    @RequestMapping(value = "/getAllModel", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String getAllBrands() {

        ArrayList<ModelDTO> list = modelService.getAll();

        return new Gson().toJson(list);

    }

    @RequestMapping(value = "/selectedModel", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String selectedModel(@RequestParam(value = "mname") String mname) {

        ArrayList<ModelDTO> list = modelService.getAll(mname);

        return new Gson().toJson(list);

    }
}
