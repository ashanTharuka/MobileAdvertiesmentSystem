/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.BrandDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Brand;
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
public class BrandDAOImpl implements BrandDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Object[]> getAll(String id) {
//        return sessionFactory.getCurrentSession().createSQLQuery("select brandId,brandName from Brand where brandId='" + id + "'").list();
        return sessionFactory.getCurrentSession().createSQLQuery(" select brandName,brandId from Brand b,Brand_Detail bd,MainCategory m where  b.brandId=bd.brand_Id AND bd.mainCategory_Id=m.mainCategoryId AND mainCategoryName='" + id + "'").list();

    }

    @Override
    public Serializable add(Brand model) {
        return sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public int update(Brand model) {
        return (int) sessionFactory.getCurrentSession().createSQLQuery("UPDATE Brand SET brandName = '" + model.getBrandName() + "' where brandId='" + model.getBrandId() + "'").executeUpdate();
    }

    @Override
    public Brand search(String id) {
        return (Brand) sessionFactory.getCurrentSession().get(Brand.class, id);
    }

    @Override
    public List<Object[]> searchByName(String name) {
        return sessionFactory.getCurrentSession().createSQLQuery("select * from Brand where brandName='" + name + "'").list();
    }

    @Override
    public Brand searchById(String id) {
        return(Brand) sessionFactory.getCurrentSession().get(Brand.class, Integer.parseInt(id));
    }

    @Override
    public int delete(String id) {
        return (int) sessionFactory.getCurrentSession().createSQLQuery("delete from Brand_Detail  where brand_Id='" + id + "'").executeUpdate();
    }

    @Override
    public ArrayList<Brand> getAll() {
        return (ArrayList<Brand>) sessionFactory.getCurrentSession().createQuery("from Brand").list();
    }

    @Override
    public List<Object[]> isExistAssociate(String brandId, String mainId) {
        return sessionFactory.getCurrentSession().createSQLQuery("select brand_id,mainCategory_id from Brand_Detail where brand_id='" + brandId + "' AND mainCategory_id='" + mainId + "' ").list();
    }

    @Override
    public Serializable addAssociateValue(String brandId, String mainId) {
        return sessionFactory.getCurrentSession().createSQLQuery("insert into Brand_Detail values('" + brandId + "','" + mainId + "')").executeUpdate();
    }

}
