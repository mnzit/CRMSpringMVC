/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.controller.master;

import com.mnzit.crm.controller.CRUDController;
import com.mnzit.crm.dto.master.FollowUpStatusDTO;
import com.mnzit.crm.entity.master.FollowUpStatus;
import com.mnzit.crm.service.FollowUpStatusService;
import java.util.List;
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
@RequestMapping(value = "/admin/master/enquiries/followup/status")
public class FollowUpStatusController extends CRUDController<FollowUpStatusDTO> {

    @Autowired
    private FollowUpStatusService service;

    @GetMapping
    @Override
    public String index(Model model) {
        model.addAttribute("statuses", service.findAll());
        return "master/followupstatus/index";
    }


    @GetMapping(value = "/getJson")
    @ResponseBody
    public List<FollowUpStatus> getJson() {
        return service.findAll();
    }

    @GetMapping(value = "/add")
    @Override
    public String add(Model model) {
        return "master/followupstatus/add";
    }

    @GetMapping(value = "/edit/{id}")
    @Override
    public String edit(@PathVariable("id") int id, Model model) {
        FollowUpStatus followUpStatus = service.findById(id);
        if (followUpStatus != null) {
            model.addAttribute("status", service.findById(id));
            return "master/followupstatus/edit";
        }
        return "redirect:/admin/master/enquiries/followup/status";
    }

    @PostMapping
    @Override
    public String save(FollowUpStatusDTO model) {
        service.save(model);
        return "redirect:/admin/master/enquiries/followup/status";
    }

    @GetMapping(value = "/delete/{id}")
    @Override
    public String delete(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/admin/master/enquiries/followup/status";
    }

}
