/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.service;

import com.mnzit.crm.dto.FollowUpDTO;
import com.mnzit.crm.entity.FollowUp;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public interface FollowUpService extends GenericService<FollowUp, FollowUpDTO> {

    List<FollowUp> findAllById(int id);
}
