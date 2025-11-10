<jsp:include page="header.jsp" />
<div class="container">
  <h2>Login</h2>
  <form method="post" action="login">
    <input name="email" placeholder="Email"/><br/>
    <input name="password" type="password" placeholder="Password"/><br/>
    <button type="submit">Login</button>
  </form>
  <% if (request.getParameter("error") != null) { %>
    <p style="color:red">Invalid credentials</p>
  <% } %>
</div>
<jsp:include page="footer.jsp" />
