/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.AdvertiesmentDAO;
import edu.ijse.mobileadvertiesmentsystem.model.AdvertiesmentDetail;
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
public class AdvertiesmentDAOImpl implements AdvertiesmentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable add(AdvertiesmentDetail model) {

        return sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public int update(AdvertiesmentDetail model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdvertiesmentDetail search(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> searchByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdvertiesmentDetail searchById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AdvertiesmentDetail> getAll() {
        return (ArrayList<AdvertiesmentDetail>) sessionFactory.getCurrentSession().createQuery("from AdvertiesmentDetail").list();
    }

    @Override
    public int deleteAddDetail(String shopId, String modelId) {
        return (int) sessionFactory.getCurrentSession().createSQLQuery("delete from AdvertiesmentDetail  where modelId='" + modelId + "' AND ownerId='" + shopId + "'").executeUpdate();
    }

    @Override
    public Serializable saveAdd(String modelId, String ownerId, String color, String price) {
        return sessionFactory.getCurrentSession().createSQLQuery("insert into AdvertiesmentDetail values('" + modelId + "','" + ownerId + "','" + color + "','" + price + "')").executeUpdate();
    }

    @Override
    public Serializable addPenddniigAdd(Pendding model) {
      return sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public List<Object[]> getAllAddByShop(String shopName) {
        return sessionFactory.getCurrentSession().createSQLQuery("select modelName_1,color,price from AdvertiesmentDetail ad,Model m,Owner o where ad.ownerId=o.ownerId AND m.modelId=ad.modelId AND shopName='"+shopName+"'").list();
    }

}
