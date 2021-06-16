<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hk.jsp.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jspweb13</title>
<link rel="stylesheet" href="css/style.css"></link>
<style></style>
</head>
<body>
	<%
		String name = request.getParameter("name");
		int x = 10;
		int y = 20;
		out.println("<h3>합계는:"+(x+y)+"</h3>");
		out.println("<br>");
		out.println(name);
	%>
</body>
<script></script>
</html>