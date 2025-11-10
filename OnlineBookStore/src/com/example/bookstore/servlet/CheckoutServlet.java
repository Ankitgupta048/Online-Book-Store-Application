package com.example.bookstore.servlet;
import com.example.bookstore.model.CartItem; import com.example.bookstore.model.User;
import jakarta.servlet.*; import jakarta.servlet.http.*; import java.io.*; import java.util.*;
public class CheckoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); User user = (User) session.getAttribute("user"); if (user==null) { resp.sendRedirect(req.getContextPath()+"/login.jsp"); return; }
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart"); if (cart==null || cart.isEmpty()) { resp.sendRedirect(req.getContextPath()+"/cart.jsp"); return; }
        // Simplified: no orders table here, just clear cart
        session.removeAttribute("cart");
        req.setAttribute("msg", "Order placed successfully!"); req.getRequestDispatcher("/books.jsp").forward(req, resp);
    }
}
