package com.example.bookstore.servlet;
import com.example.bookstore.dao.BookDAO;
import com.example.bookstore.model.Book;
import jakarta.servlet.*; import jakarta.servlet.http.*; import java.io.*; import java.util.*;
public class ViewBooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BookDAO dao = new BookDAO();
            List<Book> books = dao.getAll();
            req.setAttribute("books", books);
            req.getRequestDispatcher("/books.jsp").forward(req, resp);
        } catch (Exception e) { throw new ServletException(e); }
    }
}
