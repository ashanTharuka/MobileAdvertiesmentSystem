/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ashan Tharuka
 */
@Entity
public class Specification extends SuperModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int specificationId;

    @ManyToOne
    @JoinColumn(name = "model_Id")
    private Model model;

  

    private String spcificationName;
    private String specificationDescription;

    public int getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(int specificationId) {
        this.specificationId = specificationId;
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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

}
