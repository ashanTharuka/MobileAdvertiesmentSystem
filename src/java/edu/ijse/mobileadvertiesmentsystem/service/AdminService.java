/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.dto.AdminDTO;

/**
 *
 * @author Ashan Tharuka
 */
public interface AdminService {

    public String addAdmin(AdminDTO adminDTO);

    public String updateAdmin(AdminDTO adminDTO);
    public AdminDTO searchAdmin();
}
