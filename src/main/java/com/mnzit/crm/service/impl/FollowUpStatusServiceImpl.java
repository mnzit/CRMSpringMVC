/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.service.impl;

import com.mnzit.crm.dto.master.FollowUpStatusDTO;
import com.mnzit.crm.entity.master.FollowUpStatus;
import com.mnzit.crm.repository.FollowUpStatusRepository;
import com.mnzit.crm.service.FollowUpStatusService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mnzit
 */
@Service
public class FollowUpStatusServiceImpl implements FollowUpStatusService {

    @Autowired
    private FollowUpStatusRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void save(FollowUpStatusDTO model) {
        FollowUpStatus followUpStatus = mapper.map(model, FollowUpStatus.class);
        if (model.getId() > 0) {
            repository.update(followUpStatus);
        } else {
            repository.insert(followUpStatus);
        }
    }
    
    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }

    @Override
    public FollowUpStatus findById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<FollowUpStatus> findAll() {
        return repository.getAll();
    }

}
