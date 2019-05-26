/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.repository.impl;

import com.mnzit.crm.entity.master.EnquirySource;
import com.mnzit.crm.repository.EnquirySourceRepository;
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
public class EnquirySourceRepositoryImpl implements EnquirySourceRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public void insert(EnquirySource model) {
        String sql = "INSERT INTO mst_enquiry_source (source_name,source_color) VALUES (?,?)";
        template.update(sql, new Object[]{model.getName(), model.getColor()});
    }

    @Override
    public void update(EnquirySource model) {
        String sql = "UPDATE mst_enquiry_source SET source_name=?,source_color=? WHERE id=?";
        template.update(sql, new Object[]{model.getName(), model.getColor(), model.getId()});
    }

    @Override
    public boolean delete(int id) {
        String sql = "UPDATE mst_enquiry_source SET is_deleted=true,deleted_date=CURRENT_TIMESTAMP WHERE id=?";
        return template.update(sql, new Object[]{id}) > 0;
    }

    @Override
    public EnquirySource getById(int id) {
        String sql = "SELECT * FROM vw_enquiry_source WHERE id=?";
        EnquirySource enquirySource = null;
        try {
            enquirySource = template.queryForObject(sql, new Object[]{id}, new RowMapper<EnquirySource>() {
                @Override
                public EnquirySource mapRow(ResultSet rs, int i) throws SQLException {
                    EnquirySource enquirySource = new EnquirySource();
                    enquirySource.setId(rs.getInt("id"));
                    enquirySource.setName(rs.getString("source_name"));
                    enquirySource.setColor(rs.getString("source_color"));
                    return enquirySource;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return enquirySource;
    }

    @Override
    public List<EnquirySource> getAll() {
        String sql = "SELECT * FROM vw_enquiry_source";
        return template.query(sql, new RowMapper<EnquirySource>() {
            @Override
            public EnquirySource mapRow(ResultSet rs, int i) throws SQLException {
                EnquirySource enquirySource = new EnquirySource();
                enquirySource.setId(rs.getInt("id"));
                enquirySource.setName(rs.getString("source_name"));
                enquirySource.setColor(rs.getString("source_color"));
                return enquirySource;
            }
        });
    }
}
