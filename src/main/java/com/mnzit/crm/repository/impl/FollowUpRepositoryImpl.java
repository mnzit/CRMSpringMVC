/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.repository.impl;

import com.mnzit.crm.entity.FollowUp;
import com.mnzit.crm.entity.master.FollowUpStatus;
import com.mnzit.crm.repository.FollowUpRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mnzit
 */
@Repository
public class FollowUpRepositoryImpl implements FollowUpRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public void insert(FollowUp model) {
        String sql = "INSERT INTO tbl_follow_ups (message,enquiry_id,status_id) VALUES (?,?,?)";
        template.update(sql, new Object[]{model.getMessage(), model.getEnquiry().getId(), model.getFollowUpStatus().getId()});
    }

    @Override
    public void update(FollowUp model) {
        throw new UnsupportedOperationException("Not supported yesst."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        String sql = "UPDATE tbl_follow_ups SET is_deleted=true,deleted_date=CURRENT_TIMESTAMP WHERE id=?";
        return template.update(sql, new Object[]{id}) > 0;
    }

    @Override
    public FollowUp getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FollowUp> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FollowUp> getAllById(int id) {
        String sql = "SELECT * FROM vw_follow_ups WHERE enquiry_id=?";
        return template.query(sql, new Object[]{id}, new RowMapper<FollowUp>() {
            @Override
            public FollowUp mapRow(ResultSet rs, int i) throws SQLException {
                FollowUp followUp = new FollowUp();
                followUp.setId(rs.getInt("id"));
                followUp.setMessage(rs.getString("message"));
                followUp.setFollowUpStatus(new FollowUpStatus(rs.getInt("status_id"), rs.getString("status_name"), rs.getString("status_color")));
                followUp.setCreatedDate(new Date(rs.getDate("created_date").getTime()));
                return followUp;
            }
        });
    }
}
