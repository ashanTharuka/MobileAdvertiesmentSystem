/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.dto.BranchDTO;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface BranchService {
    public String addBranch(BranchDTO branchDTO);
    public ArrayList<BranchDTO>getAll();
}
