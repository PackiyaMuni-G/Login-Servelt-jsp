<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
        <%
   String username = request.getParameter("username");
   out.println("Hello, " + username);
%>
        
  <h1>You have logged in successfully</h1>
 </div>
</body>
</html>