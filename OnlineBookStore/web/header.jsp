<%@ page session="true" %>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title>OnlineBookStore</title>
  <link rel="stylesheet" href="assets/css/style.css"/>
</head>
<body>
  <header>
    <a href="books">Home</a> | <a href="cart.jsp">Cart</a> | <a href="admin.jsp">Admin</a>
    <% Object u = session.getAttribute("user"); if (u==null) { %>
      | <a href="login.jsp">Login</a> | <a href="register.jsp">Register</a>
    <% } else { %>
      | Welcome, <%= ((com.example.bookstore.model.User)u).getName() %>
    <% } %>
  </header>
