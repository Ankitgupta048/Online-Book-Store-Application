package com.example.bookstore.dao;
import com.example.bookstore.model.User;
import com.example.bookstore.util.DBUtil;
import java.sql.*;
public class UserDAO {
    public User findByEmailAndPassword(String email, String password) throws Exception {
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,email); ps.setString(2,password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User u = new User();
                    u.setId(rs.getInt("id"));
                    u.setName(rs.getString("name"));
                    u.setEmail(rs.getString("email"));
                    u.setPassword(rs.getString("password"));
                    u.setAdmin(rs.getInt("is_admin") == 1);
                    return u;
                }
            }
        }
        return null;
    }
    public void save(User u) throws Exception {
        String sql = "INSERT INTO users(name,email,password,is_admin) VALUES(?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,u.getName()); ps.setString(2,u.getEmail()); ps.setString(3,u.getPassword()); ps.setInt(4,u.isAdmin()?1:0);
            ps.executeUpdate();
        }
    }
}
