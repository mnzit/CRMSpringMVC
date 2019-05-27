/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.entity.master;

import com.mnzit.crm.entity.common.MasterEntity;

/**
 *
 * @author Mnzit
 */
public class EnquirySource extends MasterEntity {

    private String name;
    private String color;

    public EnquirySource() {
    }
    
    public EnquirySource(int id) {
        this.id = id;
    }

    public EnquirySource(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "EnquirySource{" + "id=" + id + "," + "name=" + name + ", color=" + color + '}';
    }
    
    

}
