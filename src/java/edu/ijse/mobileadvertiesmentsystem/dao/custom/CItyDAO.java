/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom;

import edu.ijse.mobileadvertiesmentsystem.dao.SuperDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Town;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashan Tharuka
 */
public interface CItyDAO extends SuperDAO<Town>{
   
    public List<Object[]> searchByNames(String townName);
}
