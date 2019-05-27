/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.service;

import java.util.List;

/**
 *
 * @author Mnzit
 */
public interface GenericService<TMODEL,TDTO> {

    void save(TDTO model);

    boolean delete(int id);

    TMODEL findById(int id);

    List<TMODEL> findAll();
}
