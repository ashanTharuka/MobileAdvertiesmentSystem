/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.LoginDAO;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ashan Tharuka
 */
@Repository
public class LoginDAOImpl implements LoginDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Object[]> checkUser(String email, String password) {
      return  sessionFactory.getCurrentSession().createSQLQuery("select * from Admin where email='"+email+"' AND password='"+password+"'").list();
        
    }

    @Override
    public List<Object[]> getPassword(String email) {
        return  sessionFactory.getCurrentSession().createSQLQuery("select * from Admin where email='"+email+"'").list();
    }
    
}
