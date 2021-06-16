<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jspweb19</title>
<link rel="stylesheet" href="css/style.css"></link>
<style></style>
</head>
<body>
	<h3>데이터베이스 풀 테스트</h3>
	
	<%
		//디비 접속 객체정보
		Connection dbconn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// JDBC 대신 DBCP 로 변환 : javax.naming.* 있는 클래스
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jspweb");
		
		try{
			dbconn = ds.getConnection(); // dbpool을 통해 접속
			stmt = dbconn.createStatement();
			String sql = "select name from member";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				out.println("회원정보: "+ rs.getString("name")+"<br>");
			}
		}catch(Exception e) {
			out.println("디비 에러 출력=" + e.getMessage());
		}
	%>
</body>
<script></script>
</html>