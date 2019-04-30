/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.AdminDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Admin;
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
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable add(Admin model) {
        return sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public int update(Admin model) {
        return (int) sessionFactory.getCurrentSession().createSQLQuery("UPDATE Admin SET adminName = '" + model.getAdminName()+ "', email='" + model.getEmail()+ "' ,password='"+model.getPassword()+"' where adminId=1").executeUpdate();
    }

    @Override
    public Admin search(String id) {
        return (Admin) sessionFactory.getCurrentSession().get(Admin.class, Integer.parseInt(id));
    }

    @Override
    public List<Object[]> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin searchById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Admin> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
