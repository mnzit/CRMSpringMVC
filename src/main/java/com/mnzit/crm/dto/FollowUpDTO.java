/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.dto;

/**
 *
 * @author Mnzit
 */
public class FollowUpDTO {

    private int id;
    private String message;
    private int enquiryId;
    private int followUpStatusId;

    public FollowUpDTO() {
    }

    public FollowUpDTO(int id, String message, int enquiryId, int followUpStatusId) {
        this.id = id;
        this.message = message;
        this.enquiryId = enquiryId;
        this.followUpStatusId = followUpStatusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(int enquiryId) {
        this.enquiryId = enquiryId;
    }

    public int getFollowUpStatusId() {
        return followUpStatusId;
    }

    public void setFollowUpStatusId(int followUpStatusId) {
        this.followUpStatusId = followUpStatusId;
    }

    @Override
    public String toString() {
        return "FollowUpDTO{" + "id=" + id + ", message=" + message + ", enquiryId=" + enquiryId + ", followUpStatusId=" + followUpStatusId + '}';
    }
    
    

}
