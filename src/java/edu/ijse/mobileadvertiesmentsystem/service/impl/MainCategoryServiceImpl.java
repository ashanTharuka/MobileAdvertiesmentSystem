/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.MainCategoryDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.MainCategoryDTO;
import edu.ijse.mobileadvertiesmentsystem.model.MainCategory;
import edu.ijse.mobileadvertiesmentsystem.service.MainCategoryService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ashan Tharuka
 */
@Transactional
@Service
public class MainCategoryServiceImpl implements MainCategoryService {

    @Autowired
    private MainCategoryDAO mainCategoryDAO;

    @Override
    public String addMainCategory(MainCategoryDTO mainCategory) {

        String ans = isExist("Name", mainCategory.getMainCategoryName());

        if (ans.equals("notexist")) {
            MainCategory main = new MainCategory();
            main.setMainCategoryName(mainCategory.getMainCategoryName());

            Serializable ser = mainCategoryDAO.add(main);
            if (ser != null) {
                return "success";
            } else {
                return "fail";
            }
        }
        return "exist";

    }

    @Override
    public String updateMainCategory(MainCategoryDTO mainCategory) {
        String ans = isExist("Id", mainCategory.getId());
        System.out.println("ans : " + ans);
        if (ans.equals("exist")) {
            MainCategory main = new MainCategory();
            main.setMainCategoryName(mainCategory.getMainCategoryName());
            main.setMainCategoryId(Integer.parseInt(mainCategory.getId()));

            int val = mainCategoryDAO.update(main);
            if (val > 0) {
                return "success";
            } else {
                return "fail";
            }
        }
        return "noexist";
    }

    @Override
    public MainCategoryDTO searchMainCategory(String id) {
        MainCategory m = mainCategoryDAO.search(id);
        MainCategoryDTO md = new MainCategoryDTO(Integer.toString(m.getMainCategoryId()), m.getMainCategoryName());
        return md;
    }

    @Override
    public String deleteMainCategory(String id) {
        String ans = isExist("Id", id);
        System.out.println("ans : " + ans);
        if (ans.equals("exist")) {
            int val = mainCategoryDAO.delete(id);
            if (val > 0) {
                return "success";
            } else {
                return "fail";
            }
        }
        return "noexist";
    }

    @Override
    public ArrayList<MainCategoryDTO> getAll() {

        List<MainCategory> list = mainCategoryDAO.getAll();

        ArrayList<MainCategoryDTO> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            MainCategoryDTO m = new MainCategoryDTO();
            m.setId(Integer.toString(list.get(i).getMainCategoryId()));
            m.setMainCategoryName(list.get(i).getMainCategoryName());
            newList.add(m);
        }

        return newList;
    }

    @Override
    public String isExist(String key, String id) {
        if (key.equals("Name")) {
            List<Object[]> list = mainCategoryDAO.searchByName(id);
            if (list.size() > 0) {
                return "exist";
            } else {
                return "notexist";
            }
        } else if (key.equals("Id")) {
            MainCategory main = mainCategoryDAO.searchById(id);
            if (main!=null) {
                return "exist";
            } else {
                return "notexist";
            }
        }
        return "notexist";
    }

    @Override
    public MainCategoryDTO searchByName(String name) {

        List<Object[]> list = mainCategoryDAO.searchByName(name);
        MainCategoryDTO m = new MainCategoryDTO();

       
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object[] ar = list.get(i);
                m.setId(ar[0].toString());
                m.setMainCategoryName(ar[1].toString());

            }
            return m;
        } else {

            return null;
        }
    }

}
