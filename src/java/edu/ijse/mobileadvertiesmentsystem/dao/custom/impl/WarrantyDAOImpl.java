/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.WarrantyDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Warranty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ashan Tharuka
 */
@Repository
public class WarrantyDAOImpl implements WarrantyDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Serializable add(Warranty model) {
       return sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public int update(Warranty model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Warranty search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Warranty searchById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Warranty> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteWaranty(String shopId, String modelId) {
       return sessionFactory.getCurrentSession().createSQLQuery("delete from Warranty where advertiesmentDetail_modelId='"+modelId+"' AND advertiesmentDetail_ownerId='"+shopId+"'").executeUpdate();
        
    }
    
}
