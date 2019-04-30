/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.ModelDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.BrandDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.MBDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.ModelDTO;
import edu.ijse.mobileadvertiesmentsystem.model.Brand;
import edu.ijse.mobileadvertiesmentsystem.model.Model;
import edu.ijse.mobileadvertiesmentsystem.model.Specification;
import edu.ijse.mobileadvertiesmentsystem.model.SpecificationType;
import edu.ijse.mobileadvertiesmentsystem.service.BrandService;
import edu.ijse.mobileadvertiesmentsystem.service.ModelService;
import edu.ijse.mobileadvertiesmentsystem.service.SpecificationTypeService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ashan Tharuka
 */
@Transactional
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelDAO modelDAO;

    @Autowired
    private BrandService brandService;

    @Autowired
    private SpecificationTypeService specification;

    @Override
    public MBDTO SearchQuery(String id) {

        Object[] ar = modelDAO.SearchQuery(id).get(0);
        MBDTO mb = new MBDTO();

        mb.setModelName(ar[0].toString());
        mb.setBrandName(ar[1].toString());

        return mb;

    }

    @Override
    public String searchByName(String name) {

        List<Object[]> list = modelDAO.searchByName(name);
        String id = null;

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object[] ar = list.get(i);
                id = ar[0].toString();

            }
            return id;
        } else {

            return null;
        }
    }

    @Override
    public ModelDTO searchById(String id) {

        Model model = modelDAO.searchById(id);

        ModelDTO m = new ModelDTO();
        m.setAdvertiesmentDetails(model.getAdvertiesmentDetails());
        m.setBrand(model.getBrand());
        m.setImgPath_1(model.getImgPath_1());
        m.setImgPath_2(model.getImgPath_2());
        m.setImgPath_3(model.getImgPath_3());
        m.setMaxPrice(model.getMaxPrice());
        m.setMinPrice(model.getMinPrice());
        m.setModelId(model.getModelId());
        m.setModelName_1(model.getModelName_1());
        m.setModelName_2(model.getModelName_2());
        m.setModelYear(model.getModelYear());
        m.setRate(model.getRate());
        m.setSearchLine(model.getSearchLine());
        m.setSpecialCategoryName(model.getSpecialCategoryName());
        m.setSpecifications(model.getSpecifications());
        m.setStoreCount(model.getStoreCount());
        return m;

    }

    @Override
    public String addModelDTO(ModelDTO model) {
        System.out.println("calllllllllllllllllllllllllllllllllllllllllllllllll");
        BrandDTO brand = brandService.searchByName(model.getBrandName());
        Brand b = new Brand();
        b.setBrandId(Integer.parseInt(brand.getId()));
        b.setBrandName(brand.getBrandName());

        Model m = new Model();
        m.setSpecialCategoryName(model.getSpecialCategoryName());
        m.setImgPath_1(model.getImgPath_1());
        m.setImgPath_2(model.getImgPath_2());
        m.setImgPath_3(model.getImgPath_3());
        m.setModelName_1(model.getModelName_1());
        m.setModelName_2(model.getModelName_2());
        m.setSearchLine(model.getBrandName() + ":" + model.getModelName_1() + ":" + model.getModelName_2());
        m.setBrand(b);

        System.out.println("///////////////////////////////////////////////////////");
        List<String> list = modelDAO.searchSpecificationTypes(model.getMainCategoryName());
        System.out.println("list size : " + list.size());
        Set<Specification> spe = new HashSet<>();
        Serializable ser = modelDAO.add(m);

        String modelId = modelDAO.searchName(model.getModelName_1());

        System.out.println("model Id : " + modelId);
        m.setModelId(Integer.parseInt(modelId));

        for (int i = 0; i < list.size(); i++) {
            Specification s = new Specification();
            s.setSpcificationName(list.get(i));
            s.setSpecificationDescription(" ");
            s.setModel(m);
            spe.add(s);
        }

        int count = 0;
        for (Specification spec : spe) {
            String ans = specification.addSpecification(spec);
            if (ans.equals("success")) {
                count++;
            }
        }

        if (count == spe.size()) {
            return "success";
        } else {
            return "fail";
        }

    }

    @Override
    public ArrayList<ModelDTO> getAll() {

        List<Model> list = modelDAO.getAll();

        ArrayList<ModelDTO> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            ModelDTO s = new ModelDTO();
            s.setModelId(list.get(i).getModelId());
            s.setImgPath_1(list.get(i).getImgPath_1());
            s.setImgPath_2(list.get(i).getImgPath_2());
            s.setImgPath_3(list.get(i).getImgPath_3());
            s.setModelName_1(list.get(i).getModelName_1());
            s.setModelName_2(list.get(i).getModelName_2());
            s.setModelYear(list.get(i).getModelYear());
            s.setSpecialCategoryName(list.get(i).getSpecialCategoryName());
            s.setSearchLine(list.get(i).getSearchLine());

            newList.add(s);
        }

        return newList;

    }

    @Override
    public ArrayList<ModelDTO> getAll(String modelName) {
        ArrayList<ModelDTO> newList = new ArrayList<>();

       List<Object[]> list = modelDAO.getAll(modelName);

        for (int i = 0; i < list.size(); i++) {
            Object[] ar = list.get(i);
            ModelDTO s = new ModelDTO();
            s.setModelName_1(ar[0].toString());
            s.setModelId(Integer.parseInt(ar[1].toString()));

            newList.add(s);

        }
        return newList;

    }

}
