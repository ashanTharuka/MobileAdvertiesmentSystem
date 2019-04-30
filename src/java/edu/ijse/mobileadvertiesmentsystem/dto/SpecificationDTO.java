/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.dto;

import edu.ijse.mobileadvertiesmentsystem.model.Model;
import java.io.Serializable;

/**
 *
 * @author Ashan Tharuka
 */
public class SpecificationDTO implements Serializable {

    private int specificationId;

    private Model model;
    private String modelId;
    private String spcificationName;
    private String specificationDescription;

    public int getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(int specificationId) {
        this.specificationId = specificationId;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getSpcificationName() {
        return spcificationName;
    }

    public void setSpcificationName(String spcificationName) {
        this.spcificationName = spcificationName;
    }

    public String getSpecificationDescription() {
        return specificationDescription;
    }

    public void setSpecificationDescription(String specificationDescription) {
        this.specificationDescription = specificationDescription;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

}
