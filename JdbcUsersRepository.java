package com.ust.UserBackEndProject.dao;

import com.ust.UserBackEndProject.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("UsersRepository")
public class JdbcUsersRepository implements UsersDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertUsers(int id, Users users) {
        String sql = "INSERT INTO USERS (Id,Uname,Pword) VALUES (?, ?)";
        return jdbcTemplate.update(sql,
                new Object[]{users.getId(), users.getUname(), users.getPword()});
    }

    @Override
    public int updateUsers(int id, Users users) {
        String sql = "UPDATE USERS SET UNAME=?, PWORD=?";
        return jdbcTemplate.update(sql,
                new Object[]{users.getId(), users.getUname(), users.getPword()});
    }

    @Override
    public int deleteUsers(int id) {
        String sql = "DELETE FROM USERS WHERE ID=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Users> queryUsers() {
        String sql = "SELECT * FROM USERS";
        return jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Users.class));
    }

    @Override
    public Optional<Users> queryUsers(int id) {
        Users users = null;
        try {
            String sql = "SELECT * FROM USERS WHERE ID=?";
            users = jdbcTemplate.queryForObject(sql,
                    BeanPropertyRowMapper.newInstance(Users.class), id);
            return Optional.ofNullable(users);
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.ofNullable(users);
        }
    }
}

