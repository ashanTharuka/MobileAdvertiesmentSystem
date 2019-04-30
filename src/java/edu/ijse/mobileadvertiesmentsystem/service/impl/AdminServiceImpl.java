/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.AdminDAO;
import edu.ijse.mobileadvertiesmentsystem.dto.AdminDTO;
import edu.ijse.mobileadvertiesmentsystem.model.Admin;
import edu.ijse.mobileadvertiesmentsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ashan Tharuka
 */
@Transactional
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public String addAdmin(AdminDTO adminDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String updateAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setAdminId(adminDTO.getAdminId());
        admin.setAdminName(adminDTO.getAdminName());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());
        int val = adminDAO.update(admin);
        if (val > 0) {
            return "success";
        } else {
            return "fail";
        }
        
    }

    @Override
    public AdminDTO searchAdmin() {
        Admin add = adminDAO.search("1");

        AdminDTO newAdd = new AdminDTO();
        newAdd.setAdminId(add.getAdminId());
        newAdd.setAdminName(add.getAdminName());
        newAdd.setEmail(add.getEmail());
        return newAdd;

    }

}
