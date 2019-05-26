/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.crm.repository.impl;

import com.mnzit.crm.entity.master.FollowUpStatus;
import com.mnzit.crm.repository.FollowUpStatusRepository;
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
public class FollowUpStatusRepositoryImpl implements FollowUpStatusRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public void insert(FollowUpStatus model) {
        String sql = "INSERT INTO mst_follow_up_status(status_name,status_color) VALUES(?,?)";
        template.update(sql, new Object[]{model.getName(), model.getColor()});
    }

    @Override
    public void update(FollowUpStatus model) {
        String sql = "UPDATE mst_follow_up_status SET status_name=?,status_color=? WHERE id=?";
        template.update(sql, new Object[]{model.getName(), model.getColor(), model.getId()});
    }

    @Override
    public boolean delete(int id) {
        String sql = "UPDATE mst_follow_up_status SET is_deleted=true,deleted_date=CURRENT_TIMESTAMP WHERE id=?";
        return template.update(sql, new Object[]{id}) > 0;
    }

    @Override
    public FollowUpStatus getById(int id) {
        String sql = "SELECT * FROM vw_follow_up_status WHERE id=?";
        FollowUpStatus followUpStatus = null;
        try {
            followUpStatus = template.queryForObject(sql, new Object[]{id}, new RowMapper<FollowUpStatus>() {
                @Override
                public FollowUpStatus mapRow(ResultSet rs, int i) throws SQLException {
                    FollowUpStatus followUpStatus = new FollowUpStatus();
                    followUpStatus.setId(rs.getInt("id"));
                    followUpStatus.setName(rs.getString("status_name"));
                    followUpStatus.setColor(rs.getString("status_color"));
                    return followUpStatus;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return followUpStatus;
    }

    @Override
    public List<FollowUpStatus> getAll() {
        String sql = "SELECT * FROM vw_follow_up_status";
        return template.query(sql, new RowMapper<FollowUpStatus>() {
            @Override
            public FollowUpStatus mapRow(ResultSet rs, int i) throws SQLException {
                FollowUpStatus followUpStatus = new FollowUpStatus();
                followUpStatus.setId(rs.getInt("id"));
                followUpStatus.setName(rs.getString("status_name"));
                followUpStatus.setColor(rs.getString("status_color"));
                return followUpStatus;
            }
        });
    }

}
