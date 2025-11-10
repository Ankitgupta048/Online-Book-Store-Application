<%@ page import="java.util.*, com.example.bookstore.model.CartItem" %>
<jsp:include page="header.jsp" />
<div class="container">
  <h2>Your Cart</h2>
  <form method="post" action="cart-action">
    <input type="hidden" name="action" value="update"/>
    <table>
      <tr><th>Book</th><th>Qty</th><th>Price</th><th>Total</th><th>Remove</th></tr>
      <% List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
         double sum=0;
         if (cart != null) {
           for (CartItem it: cart) { %>
             <tr>
               <td><%= it.getBook().getTitle() %></td>
               <td><input type="hidden" name="bookId" value="<%= it.getBook().getId() %>"/><input name="qty" value="<%= it.getQty() %>"/></td>
               <td>₹<%= it.getBook().getPrice() %></td>
               <td>₹<%= it.getTotal() %></td>
               <td><a href="cart-action?action=remove&bookId=<%= it.getBook().getId() %>">Remove</a></td>
             </tr>
      <%       sum += it.getTotal();
           }
         } %>
    </table>
    <p>Total: ₹<%= sum %></p>
    <button type="submit">Update Cart</button>
  </form>
  <form method="post" action="checkout">
    <button type="submit">Checkout</button>
  </form>
</div>
<jsp:include page="footer.jsp" />
