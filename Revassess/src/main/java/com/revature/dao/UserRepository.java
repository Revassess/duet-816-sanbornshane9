package com.revature.dao;

import com.revature.config.ConnectionUtil;
import com.revature.model.Category;
import com.revature.model.Role;
import com.revature.model.User;

import javax.mail.internet.PreencodedMimeBodyPart;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserRepository implements CrudRepository{
    ConnectionUtil cu;

    public UserRepository(ConnectionUtil cuu){
        cu = cuu;
    }

    @Override
    public Object save(Object t) throws SQLException {
        User u = (User)t;
        Connection c = cu.connect();
        String sql = "insert into app_user(username,password,first_name,lastname,role_id) values" +
                "(?,?,?,?,?)";
        PreparedStatement s = c.prepareStatement(sql);
        s.setString(1,u.getUsername());
        s.setString(2,u.getPassword());
        s.setString(3,u.getFirstName());
        s.setString(4,u.getLastName());
        s.setInt(5, u.getRole().getID());
        s.executeUpdate();
        return u;
    }

    @Override
    public Set<Object> findAll() throws SQLException {
        Connection c = cu.connect();
        Set<Object> allUsers = new HashSet<>();
        User u = new User();
        String sql = "select * from app_user";
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while(rs.next()){
            u.setFirstName(rs.getString("first_name"));
            u.setLastName(rs.getString("last_name"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setId(rs.getInt("user_id"));
            String r = String.valueOf(Role.class .getEnumConstants() [(rs.getInt("category_id"))]);
            if(r.equals("BASIC_USER")){
                u.setRole(Role.BASIC_USER);
            }
            else{
                u.setRole(Role.PREMIUM_USER);
            }
            allUsers.add(u);
        }
        return allUsers;
    }

    @Override
    public Object findById(int id) throws SQLException {
        Connection c = cu.connect();
        User u = new User();
        String sql = "select * from app_user where user_id = ?";
        PreparedStatement s = c.prepareStatement(sql);
        s.setInt(1,id);
        ResultSet rs = s.executeQuery();
        while(rs.next()){
            u.setFirstName(rs.getString("first_name"));
            u.setLastName(rs.getString("last_name"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setId(rs.getInt("user_id"));
            String r = String.valueOf(Role.class .getEnumConstants() [(rs.getInt("category_id"))]);
            if(r.equals("BASIC_USER")){
                u.setRole(Role.BASIC_USER);
            }
            else{
                u.setRole(Role.PREMIUM_USER);
            }
        }
        return u;
    }

    @Override
    public boolean update(Object t) throws SQLException {
        User u = (User) t;
        Connection c = cu.connect();
        String sql = "update app_user set username = ?, password = ?, first_name = ?," +
                "last_name = ?, role_id = ? where user_id = ?";
        PreparedStatement s = c.prepareStatement(sql);
        s.setString(1,u.getUsername());
        s.setString(2,u.getPassword());
        s.setString(3,u.getFirstName());
        s.setString(4,u.getLastName());
        s.setInt(5,u.getRole().getID());
        s.setInt(6,u.getId());
        int i = s.executeUpdate();
        if(i != 1){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        Connection c = cu.connect();
        String sql = "delete from app_user where user_id = ?";
        PreparedStatement s = c.prepareStatement(sql);
        s.setInt(1,id);
        int i = s.executeUpdate();
        if(i != 1){
            return false;
        }
        else{
            return true;
        }
    }

    public User findUserByUsername(String username) throws SQLException {
        Connection c = cu.connect();
        User u = new User();
        String sql = "select * from app_user where username = ?";
        PreparedStatement s = c.prepareStatement(sql);
        s.setString(1, username);
        ResultSet rs = s.executeQuery();
        while(rs.next()){
            u.setId(rs.getInt("user_id"));
            u.setPassword(rs.getString("password"));
            u.setUsername(rs.getString("username"));
            u.setLastName(rs.getString("last_name"));
            u.setFirstName(rs.getString("first_name"));
            String r = String.valueOf(Role.class .getEnumConstants() [(rs.getInt("category_id"))]);
            if(r.equals("BASIC_USER")){
                u.setRole(Role.BASIC_USER);
            }
            else{
                u.setRole(Role.PREMIUM_USER);
            }
        }
        return u;
    }

    public User findUserByCredentials(String username, String pw) throws SQLException {
        Connection c = cu.connect();
        User u = new User();
        String sql = "select * from app_user where username = ? and password = ?";
        PreparedStatement s = c.prepareStatement(sql);
        s.setString(1, username);
        s.setString(2, pw);
        ResultSet rs = s.executeQuery();
        while(rs.next()){
            u.setId(rs.getInt("user_id"));
            u.setPassword(rs.getString("password"));
            u.setUsername(rs.getString("username"));
            u.setLastName(rs.getString("last_name"));
            u.setFirstName(rs.getString("first_name"));
            String r = String.valueOf(Role.class .getEnumConstants() [(rs.getInt("category_id"))]);
            if(r.equals("BASIC_USER")){
                u.setRole(Role.BASIC_USER);
            }
            else{
                u.setRole(Role.PREMIUM_USER);
            }
        }
        return u;
    }

}