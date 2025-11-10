package com.example.bookstore.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/OnlineBookStore?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "Kumarankit09@";
    static {
        try {
            // For Tomcat 11 / Jakarta, driver class is same
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
