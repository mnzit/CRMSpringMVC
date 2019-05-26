/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.repository;

import java.util.List;

/**
 *
 * @author Mnzit
 */
public interface GenericRepository<T> {

    void insert(T model);

    void update(T model);

    boolean delete(int id);

    T getById(int id);

    List<T> getAll();
}
