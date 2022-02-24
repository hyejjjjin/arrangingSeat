package com.oopsw.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, ClassNotFoundException, SQLException {

		// 서버의 메모리에 세션을 해제..
		HttpSession session = request.getSession();
		if (session != null) {
			// 세션 중요 정보만 해제
			session.removeAttribute("memberId"); // 항목 삭제
			// 세션 모두 해제
			session.invalidate();
		}
		return "/";
	}

}
