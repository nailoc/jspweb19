package com.hk.jsp.dao;

// 기존에는 접속관련 변수나 메소드를 같이 저장했는데
// 반복되는 코드임으로 상속을 해서 사용해보자
public class MemberDao extends DBManager {

	private static MemberDao instance = null;
	public static MemberDao getInstance() {
		if(instance==null) {	instance = new MemberDao();		}
		return instance;
	}
	
	// member 테이블에 접속하는 테스트함수
	public int memberTable() throws Exception {
		int rst = 0;
		getDBCP();
		String sql = "select count(*) as cnt from member";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			rst=rs.getInt("cnt");
		}
		returnDBCP();
		return rst;
		
	}
}
