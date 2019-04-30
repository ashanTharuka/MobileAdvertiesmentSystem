/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.dto.MBDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.ModelDTO;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface ModelService {

    public MBDTO SearchQuery(String id);

    public String searchByName(String name);

    public ModelDTO searchById(String id);

    public String addModelDTO(ModelDTO model);

    public ArrayList<ModelDTO> getAll();
    public ArrayList<ModelDTO> getAll(String modelName);
}
