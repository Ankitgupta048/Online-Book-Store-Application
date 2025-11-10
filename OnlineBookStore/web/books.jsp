<%@ page import="java.util.*, com.example.bookstore.model.Book" %>
<jsp:include page="header.jsp" />
<div class="container">
  <h2>Books</h2>
  <div class="grid">
    <% List<Book> books = (List<Book>) request.getAttribute("books");
       if (books != null) {
          for (Book b : books) { %>
            <div class="card">
              <img src="<%= b.getImage()!=null? b.getImage():"images/default.jpg" %>" alt="cover"/>
              <h3><%= b.getTitle() %></h3>
              <p>By <%= b.getAuthor() %></p>
              <p>₹<%= b.getPrice() %></p>
              <form method="post" action="add-to-cart">
                <input type="hidden" name="bookId" value="<%= b.getId() %>"/>
                <input type="number" name="qty" value="1" min="1"/>
                <button type="submit">Add to Cart</button>
              </form>
            </div>
    <%    }
       } else { %>
         <p>No books available.</p>
    <% } %>
  </div>
</div>
<jsp:include page="footer.jsp" />
