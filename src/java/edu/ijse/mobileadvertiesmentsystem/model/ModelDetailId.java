/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Ashan Tharuka
 */
@Embeddable
public class ModelDetailId extends SuperModel{

    private int modelId;
    private int ownerId;

    public ModelDetailId() {
    }

    public ModelDetailId(int modelId, int ownerId) {
        this.modelId = modelId;
        this.ownerId = ownerId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.modelId;
        hash = 89 * hash + this.ownerId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ModelDetailId other = (ModelDetailId) obj;
        if (this.modelId != other.modelId) {
            return false;
        }
        if (this.ownerId != other.ownerId) {
            return false;
        }
        return true;
    }

    
    
}
