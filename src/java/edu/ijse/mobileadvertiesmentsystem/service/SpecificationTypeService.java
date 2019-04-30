/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.service;

import edu.ijse.mobileadvertiesmentsystem.dto.SpecificationDTO;
import edu.ijse.mobileadvertiesmentsystem.dto.SpecificationTypeDTO;
import edu.ijse.mobileadvertiesmentsystem.model.Specification;
import java.util.ArrayList;

/**
 *
 * @author Ashan Tharuka
 */
public interface SpecificationTypeService {

    public String addSpecificationType(SpecificationTypeDTO specType);

    public String updateSpecificationType(SpecificationTypeDTO specType);

    public SpecificationTypeDTO searchSpecificationType(String id);

    public String deleteSpecificationType(String id);

    public String isExist(String key, String id);

    public ArrayList<SpecificationTypeDTO> getAll();

    public ArrayList<SpecificationTypeDTO> getAll(String mName);
    public ArrayList<SpecificationDTO> getAllByName(String mName);
    
    public String addSpecification(Specification spec);
    public String updatSpec(SpecificationDTO sp);
}
