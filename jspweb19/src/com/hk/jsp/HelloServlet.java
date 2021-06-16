package com.hk.jsp;

import java.io.IOException;
import java.io.PrintWriter; // 스트림- inputStream, FileWrite

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet; // servlet-api.jar에 가져옴 (웹어플리케이션 서버 제공)
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.jsp.dao.MemberDao;

// jsp의 원래 구조인 servlet 작성
public class HelloServlet extends HttpServlet {
	
	//Http 통신 메소드 
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		// 클라이언트 요청을 응답하는 코드
		response.setContentType("text/html; charset=UTF-8");
		
		// 자바빈을 호출
		MemberDao memdao = MemberDao.getInstance();
		int result = 0;
		try {
			result = memdao.memberTable();
			System.out.println("결과="+result);
		}catch(Exception e) {
			
		}
		// view단으로 처리를 넘길 때 사용
		RequestDispatcher rd;
		String view = "/views/hellosv.jsp";
		rd = getServletContext().getRequestDispatcher(view);
		request.setAttribute("data", result);
		rd.forward(request, response);
		
	}

}
