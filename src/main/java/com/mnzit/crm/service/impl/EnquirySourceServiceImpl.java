/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.service.impl;

import com.mnzit.crm.dto.master.EnquirySourceDTO;
import com.mnzit.crm.entity.master.EnquirySource;
import com.mnzit.crm.repository.EnquirySourceRepository;
import com.mnzit.crm.service.EnquirySourceService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mnzit
 */
@Service
public class EnquirySourceServiceImpl implements EnquirySourceService {

    @Autowired
    private EnquirySourceRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(EnquirySourceDTO model) {
        EnquirySource enquirySource =  mapper.map(model, EnquirySource.class);
        if (model.getId() > 0) {
            repository.update(enquirySource);
        } else {
            repository.insert(enquirySource);
        }
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public EnquirySource findById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<EnquirySource> findAll() {
        return repository.getAll();
    }
}
