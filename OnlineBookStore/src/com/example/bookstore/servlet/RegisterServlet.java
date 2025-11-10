package com.example.bookstore.servlet;
import com.example.bookstore.dao.UserDAO; import com.example.bookstore.model.User;
import jakarta.servlet.*; import jakarta.servlet.http.*; import java.io.*;
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name"); String email = req.getParameter("email"); String password = req.getParameter("password");
        try {
            User u = new User(); u.setName(name); u.setEmail(email); u.setPassword(password); u.setAdmin(false);
            UserDAO dao = new UserDAO(); dao.save(u);
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        } catch (Exception e) { throw new ServletException(e); }
    }
}
