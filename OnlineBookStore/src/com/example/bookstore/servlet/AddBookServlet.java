package com.example.bookstore.servlet;
import com.example.bookstore.dao.BookDAO; import com.example.bookstore.model.Book;
import jakarta.servlet.*; import jakarta.servlet.http.*; import java.io.*;
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletRes resp) throws ServletException, IOException {
        String title = req.getParameter("title"); String author = req.getParameter("author"); String priceS = req.getParameter("price"); String image = req.getParameter("image");
        try {
            Book b = new Book(); b.setTitle(title); b.setAuthor(author); b.setPrice(Double.parseDouble(priceS)); b.setImage(image);
            BookDAO dao = new BookDAO(); dao.add(b);
            resp.sendRedirect(req.getContextPath()+"/admin.jsp");
        } catch (Exception e) { throw new ServletException(e); }
    }
}
