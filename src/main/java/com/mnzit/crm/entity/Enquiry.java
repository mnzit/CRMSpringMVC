/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.entity;

import com.mnzit.crm.entity.common.MasterEntity;
import com.mnzit.crm.entity.master.EnquirySource;
import com.mnzit.crm.entity.master.EnquiryStatus;
import java.util.Date;

/**
 *
 * @author Mnzit
 */
public class Enquiry extends MasterEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String contactNo;
    private EnquirySource enquirySource;
    private EnquiryStatus enquiryStatus;
    private boolean visited;
    private Date visitedDate;
    private String referredBy;
    private int createdBy;
    private int followUp;

    public Enquiry() {
    }

    public Enquiry(int id) {
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

    public EnquirySource getEnquirySource() {
        return enquirySource;
    }

    public void setEnquirySource(EnquirySource enquirySource) {
        this.enquirySource = enquirySource;
    }

    public EnquiryStatus getEnquiryStatus() {
        return enquiryStatus;
    }

    public void setEnquiryStatus(EnquiryStatus enquiryStatus) {
        this.enquiryStatus = enquiryStatus;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Date getVisitedDate() {
        return visitedDate;
    }

    public void setVisitedDate(Date visitedDate) {
        this.visitedDate = visitedDate;
    }

    public String getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(String referredBy) {
        this.referredBy = referredBy;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getFollowUp() {
        return followUp;
    }

    public void setFollowUp(int followUp) {
        this.followUp = followUp;
    }

    @Override
    public String toString() {
        return "Enquiry{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", contactNo=" + contactNo + ", enquirySource=" + enquirySource.toString() + ", enquiryStatus=" + enquiryStatus.toString() + ", visited=" + visited + ", visitedDate=" + visitedDate + ", referredBy=" + referredBy + ", createdBy=" + createdBy + ", followUp=" + followUp + '}';
    }
    

}
