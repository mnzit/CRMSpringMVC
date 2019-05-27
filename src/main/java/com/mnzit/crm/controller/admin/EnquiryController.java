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
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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

    public EnquiryController() {
        link = "admin/enquiries";
    }

    @GetMapping
    public String index(Model model) {
        return link + "/index";
    }

    @PostMapping
    @Override
    public String save(EnquiryDTO model) {
        System.out.println(model.toString());
        enquiryService.save(model);
        return "redirect:/" + link;
    }

    @GetMapping(value = "/delete/{id}")
    @Override
    public String delete(@PathVariable("id") int id) {
        enquiryService.delete(id);
        return "redirect:/" + link;
    }

    @GetMapping(value = "/hasvisited/{id}")
    @ResponseBody
    public boolean isVisited(@PathVariable("id") int id) {
        return enquiryService.setVisited(id, true);
    }

    @GetMapping(value = "/table")
    public String table(Model model) {
        model.addAttribute("enquiries", enquiryService.findAll());
        return link + "/enquiry-table";
    }

    @GetMapping(value = "edit/{id}")
    @ResponseBody
    public Enquiry getDetail(@PathVariable("id") int id) {
        Enquiry enquiry = enquiryService.findById(id);
        if (enquiry != null) {
            return enquiry;
        }
        return null;
    }

    @GetMapping(value = "/getJson")
    @ResponseBody
    public Map getJson() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("sources", enquirySourceService.findAll());
        map.put("statuses", enquiryStatusService.findAll());
        return map;
    }

    @Override
    public String add(Model model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit(int id, Model model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
