/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.repository.impl;

import com.mnzit.crm.entity.master.EnquiryStatus;
import com.mnzit.crm.repository.EnquiryStatusRepository;
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
public class EnquiryStatusRepositoryImpl implements EnquiryStatusRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public void insert(EnquiryStatus model) {
        String sql = "INSERT INTO mst_enquiry_status (status_name,status_color) VALUES (?,?)";
        template.update(sql, new Object[]{model.getName(), model.getColor()});
    }

    @Override
    public void update(EnquiryStatus model) {
        String sql = "UPDATE mst_enquiry_status SET status_name=?,status_color=? WHERE id=?";
        template.update(sql, new Object[]{model.getName(), model.getColor(), model.getId()});
    }

    @Override
    public boolean delete(int id) {
        String sql = "UPDATE mst_enquiry_status SET is_deleted=true,deleted_date=CURRENT_TIMESTAMP WHERE id=?";
        return template.update(sql, new Object[]{id}) > 0;
    }

    @Override
    public EnquiryStatus getById(int id) {
        String sql = "SELECT * FROM vw_enquiry_status WHERE id=?";
        EnquiryStatus enquiryStatus = null;
        try {
            enquiryStatus = template.queryForObject(sql, new Object[]{id}, new RowMapper<EnquiryStatus>() {
                @Override
                public EnquiryStatus mapRow(ResultSet rs, int i) throws SQLException {
                    EnquiryStatus enquiryStatus = new EnquiryStatus();
                    enquiryStatus.setId(rs.getInt("id"));
                    enquiryStatus.setName(rs.getString("status_name"));
                    enquiryStatus.setColor(rs.getString("status_color"));
                    return enquiryStatus;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return enquiryStatus;
    }

    @Override
    public List<EnquiryStatus> getAll() {
        String sql = "SELECT * FROM vw_enquiry_status";
        return template.query(sql, new RowMapper<EnquiryStatus>() {
            @Override
            public EnquiryStatus mapRow(ResultSet rs, int i) throws SQLException {
                EnquiryStatus enquiryStatus = new EnquiryStatus();
                enquiryStatus.setId(rs.getInt("id"));
                enquiryStatus.setName(rs.getString("status_name"));
                enquiryStatus.setColor(rs.getString("status_color"));
                return enquiryStatus;
            }
        });
    }
}
