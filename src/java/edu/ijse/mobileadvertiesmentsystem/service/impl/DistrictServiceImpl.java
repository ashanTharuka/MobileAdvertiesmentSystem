/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.DistrictDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.DistrictDTO;
import edu.ijse.mobileadvertiesmentsystem.model.District;
import edu.ijse.mobileadvertiesmentsystem.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ashan Tharuka
 */
@Transactional
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictDAO districtDAO;

    @Override
    public DistrictDTO getDistrict(String id) {
        District dis = districtDAO.search(id);

        DistrictDTO d = new DistrictDTO();
        d.setDisctrictName(dis.getDisctrictName());
        d.setDistrictCode(dis.getDistrictCode());
        d.setTowns(dis.getTowns());
        d.setDistrictId(dis.getDistrictId());
        return d;
    }

}
