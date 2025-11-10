package com.example.bookstore.servlet;
import com.example.bookstore.dao.UserDAO; import com.example.bookstore.model.User;
import jakarta.servlet.*; import jakarta.servlet.http.*; import java.io.*;
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email"); String password = req.getParameter("password");
        try {
            UserDAO dao = new UserDAO();
            User u = dao.findByEmailAndPassword(email,password);
            if (u != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", u);
                resp.sendRedirect(req.getContextPath()+"/books");
            } else {
                resp.sendRedirect(req.getContextPath()+"/login.jsp?error=1");
            }
        } catch (Exception e) { throw new ServletException(e); }
    }
}
