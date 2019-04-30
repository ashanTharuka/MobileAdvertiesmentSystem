/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom;

import edu.ijse.mobileadvertiesmentsystem.dao.SuperDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Brand;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ashan Tharuka
 */
public interface BrandDAO extends SuperDAO<Brand> {

    public List<Object[]> getAll(String mName);

    public List<Object[]> isExistAssociate(String brandId,String mainId);

    public Serializable addAssociateValue(String brandId, String mainId);

}
