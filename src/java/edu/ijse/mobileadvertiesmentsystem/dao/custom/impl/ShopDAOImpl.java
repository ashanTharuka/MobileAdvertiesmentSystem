/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.ShopDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Owner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ashan Tharuka
 */
@Repository
public class ShopDAOImpl implements ShopDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Object[]> checkUser(String email, String password) {
        return sessionFactory.getCurrentSession().createSQLQuery("select * from Owner where email='" + email + "' AND password='" + password + "'").list();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Serializable add(Owner model) {
        return sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public int update(Owner model) {

        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("update Owner set shopImg=:s1,shopName=:s2,url=:s3,email=:s4  where ownerId=:id");
        query.setParameter("s1", model.getShopImg());
        query.setParameter("s2", model.getShopName());
        query.setParameter("s3", model.getUrl());
        query.setParameter("s4", model.getEmail());
        query.setParameter("id", model.getOwnerId());
        return query.executeUpdate();
    }

    @Override
    public Owner search(String id) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> searchByName(String name) {
        return sessionFactory.getCurrentSession().createSQLQuery("select * from Owner where shopName='" + name + "'").list();
    }

    @Override
    public Owner searchById(String id) {
        return (Owner) sessionFactory.getCurrentSession().get(Owner.class, Integer.parseInt(id));
    }

    @Override
    public int delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Owner> getAll() {
        return (ArrayList<Owner>) sessionFactory.getCurrentSession().createQuery("from Owner").list();
    }

    @Override
    public List<Object[]> getPassword(String email) {
      return sessionFactory.getCurrentSession().createSQLQuery("select * from Owner where email='" + email + "'").list();
    }

}
