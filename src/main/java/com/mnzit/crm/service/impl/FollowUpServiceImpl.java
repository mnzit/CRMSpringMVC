/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.service.impl;

import com.mnzit.crm.dto.FollowUpDTO;
import com.mnzit.crm.entity.FollowUp;
import com.mnzit.crm.repository.EnquiryRepository;
import com.mnzit.crm.repository.FollowUpRepository;
import com.mnzit.crm.service.FollowUpService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mnzit
 */
@Service
public class FollowUpServiceImpl implements FollowUpService {

    @Autowired
    private FollowUpRepository repository;

    @Autowired
    private EnquiryRepository enquiryRepository;


    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(FollowUpDTO model) {
        FollowUp followUp = mapper.map(model, FollowUp.class);
        if (model.getId() == 0) {
            repository.insert(followUp);
        } else {
            repository.update(followUp);
        }
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public FollowUp findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FollowUp> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FollowUp> findAllById(int id) {
        if (enquiryRepository.getById(id) != null) {
            return repository.getAllById(id);
        }
        return null;
    }

}
