/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.ModelDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Model;
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
public class ModelDAOImpl implements ModelDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable add(Model model) {
        return sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public int update(Model model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> searchByName(String name) {
        return sessionFactory.getCurrentSession().createSQLQuery("select * from Model where modelName_1='" + name + "'").list();
    }

    @Override
    public Model searchById(String id) {
        return (Model) sessionFactory.getCurrentSession().get(Model.class, Integer.parseInt(id));
    }

    @Override
    public int delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Model> getAll() {
        return (ArrayList<Model>) sessionFactory.getCurrentSession().createQuery("from Model").list();
    }

    @Override
    public List<Object[]> SearchQuery(String id) {
        return sessionFactory.getCurrentSession().createSQLQuery("select modelName_1,brandName from Model m,Brand b where m.brand_Id=b.brandId AND  modelId='" + id + "'").list();

    }

    @Override
    public List<String> searchSpecificationTypes(String mainCategoryName) {
        return sessionFactory.getCurrentSession().createSQLQuery(" select specificationType from MainCategory m,SpecificationType s where m.maincategoryId=s.mainCategory_Id and mainCategoryName='"+mainCategoryName+"'").list();
    }

    @Override
    public List<Object[]> getAll(String name) {
        return  sessionFactory.getCurrentSession().createSQLQuery(" select modelName_1,modelId from Model m,Brand b where m.brand_Id=b.brandId and brandName='"+name.trim()+"'").list();
        
    }

    @Override
    public String searchName(String name) {
        return sessionFactory.getCurrentSession().createSQLQuery("select modelId from Model where modelName_1='"+name+"'").list().get(0).toString();
    }

}
