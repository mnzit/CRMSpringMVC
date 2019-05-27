/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.repository.impl;

import com.mnzit.crm.entity.Enquiry;
import com.mnzit.crm.entity.master.EnquirySource;
import com.mnzit.crm.entity.master.EnquiryStatus;
import com.mnzit.crm.repository.EnquiryRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mnzit
 */
@Repository
public class EnquiryRepositoryImpl implements EnquiryRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public void insert(Enquiry model) {
        String sql = "INSERT INTO tbl_enquiries (first_name,last_name,email,contact_no,enquiry_source_id,enquiry_status_id,referred_by) VALUES (?,?,?,?,?,?,?)";
        template.update(sql, new Object[]{model.getFirstName(), model.getLastName(), model.getEmail(), model.getContactNo(),
            model.getEnquirySource().getId(), model.getEnquiryStatus().getId(), model.getReferredBy()});
    }

    @Override
    public void update(Enquiry model) {
        String sql = "UPDATE tbl_enquiries SET first_name=?,last_name=?,email=?,contact_no=?,"
                + "enquiry_source_id=?,enquiry_status_id=?,referred_by=?,modified_date=CURRENT_TIMESTAMP WHERE id=?";
        template.update(sql, new Object[]{model.getFirstName(), model.getLastName(), model.getEmail(), model.getContactNo(),
            model.getEnquirySource().getId(), model.getEnquiryStatus().getId(), model.getReferredBy(), model.getId()});
    }

    @Override
    public boolean delete(int id) {
        String sql = "UPDATE tbl_enquiries SET is_deleted=true,deleted_date=CURRENT_TIMESTAMP WHERE id=?";
        return template.update(sql, new Object[]{id}) > 0;
    }

    @Override
    public Enquiry getById(int id) {
        Enquiry enquiry = null;
        String sql = "SELECT * FROM vw_enquiries WHERE id=?";
        try {
            enquiry = template.queryForObject(sql, new Object[]{id}, new RowMapper<Enquiry>() {
                @Override
                public Enquiry mapRow(ResultSet rs, int i) throws SQLException {
                    Enquiry enquiry = new Enquiry();
                    enquiry.setId(rs.getInt("id"));
                    enquiry.setFirstName(rs.getString("first_name"));
                    enquiry.setLastName(rs.getString("last_name"));
                    enquiry.setEmail(rs.getString("email"));
                    enquiry.setContactNo(rs.getString("contact_no"));
                    enquiry.setEnquirySource(new EnquirySource(rs.getInt("enquiry_source_id"), rs.getString("source_name"), rs.getString("source_color")));
                    enquiry.setEnquiryStatus(new EnquiryStatus(rs.getInt("enquiry_status_id"), rs.getString("status_name"), rs.getString("status_color")));
                    enquiry.setReferredBy(rs.getString("referred_by"));
                    enquiry.setFollowUp(rs.getInt("follow_up"));
                    return enquiry;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return enquiry;
    }

    @Override
    public List<Enquiry> getAll() {
        String sql = "SELECT * FROM vw_enquiries";
        return template.query(sql, new RowMapper<Enquiry>() {
            @Override
            public Enquiry mapRow(ResultSet rs, int i) throws SQLException {
                Enquiry enquiry = new Enquiry();
                enquiry.setId(rs.getInt("id"));
                enquiry.setFirstName(rs.getString("first_name"));
                enquiry.setLastName(rs.getString("last_name"));
                enquiry.setEmail(rs.getString("email"));
                enquiry.setContactNo(rs.getString("contact_no"));
                enquiry.setEnquirySource(new EnquirySource(rs.getInt("id"), rs.getString("source_name"), rs.getString("source_color")));
                enquiry.setEnquiryStatus(new EnquiryStatus(rs.getInt("id"), rs.getString("status_name"), rs.getString("status_color")));
                enquiry.setReferredBy(rs.getString("referred_by"));
                enquiry.setFollowUp(rs.getInt("follow_up"));
                enquiry.setVisited(rs.getBoolean("is_visited"));
                return enquiry;
            }
        });
    }

    @Override
    public boolean setVisited(int id, boolean condition) {
        String sql = "UPDATE tbl_enquiries SET is_visited=?,visited_date=CURRENT_TIMESTAMP WHERE id=?";
        return template.update(sql, new Object[]{condition, id}) > 0;
    }

}
