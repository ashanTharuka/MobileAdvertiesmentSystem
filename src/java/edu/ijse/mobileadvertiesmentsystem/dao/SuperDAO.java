/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dao;

import edu.ijse.mobileadvertiesmentsystem.model.SuperModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ashan Tharuka
 */
public interface SuperDAO<T extends SuperModel> {

    public Serializable add(T model);

    public int update(T model);

    public T search(String id);

    public   List<Object[]>   searchByName(String name);

    public  T  searchById(String id);

    public int delete(String id);

    public ArrayList<T> getAll();
}
