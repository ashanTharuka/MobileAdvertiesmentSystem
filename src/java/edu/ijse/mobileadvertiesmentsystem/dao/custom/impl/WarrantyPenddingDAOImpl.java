/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.ijse.mobileadvertiesmentsystem.dao.custom.WarrantyPenddingDAO;
import edu.ijse.mobileadvertiesmentsystem.model.WarrantyPendding;

/**
 *
 * @author Ashan Tharuka
 */
@Repository
public class WarrantyPenddingDAOImpl implements WarrantyPenddingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable add(WarrantyPendding model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(WarrantyPendding model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WarrantyPendding search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WarrantyPendding searchById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteWarrantyPendding(String modelId, String shopId) {
        return (int) sessionFactory.getCurrentSession().createSQLQuery("delete from WarrantyPendding  where pendding_modelId='" +modelId+ "' AND pendding_ownerId='" +shopId +"'").executeUpdate();
    }

    @Override
    public ArrayList<WarrantyPendding> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> getWarrantyPendding(String shopId, String modelId) {
      return sessionFactory.getCurrentSession().createSQLQuery("select * from WarrantyPendding  where pendding_modelId='" + modelId + "' AND pendding_ownerId='" + shopId + "'").list();
        
    }

}
