/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.controller;

import org.springframework.ui.Model;

/**
 *
 * @author Mnzit
 */
public abstract class CRUDController<T> {

    public abstract String index(Model model);

    public abstract String add(Model model);

    public abstract String edit(int id, Model model);

    public abstract String save(T model);

    public abstract String delete(int id);
}
