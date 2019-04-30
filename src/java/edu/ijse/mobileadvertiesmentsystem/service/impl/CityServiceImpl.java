/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.CItyDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.TownDTO;
import edu.ijse.mobileadvertiesmentsystem.model.Town;
import edu.ijse.mobileadvertiesmentsystem.service.CityService;
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
public class CityServiceImpl implements CityService {
    
    @Autowired
    private CItyDAO cidao;
    
    @Override
    public ArrayList<TownDTO> getAllTown() {
        List<Object[]> list = cidao.searchByName("");
        
        ArrayList<TownDTO> newList = new ArrayList<>();
        
        for (int i = 0; i < list.size(); i++) {
            Object[] ar = list.get(i);
            TownDTO s = new TownDTO();
            s.setTownName(ar[2].toString());
            
            newList.add(s);
        }
        
        return newList;
    }
    
    @Override
    public TownDTO searchByName(String townName) {
        
        List<Object[]> list = cidao.searchByNames(townName);
        TownDTO t = new TownDTO();
        for (int i = 0; i < list.size(); i++) {
            Object[] ar = list.get(i);
            
            t.setTownId(Integer.parseInt(ar[0].toString()));
            t.setDistrictId(ar[3].toString());
            t.setTownName(ar[2].toString());
            t.setPostalCode(Integer.parseInt(ar[1].toString()));
        }
        
        return t;
    }
    
}
