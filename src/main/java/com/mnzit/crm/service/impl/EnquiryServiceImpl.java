/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.service.impl;

import com.mnzit.crm.dto.EnquiryDTO;
import com.mnzit.crm.entity.Enquiry;
import com.mnzit.crm.entity.master.EnquirySource;
import com.mnzit.crm.entity.master.EnquiryStatus;
import com.mnzit.crm.repository.EnquiryRepository;
import com.mnzit.crm.service.EnquiryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mnzit
 */
@Service
public class EnquiryServiceImpl implements EnquiryService {

    @Autowired
    private EnquiryRepository repository;

    @Override
    public void save(EnquiryDTO model) {
        Enquiry enquiry = new Enquiry();
        enquiry.setFirstName(model.getFirstName());
        enquiry.setLastName(model.getLastName());
        enquiry.setEmail(model.getEmail());
        enquiry.setContactNo(model.getContactNo());
        enquiry.setEnquirySource(new EnquirySource(model.getEnquirySourceId()));
        enquiry.setEnquiryStatus(new EnquiryStatus(model.getEnquiryStatusId()));
        enquiry.setReferredBy(model.getReferredBy());
        if (model.getId() == 0) {
            repository.insert(enquiry);
        } else {
            enquiry.setId(model.getId());
            repository.update(enquiry);
        }
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public Enquiry findById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Enquiry> findAll() {
        return repository.getAll();
    }

    @Override
    public boolean setVisited(int id, boolean condition) {
        return repository.setVisited(id, condition);
    }
}
