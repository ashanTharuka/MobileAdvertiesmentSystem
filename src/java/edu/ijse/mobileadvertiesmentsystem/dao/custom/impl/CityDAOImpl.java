/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.CItyDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Brand;
import edu.ijse.mobileadvertiesmentsystem.model.Town;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ashan Tharuka
 */
@Repository
public class CityDAOImpl implements CItyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable add(Town model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Town model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Town search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> searchByName(String name) {
        return sessionFactory.getCurrentSession().createSQLQuery("select * from Town").list();
    }

    @Override
    public Town searchById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Town> getAll() {
        return (ArrayList<Town>) sessionFactory.getCurrentSession().createQuery("from Town").list();
    }

    @Override
    public List<Object[]> searchByNames(String townName) {
        return sessionFactory.getCurrentSession().createSQLQuery("select * from Town where townName='"+townName+"'").list();

    }

}
