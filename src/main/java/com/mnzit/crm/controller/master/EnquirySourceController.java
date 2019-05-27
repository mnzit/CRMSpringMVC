/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.controller.master;

import com.mnzit.crm.controller.CRUDController;
import com.mnzit.crm.dto.master.EnquirySourceDTO;
import com.mnzit.crm.entity.master.EnquirySource;
import com.mnzit.crm.service.EnquirySourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mnzit
 */
@Controller
@RequestMapping(value = "/admin/master/enquiries/source")
public class EnquirySourceController extends CRUDController<EnquirySourceDTO> {

    @Autowired
    private EnquirySourceService service;

    @GetMapping
    @Override
    public String index(Model model) {
        model.addAttribute("sources", service.findAll());
        return "master/enquirysource/index";
    }

    @GetMapping(value = "/add")
    @Override
    public String add(Model model) {
        return "master/enquirysource/add";
    }

    @GetMapping(value = "/edit/{id}")
    @Override
    public String edit(@PathVariable("id") int id, Model model) {
        EnquirySource enquirySource = service.findById(id);
        if (enquirySource != null) {
            model.addAttribute("source", enquirySource);
            return "master/enquirysource/edit";
        }
        return "redirect:/admin/master/enquiries/source";
    }

    @PostMapping
    @Override
    public String save(EnquirySourceDTO model) {
        service.save(model);
        return "redirect:/admin/master/enquiries/source";
    }

    @GetMapping(value = "/delete/{id}")
    @Override
    public String delete(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/admin/master/enquiries/source";
    }

}
