/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.MainCategoryDAO;
import edu.ijse.mobileadvertiesmentsystem.dao.custom.SpecificationTypeDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.MainCategoryDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.SpecificationDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.SpecificationTypeDTO;
import edu.ijse.mobileadvertiesmentsystem.model.MainCategory;
import edu.ijse.mobileadvertiesmentsystem.model.Specification;
import edu.ijse.mobileadvertiesmentsystem.model.SpecificationType;
import edu.ijse.mobileadvertiesmentsystem.service.MainCategoryService;
import edu.ijse.mobileadvertiesmentsystem.service.SpecificationTypeService;
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
public class SpecificationTypeServiceImpl implements SpecificationTypeService {

    @Autowired
    private SpecificationTypeDAO specificationTypeDAO;

    @Autowired
    private MainCategoryDAO mainCategoryDAO;

    @Autowired
    private MainCategoryService mainCategoryService;

    @Override
    public String addSpecificationType(SpecificationTypeDTO specType) {

        String ans1 = mainCategoryService.isExist("Name", specType.getMainCategoryName());
        if (ans1.equals("exist")) {
            String ans = isExist("Name", specType.getSpecificationType());

            if (ans.equals("notexist")) {

                List<Object[]> list = mainCategoryDAO.searchByName(specType.getMainCategoryName());
                MainCategory main = new MainCategory();

                for (int i = 0; i < list.size(); i++) {
                    Object[] ar = list.get(i);
                    main.setMainCategoryId(Integer.parseInt(ar[0].toString()));
                    main.setMainCategoryName(ar[1].toString());
                }

                SpecificationType sp = new SpecificationType();
                sp.setMainCategory(main);
                sp.setSpecificationType(specType.getSpecificationType());
                sp.setSpecificationTypeId(specType.getSpecificationTypeId());

                Serializable ser = specificationTypeDAO.add(sp);
                if (ser != null) {
                    return "success";
                } else {
                    return "fail";
                }
            }
        } else {
            return "fail";
        }

        return "exist";
    }

    @Override
    public String updateSpecificationType(SpecificationTypeDTO specType) {
        String ans1 = mainCategoryService.isExist("Name", specType.getMainCategoryName());
        if (ans1.equals("exist")) {
            String ans = isExist("Id", Integer.toString(specType.getSpecificationTypeId()));
            System.out.println("ans : " + ans);
            if (ans.equals("exist")) {
                SpecificationType sp = new SpecificationType();
                sp.setSpecificationType(specType.getSpecificationType());
                sp.setSpecificationTypeId(specType.getSpecificationTypeId());

                int val = specificationTypeDAO.update(sp);
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
    public SpecificationTypeDTO searchSpecificationType(String id) {
        SpecificationType sp = specificationTypeDAO.search(id);
        SpecificationTypeDTO st = new SpecificationTypeDTO(sp.getSpecificationTypeId(), sp.getSpecificationType(), sp.getMainCategory().getMainCategoryName());
        return st;
    }

    @Override
    public String deleteSpecificationType(String id) {

        String ans = isExist("Id", id);
        System.out.println("ans : " + ans);
        if (ans.equals("exist")) {
            int val = specificationTypeDAO.delete(id);
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
            List<Object[]> list = specificationTypeDAO.searchByName(id);
            if (list.size() > 0) {
                return "exist";
            } else {
                return "notexist";
            }
        } else if (key.equals("Id")) {
            SpecificationType spec = specificationTypeDAO.searchById(id);
            if (spec != null) {
                return "exist";
            } else {
                return "notexist";
            }
        }
        return "notexist";
    }

    @Override
    public ArrayList<SpecificationTypeDTO> getAll() {
        List<SpecificationType> list = specificationTypeDAO.getAll();

        ArrayList<SpecificationTypeDTO> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            SpecificationTypeDTO s = new SpecificationTypeDTO();
            s.setMainCategoryName(list.get(i).getMainCategory().getMainCategoryName());
            s.setSpecificationType(list.get(i).getSpecificationType());
            s.setSpecificationTypeId(list.get(i).getSpecificationTypeId());
            newList.add(s);
        }

        return newList;
    }

    @Override
    public ArrayList<SpecificationTypeDTO> getAll(String mName) {
        ArrayList<SpecificationTypeDTO> newList = new ArrayList<>();
        MainCategoryDTO m = (MainCategoryDTO) mainCategoryService.searchByName(mName);
        if (m != null) {
            List<Object[]> list = specificationTypeDAO.getAll(m.getId());

            for (int i = 0; i < list.size(); i++) {
                Object[] ar = list.get(i);
                SpecificationTypeDTO s = new SpecificationTypeDTO();
                s.setSpecificationTypeId(Integer.parseInt(ar[0].toString()));
                s.setSpecificationType(ar[1].toString());
                newList.add(s);
            }

        }
        return newList;
    }

    @Override
    public String addSpecification(Specification spec) {
        Serializable ser = specificationTypeDAO.addSpecification(spec);
        if (ser != null) {
            return "success";
        } else {
            return "fail";
        }
        
    }

    @Override
    public ArrayList<SpecificationDTO> getAllByName(String mName) {
      ArrayList<SpecificationDTO> newList = new ArrayList<>();
       
       
            List<Object[]> list = specificationTypeDAO.getAllByName(mName);

            for (int i = 0; i < list.size(); i++) {
                Object[] ar = list.get(i);
                SpecificationDTO s = new SpecificationDTO();
                s.setModelId(ar[3].toString());
                s.setSpcificationName(ar[1].toString());
                s.setSpecificationId(Integer.parseInt(ar[0].toString()));
                s.setSpecificationDescription(ar[2].toString());
               
                newList.add(s);
            }

        
        return newList;
        
        
        
    }

    @Override
    public String updatSpec(SpecificationDTO sp) {
        Specification s=new Specification();
        s.setSpecificationId(sp.getSpecificationId());
        s.setSpecificationDescription(sp.getSpecificationDescription());
        
        int val = specificationTypeDAO.updateSpec(s);
        if (val>0) {
            return "success";
        }else{
            return "fail";
        }
        
    }

}
