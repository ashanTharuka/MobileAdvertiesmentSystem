/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.dto.TownDTO;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface CityService {
    public ArrayList<TownDTO>getAllTown();
    public TownDTO searchByName(String townName);
}
