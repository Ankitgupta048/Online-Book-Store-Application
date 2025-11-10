package com.example.bookstore.servlet;
import com.example.bookstore.model.CartItem;
import jakarta.servlet.*; import jakarta.servlet.http.*; import java.io.*; import java.util.*;
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action"); HttpSession session = req.getSession(); List<CartItem> cart = (List<CartItem>) session.getAttribute("cart"); if (cart==null) cart = new ArrayList<>();
        if ("update".equals(action)) {
            String[] ids = req.getParameterValues("bookId"); String[] qtys = req.getParameterValues("qty"); if (ids!=null) for (int i=0;i<ids.length;i++){ int id=Integer.parseInt(ids[i]); int q=Integer.parseInt(qtys[i]); for (CartItem it: cart) if (it.getBook().getId()==id) it.setQty(q); }
        } else if ("remove".equals(action)) {
            int bid = Integer.parseInt(req.getParameter("bookId")); cart.removeIf(it->it.getBook().getId()==bid);
        }
        session.setAttribute("cart", cart); resp.sendRedirect(req.getContextPath()+"/cart.jsp");
    }
}
