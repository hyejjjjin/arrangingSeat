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

		// ������ �޸𸮿� ������ ����..
		HttpSession session = request.getSession();
		if (session != null) {
			// ���� �߿� ������ ����
			session.removeAttribute("memberId"); // �׸� ����
			// ���� ��� ����
			session.invalidate();
		}
		return "/";
	}

}
