package com.foody.dao;

import com.foody.model.Inventory;
import com.foody.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //UserDao
//public void saveUser(User user);
    public void saveUser(User user) {
        jdbcTemplate.update("INSERT INTO users (id, name, email, password, userType) VALUES " +
                "(?,?,?,?,?)",
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getUserType());
    }
    public void update(User user) {
        jdbcTemplate.update("UPDATE users SET"
                        + "name = ? , email = ?, password = ?, usertype = ? WHERE id = ? ",
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getUserType(),
                user.getId()
        );
    }
    //public void updateUser(User user);
    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE users SET" +
                " name = ?,address = ?,phone = ?, email = ?, userType = ? WHERE id = ?",
                user.getName(),
                user.getAddress(),
                user.getPhone(),
                user.getEmail(),
                user.getUserType()
        );
    }
    //public void deleteUserById(int id);
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }


    RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setName(rs.getString("name"));
        u.setEmail(rs.getString("email"));
        u.setPassword(rs.getString("password"));
        u.setUserType(rs.getString("type"));
        return u;
    };

    //public User findUserById(int id);
    public User findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM users WHERE id = ?",
                userRowMapper,
                id
        );
    }

    //public User findUserByEmail(String email);
    public User findByEmail(String email) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM users WHERE email = ?",
                userRowMapper,
                email
        );
    }

    //public List<User> findUsersByType(String type);
    public List<User> findByType(String type) {
        return jdbcTemplate.query(
                "SELECT * FROM users WHERE type = ?",
                userRowMapper,
                type
        );
    }

    //public List<User> findAllUsers();
    public List<User> findAll(int limit, int pageNo) {
        return jdbcTemplate.query("SELECT * FROM users", userRowMapper);
    }
}