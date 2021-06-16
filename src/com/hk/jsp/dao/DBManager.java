package com.hk.jsp.dao;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	
	//sql관련기본정보
	static Connection conn = null;
	static Statement stmt = null; // 복잡한 경우 PreparedStatement 전환 가능성
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	// DB Connection Pool 가져오기 ( 이전 connectDB() 함수를 대체하는 함수 )
	static void getDBCP() {		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/jspweb");
			conn = ds.getConnection();
			stmt = conn.createStatement();
		}catch(Exception e) {
			System.out.println("데이터베이스 풀 접속 오류:"+e.getMessage());
		}
	}
	
	// 리소스 해제는 메소드
	static void returnDBCP() {
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println("데이터베이스 풀 반환 오류:"+e.getMessage());
		}
	}

}
