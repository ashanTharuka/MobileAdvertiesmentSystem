/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import edu.ijse.mobileadvertiesmentsystem.model.MainCategory;
import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.ijse.mobileadvertiesmentsystem.dao.custom.MainCategoryDAO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ashan Tharuka
 */
@Repository
public class MainCategoryDAOImpl implements MainCategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable add(MainCategory model) {
        return sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public int update(MainCategory model) {

        return (int) sessionFactory.getCurrentSession().createSQLQuery("UPDATE MainCategory SET mainCategoryName = '" + model.getMainCategoryName() + "' where mainCategoryId='" + model.getMainCategoryId() + "'").executeUpdate();

    }

    @Override
    public MainCategory search(String id) {

        return (MainCategory) sessionFactory.getCurrentSession().get(MainCategory.class, id);
    }

    @Override
    public int delete(String id) {
        return (int) sessionFactory.getCurrentSession().createSQLQuery("delete from MainCategory  where mainCategoryId='" + id + "'").executeUpdate();
    }

    @Override
    public ArrayList<MainCategory> getAll() {
        return(ArrayList<MainCategory>) sessionFactory.getCurrentSession().createQuery("from MainCategory").list();
    }


    @Override
    public   List<Object[]>   searchByName(String name) {
      return  sessionFactory.getCurrentSession().createSQLQuery("select * from MainCategory where mainCategoryName='" + name + "'").list();
    }

    @Override
    public  MainCategory  searchById(String id) {
       return   (MainCategory) sessionFactory.getCurrentSession().get(MainCategory.class, Integer.parseInt(id));
    }

}
