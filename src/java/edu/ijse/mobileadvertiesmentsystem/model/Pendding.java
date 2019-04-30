/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Ashan Tharuka
 */
@Entity
public class Pendding extends SuperModel{

    @EmbeddedId
    private ModelDetailId modelDetailId;

    @JoinColumn(name = "modelId", referencedColumnName = "modelId", insertable = false, updatable = false)
    @ManyToOne
    private Model model;

    @JoinColumn(name = "ownerId", referencedColumnName = "ownerId", insertable = false, updatable = false)
    @ManyToOne
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pendding")
    private Set<WarrantyPendding> warrantys = new HashSet<>();


    private double price;

    private String color;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public ModelDetailId getModelDetailId() {
        return modelDetailId;
    }

    public void setModelDetailId(ModelDetailId modelDetailId) {
        this.modelDetailId = modelDetailId;
    }

    public Set<WarrantyPendding> getWarrantys() {
        return warrantys;
    }

    public void setWarrantys(Set<WarrantyPendding> warrantys) {
        this.warrantys = warrantys;
    }

   
}
