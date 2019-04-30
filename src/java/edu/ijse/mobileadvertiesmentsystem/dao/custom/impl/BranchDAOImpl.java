/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.BranchDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Branch;
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
public class BranchDAOImpl implements BranchDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable add(Branch model) {
       return sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public int update(Branch model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Branch search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> searchByName(String name){
        return sessionFactory.getCurrentSession().createSQLQuery("select * from branch").list();
    }

    @Override
    public Branch searchById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Branch> getAll() {
         return (ArrayList<Branch>) sessionFactory.getCurrentSession().createQuery("from Branch").list();
    }

    @Override
    public int insertBranch(Branch model) {
        return sessionFactory.getCurrentSession().createSQLQuery("insert into branch values(null,'"+model.getAddressLine1()+"','"+model.getAddressLine2()+"','"+model.getCity()+"','"+model.getTel1()+"','"+model.getTel2()+"','"+model.getOwner().getOwnerId()+"','"+model.getTown().getTownId()+"')").executeUpdate();
    }
}
