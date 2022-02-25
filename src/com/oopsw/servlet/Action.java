package com.oopsw.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface Action {
	//Servlet���� �Ϻ� ��� ���� 
	String execute(HttpServletRequest request) 
			throws ServletException, IOException, SQLException, ClassNotFoundException, SeatHistoryNotFoundException,
			RoomListNotFoundException, ArrangeSeatDateException;
}