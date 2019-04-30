/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.BrandDAO;
import edu.ijse.mobileadvertiesmentsystem.dao.custom.MainCategoryDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.BrandDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.MainCategoryDTO;
import edu.ijse.mobileadvertiesmentsystem.model.Brand;
import edu.ijse.mobileadvertiesmentsystem.model.MainCategory;
import edu.ijse.mobileadvertiesmentsystem.service.BrandService;
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
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandDAO brandDAO;

    @Autowired
    MainCategoryService mainCategoryService;

    @Autowired
    MainCategoryDAO mainCategoryDAO;

    @Override
    public String addBrand(BrandDTO brand) {
        String ans1 = mainCategoryService.isExist("Name", brand.getMainCategoryName());
        if (ans1.equals("exist")) {
            String ans = isExist("Name", brand.getBrandName());
            System.out.println("Answer : " + ans);
            if (ans.equals("notexist")) {
//                System.out.println("maainCategoryName : " + brand.getMainCategoryName());
                List<Object[]> list = mainCategoryDAO.searchByName(brand.getMainCategoryName());
                MainCategory main = new MainCategory();

                for (int i = 0; i < list.size(); i++) {
                    Object[] ar = list.get(i);
                    main.setMainCategoryId(Integer.parseInt(ar[0].toString()));
                    main.setMainCategoryName(ar[1].toString());
                }

                Brand b = new Brand();
                b.getMainCategorys().add(main);
                b.setBrandName(brand.getBrandName());

                Serializable ser = brandDAO.add(b);
                if (ser != null) {
                    return "success";
                } else {
                    return "fail";
                }
            } else {
                List<Object[]> list = brandDAO.searchByName(brand.getBrandName());

                int brandId = -1;

                for (int i = 0; i < list.size(); i++) {
                    Object[] get = list.get(i);
                    brandId = Integer.parseInt(get[0].toString());

                }
                List<Object[]> list1 = mainCategoryDAO.searchByName(brand.getMainCategoryName());
                MainCategory main = new MainCategory();

                for (int i = 0; i < list1.size(); i++) {
                    Object[] ar = list1.get(i);
                    main.setMainCategoryId(Integer.parseInt(ar[0].toString()));
                    main.setMainCategoryName(ar[1].toString());
                }

                List<Object[]> ob = brandDAO.isExistAssociate(Integer.toString(brandId), Integer.toString(main.getMainCategoryId()));
                if (ob.size() > 0) {
                    return "exist";
                } else {
                    Serializable se = brandDAO.addAssociateValue(Integer.toString(brandId), Integer.toString(main.getMainCategoryId()));
                    if (se != null) {
                        return "success";
                    } else {
                        return "fail";
                    }
                }
            }
        } else {
            return "fail";
        }

    }

    @Override
    public String updateBrand(BrandDTO brand) {
        String ans1 = mainCategoryService.isExist("Name", brand.getMainCategoryName());
        if (ans1.equals("exist")) {
            String ans = isExist("Id", brand.getId());
            if (ans.equals("exist")) {
                Brand b = new Brand();
                b.setBrandId(Integer.parseInt(brand.getId()));
                b.setBrandName(brand.getBrandName());

                int val = brandDAO.update(b);
                if (val > 0) {
                    return "success";
                } else {
                    return "fail";
                }
            }
        } else {
            return "fail";
        }
        return "noexist";
    }

    @Override
    public BrandDTO searchBrand(String id) {
        Brand sp = brandDAO.search(id);
        BrandDTO br = new BrandDTO();
        br.setBrandName(sp.getBrandName());
        br.setId(Integer.toString(sp.getBrandId()));
        return br;
    }

    @Override
    public String deleteBrand(String id) {
        String ans = isExist("Id", id);
        System.out.println("ans : " + ans);
        if (ans.equals("exist")) {
            int val = brandDAO.delete(id);
            if (val > 0) {
                return "success";
            } else {
                return "fail";
            }
        }
        return "noexist";
    }

    @Override
    public String isExist(String key, String id) {
        if (key.equals("Name")) {
            List<Object[]> list = brandDAO.searchByName(id);
            if (list.size() > 0) {
                return "exist";
            } else {
                return "notexist";
            }
        } else if (key.equals("Id")) {
            Brand brand = brandDAO.searchById(id);
            if (brand != null) {
                return "exist";
            } else {
                return "notexist";
            }
        }
        return "notexist";
    }

    @Override
    public ArrayList<BrandDTO> getAll() {
        List<Brand> list = brandDAO.getAll();

        ArrayList<BrandDTO> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            BrandDTO s = new BrandDTO();
            s.setId(Integer.toString(list.get(i).getBrandId()));
            s.setBrandName(list.get(i).getBrandName());
            newList.add(s);
        }

        return newList;
    }

    @Override
    public ArrayList<BrandDTO> getAll(String mName) {
        ArrayList<BrandDTO> newList = new ArrayList<>();

        List<Object[]> list = brandDAO.getAll(mName);

        for (int i = 0; i < list.size(); i++) {
            Object[] ar = list.get(i);
            BrandDTO s = new BrandDTO();

            s.setId(ar[1].toString());
            s.setBrandName(ar[0].toString());
            newList.add(s);

        }
        return newList;
    }

    @Override
    public BrandDTO searchByName(String name) {

        List<Object[]> list = brandDAO.searchByName(name);

        BrandDTO b = new BrandDTO();

        for (int i = 0; i < list.size(); i++) {
            Object[] get = list.get(i);
            b.setId(get[0].toString());
            b.setBrandName(get[1].toString());
        }

       return b;
    }

}
