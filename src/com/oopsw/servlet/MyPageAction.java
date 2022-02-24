package com.oopsw.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oopsw.javabean.Member;
import com.oopsw.javabean.MemberDAO;

public class MyPageAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException, SQLException,
			ClassNotFoundException, SeatHistoryNotFoundException, RoomListNotFoundException {
		HttpSession session = request.getSession(); // 犬角洒 技记 积己
		int memberId = (int) session.getAttribute("memberId");
		Member m = new MemberDAO().viewMyInfo(memberId);
		request.setAttribute("memberVO", m);
		
		return "controller?cmd=myPageUI";
	}

}
