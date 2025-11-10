package com.example.bookstore.servlet;
import com.example.bookstore.dao.BookDAO; import com.example.bookstore.model.Book; import com.example.bookstore.model.CartItem;
import jakarta.servlet.*; import jakarta.servlet.http.*; import java.io.*; import java.util.*;
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId")); int qty = Integer.parseInt(req.getParameter("qty"));
        try {
            BookDAO bdao = new BookDAO(); Book b = bdao.findById(bookId);
            HttpSession session = req.getSession(); List<CartItem> cart = (List<CartItem>) session.getAttribute("cart"); if (cart==null) { cart=new ArrayList<>(); session.setAttribute("cart", cart); }
            boolean found=false; for (CartItem it: cart) { if (it.getBook().getId()==bookId) { it.setQty(it.getQty()+qty); found=true; break; } }
            if (!found) cart.add(new CartItem(b, qty));
            resp.sendRedirect(req.getContextPath()+"/cart.jsp");
        } catch (Exception e) { throw new ServletException(e); }
    }
}
