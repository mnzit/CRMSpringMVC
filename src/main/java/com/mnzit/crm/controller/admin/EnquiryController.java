/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.controller.admin;

import com.mnzit.crm.controller.CRUDController;
import com.mnzit.crm.dto.EnquiryDTO;
import com.mnzit.crm.entity.Enquiry;
import com.mnzit.crm.service.EnquiryService;
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
@RequestMapping(value = "/admin/enquiries")
public class EnquiryController extends CRUDController<EnquiryDTO> {

    @Autowired
    private EnquirySourceService enquirySourceService;
    @Autowired
    private EnquiryStatusService enquiryStatusService;
    @Autowired
    private EnquiryService enquiryService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("enquiries", enquiryService.findAll());
        return "admin/enquiries/index";
    }

    @GetMapping(value = "/add")
    @Override
    public String add(Model model) {
        model.addAttribute("sources", enquirySourceService.findAll());
        model.addAttribute("statuses", enquiryStatusService.findAll());
        return "admin/enquiries/add";
    }

    @GetMapping(value = "/edit/{id}")
    @Override
    public String edit(@PathVariable("id") int id, Model model) {
        Enquiry enquiry = enquiryService.findById(id);
        if (enquiry != null) {
            model.addAttribute("enquiry", enquiry);
            model.addAttribute("sources", enquirySourceService.findAll());
            model.addAttribute("statuses", enquiryStatusService.findAll());
            return "admin/enquiries/edit";
        }
        return "redirect:/admin/enquiries";
    }

    @PostMapping
    @Override
    public String save(EnquiryDTO model) {
        enquiryService.save(model);
        return "redirect:/admin/enquiries";
    }

    @GetMapping(value = "/delete/{id}")
    @Override
    public String delete(@PathVariable("id") int id) {
        enquiryService.delete(id);
        return "redirect:/admin/enquiries";
    }

    @GetMapping(value = "/hasvisited/{id}")
    public String isVisited(@PathVariable("id") int id) {
        enquiryService.setVisited(id, true);
        return "redirect:/admin/enquiries";
    }
}
