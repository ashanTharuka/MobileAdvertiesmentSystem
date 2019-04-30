/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.PenddingDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Pendding;
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
public class PenddingDAOImpl implements PenddingDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public Serializable add(Pendding model) {
        return sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public int update(Pendding model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pendding search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pendding searchById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Pendding> getAll() {
        return (ArrayList<Pendding>) sessionFactory.getCurrentSession().createQuery("from Pendding").list();
    }

    @Override
    public int deletePendding(String shopId, String modelId) {
       return (int) sessionFactory.getCurrentSession().createSQLQuery("delete from Pendding  where modelId='" + modelId + "' AND ownerId='"+shopId+"'").executeUpdate();
    }

    @Override
    public List<Object[]> getPendding(String shopId, String modelId) {
        return sessionFactory.getCurrentSession().createSQLQuery("select * from Pendding where modelId='"+modelId+"' AND ownerId='"+shopId+"'").list();
    }
    
}
