package com.oopsw.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 모든 요청 서블릿 1개가 대표

		// 페이지 분할
		String cmd = request.getParameter("cmd");
		String url = "error.jsp";

		// 요청 처리
		Action a = null;
		switch (cmd) {
		case "loginUI":
			a = new LoginUI();
			break;
		case "loginAction":
			a = new LoginAction();
			break;
		case "logoutAction":
			a = new LogoutAction();
			break;
		case "myPageUI":
			a = new MyPageUI();
			break;
		case "arrangeSeatUI":
			url = "arrangeSeat.jsp";
			break;
		case "arrangeSeatHistoryUI":
			a = new ArrangeSeatHistoryUI();
			break;
		case "roomInfoSearch":
			a = new RoomInfoSearchAction();
			break;
		case "arrangeSeatHistory":
			a = new ArrangeSeatHistoryAction();
			break;
		case "arrangeSeatNoHistoryUI":
			url = "arrangeSeatNoHistory.jsp";
			break;
		case "roomInfoUI":
			a = new RoomInfoUI();
			break;
		case "searchRoomAction":
			a = new SearchRoomAction();
			break;
		case "roomInfoAction":
			a = new RoomInfoAction();
			break;

		}
		try {
			url = a.execute(request);
		} catch (SeatHistoryNotFoundException e) {
			request.setAttribute("dateError", true);
			url = "arrangeSeatHistory.jsp";
		} catch (RoomListNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/" + url).forward(request, response);
	}

}
