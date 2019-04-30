/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom.impl;

import edu.ijse.mobileadvertiesmentsystem.dao.custom.SpecificationTypeDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Specification;
import edu.ijse.mobileadvertiesmentsystem.model.SpecificationType;
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
public class SpecificationTypeDAOImpl implements SpecificationTypeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Serializable add(SpecificationType model) {
        return sessionFactory.getCurrentSession().save(model);
    }

    @Override
    public int update(SpecificationType model) {
        return (int) sessionFactory.getCurrentSession().createSQLQuery("UPDATE SpecificationType SET specificationType = '" + model.getSpecificationType() + "' where specificationTypeId='" + model.getSpecificationTypeId() + "'").executeUpdate();
    }

    @Override
    public SpecificationType search(String id) {
        return (SpecificationType) sessionFactory.getCurrentSession().get(SpecificationType.class, id);
    }

    @Override
    public  List<Object[]>  searchByName(String name) {
        return sessionFactory.getCurrentSession().createSQLQuery("select specificationTypeId from SpecificationType where specificationType='" + name + "'").list();
    }

    @Override
    public SpecificationType searchById(String id) {
        return (SpecificationType)sessionFactory.getCurrentSession().get(SpecificationType.class, Integer.parseInt(id));
    }

    @Override
    public int delete(String id) {
        return (int) sessionFactory.getCurrentSession().createSQLQuery("delete from SpecificationType  where specificationTypeId='" + id + "'").executeUpdate();
    }

    @Override
    public ArrayList<SpecificationType> getAll() {
        return (ArrayList<SpecificationType>) sessionFactory.getCurrentSession().createQuery("from SpecificationType").list();
    }

    @Override
    public List<Object[]> getAll(String id) {
        return sessionFactory.getCurrentSession().createSQLQuery("select specificationTypeId,specificationType from SpecificationType where mainCategory_Id='" + id + "'").list();
    }

    @Override
    public Serializable addSpecification(Specification spec) {
        return sessionFactory.getCurrentSession().save(spec);
    }

    @Override
    public List<Object[]> getAllByName(String mName) {
       return sessionFactory.getCurrentSession().createSQLQuery("select * from Specification s,Model m where m.modelId=s.model_Id AND modelName_1='"+mName+"';").list();
    }

    @Override
    public int updateSpec(Specification spec) {
      return sessionFactory.getCurrentSession().createSQLQuery("update Specification set specificationDescription='"+spec.getSpecificationDescription()+"' where specificationId='"+spec.getSpecificationId()+"'").executeUpdate();
    }

}
