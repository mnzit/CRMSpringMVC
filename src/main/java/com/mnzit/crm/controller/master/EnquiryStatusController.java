/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.controller.master;

import com.mnzit.crm.controller.CRUDController;
import com.mnzit.crm.dto.master.EnquirySourceDTO;
import com.mnzit.crm.dto.master.EnquiryStatusDTO;
import com.mnzit.crm.entity.master.EnquirySource;
import com.mnzit.crm.entity.master.EnquiryStatus;
import com.mnzit.crm.service.EnquirySourceService;
import com.mnzit.crm.service.EnquiryStatusService;
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
@RequestMapping(value = "/admin/master/enquiries/status")
public class EnquiryStatusController extends CRUDController<EnquiryStatusDTO> {

    @Autowired
    private EnquiryStatusService service;

    @GetMapping
    @Override
    public String index(Model model) {
        model.addAttribute("statuses", service.findAll());
        return "master/enquirystatus/index";
    }

    @GetMapping(value = "/add")
    @Override
    public String add(Model model) {
        return "master/enquirystatus/add";
    }

    @GetMapping(value = "/edit/{id}")
    @Override
    public String edit(@PathVariable("id") int id, Model model) {
        EnquiryStatus enquiryStatus = service.findById(id);
        if (enquiryStatus != null) {
            model.addAttribute("status", enquiryStatus);
            return "master/enquirystatus/edit";
        }
        return "redirect:/admin/master/enquiries/status";
    }

    @PostMapping
    @Override
    public String save(EnquiryStatusDTO model) {
        service.save(model);
        return "redirect:/admin/master/enquiries/status";
    }

    @GetMapping(value = "/delete/{id}")
    @Override
    public String delete(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/admin/master/enquiries/status";
    }

}
