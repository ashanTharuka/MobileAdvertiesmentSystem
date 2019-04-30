/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom;

import edu.ijse.mobileadvertiesmentsystem.dao.SuperDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Specification;
import edu.ijse.mobileadvertiesmentsystem.model.SpecificationType;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ashan Tharuka
 */
public interface SpecificationTypeDAO extends SuperDAO<SpecificationType>{
     public List<Object[]> getAll(String mName);
     public List<Object[]> getAllByName(String mName);
     public Serializable addSpecification(Specification spec);
     public int updateSpec(Specification spec);
}
