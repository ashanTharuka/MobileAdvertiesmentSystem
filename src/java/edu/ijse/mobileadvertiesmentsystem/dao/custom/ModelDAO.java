/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao.custom;

import edu.ijse.mobileadvertiesmentsystem.dao.SuperDAO;
import edu.ijse.mobileadvertiesmentsystem.model.Model;
import java.util.List;

/**
 *
 * @author Ashan Tharuka
 */
public interface ModelDAO extends SuperDAO<Model> {

    public List<Object[]> SearchQuery(String id);

    public List<String> searchSpecificationTypes(String mainCategoryName);

    public List<Object[]> getAll(String name);
    public String searchName(String name);
}
