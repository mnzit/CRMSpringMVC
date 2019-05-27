/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.controller.admin;

import com.mnzit.crm.dto.FollowUpDTO;
import com.mnzit.crm.entity.FollowUp;
import com.mnzit.crm.service.FollowUpService;
import com.mnzit.crm.service.FollowUpStatusService;
import java.util.List;
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
@RequestMapping(value = "/admin/enquiries/{enquiryId}/followups")
public class FollowUpController {

    @Autowired
    private FollowUpService service;

    @GetMapping(value = "/table")
    public String table(@PathVariable("enquiryId") int enquiryId, Model model) {
        List<FollowUp> followUps = service.findAllById(enquiryId);
        if (followUps != null) {
            model.addAttribute("followups", followUps);
            return "admin/followups/followup-table";
        }
        return null;
    }

    @PostMapping
    public String save(FollowUpDTO followUpDTO) {
        service.save(followUpDTO);
        return "redirect:/admin/enquiries/";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/admin/enquiries";
    }
}
