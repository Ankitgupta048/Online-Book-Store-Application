package com.example.bookstore.dao;
import com.example.bookstore.model.Book;
import com.example.bookstore.util.DBUtil;
import java.sql.*; import java.util.*;
public class BookDAO {
    public List<Book> getAll() throws Exception {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getDouble("price"));
                b.setImage(rs.getString("image"));
                list.add(b);
            }
        }
        return list;
    }
    public void add(Book b) throws Exception {
        String sql = "INSERT INTO books(title,author,price,image) VALUES(?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1,b.getTitle());
            ps.setString(2,b.getAuthor());
            ps.setDouble(3,b.getPrice());
            ps.setString(4,b.getImage());
            ps.executeUpdate();
        }
    }
    public Book findById(int id) throws Exception {
        String sql = "SELECT * FROM books WHERE id=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1,id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Book b = new Book();
                    b.setId(rs.getInt("id"));
                    b.setTitle(rs.getString("title"));
                    b.setAuthor(rs.getString("author"));
                    b.setPrice(rs.getDouble("price"));
                    b.setImage(rs.getString("image"));
                    return b;
                }
            }
        }
        return null;
    }
}
