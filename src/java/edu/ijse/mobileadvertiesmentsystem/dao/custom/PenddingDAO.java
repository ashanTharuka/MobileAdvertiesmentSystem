/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom;

import edu.ijse.mobileadvertiesmentsystem.dao.SuperDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Pendding;
import java.util.List;

/**
 *
 * @author Ashan Tharuka
 */
public interface PenddingDAO extends SuperDAO<Pendding>{
     public int deletePendding(String shopId,String modelId);
     public  List<Object[]> getPendding(String shopId,String modelId);
}
