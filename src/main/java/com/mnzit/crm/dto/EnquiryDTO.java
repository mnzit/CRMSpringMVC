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
public class EnquiryDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private int enquirySourceId;
    private int enquiryStatusId;
    private String referredBy;

    public EnquiryDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getEnquirySourceId() {
        return enquirySourceId;
    }

    public void setEnquirySourceId(int enquirySourceId) {
        this.enquirySourceId = enquirySourceId;
    }

    public int getEnquiryStatusId() {
        return enquiryStatusId;
    }

    public void setEnquiryStatusId(int enquiryStatusId) {
        this.enquiryStatusId = enquiryStatusId;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    @Override
    public String toString() {
        return "EnquiryDTO{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", contactNo=" + contactNo + ", enquirySourceId=" + enquirySourceId + ", enquiryStatusId=" + enquiryStatusId + ", referredBy=" + referredBy + '}';
    }
    

}
