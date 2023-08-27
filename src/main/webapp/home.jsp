<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String myname= (String) session.getAttribute("name_key"); %>
  <h3> Welcome: <%=myname %></h3>
      <a href="Page1.jsp">Page 1 </a> </br>
      <a href="Page2.jsp">Page 2 </a> </br>
      <a href="logout">LOGOUT </a>

</body>
</html>