/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.service;

import com.mnzit.crm.dto.EnquiryDTO;
import com.mnzit.crm.entity.Enquiry;

/**
 *
 * @author Mnzit
 */
public interface EnquiryService extends GenericService<Enquiry, EnquiryDTO> {

    boolean setVisited(int id, boolean condition);
}
