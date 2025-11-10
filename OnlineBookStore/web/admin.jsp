<%@ page import="java.util.*" %>
<jsp:include page="header.jsp" />
<div class="container">
  <h2>Admin Panel</h2>
  <h3>Add Book</h3>
  <form method="post" action="admin/add-book">
    <input name="title" placeholder="Title"/><br/>
    <input name="author" placeholder="Author"/><br/>
    <input name="price" placeholder="Price"/><br/>
    <input name="image" placeholder="Image path (web/images/...)"/><br/>
    <button type="submit">Add Book</button>
  </form>
  <h3>Existing Books</h3>
  <% List books = (List) request.getAttribute("books"); if (books!=null) { %>
    <ul>
    <% for (Object o: books) { %>
      <li><%= o.toString() %></li>
    <% } %>
    </ul>
  <% } %>
</div>
<jsp:include page="footer.jsp" />
