package com.oopsw.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface Action {
	//Servlet에서 일부 기능 분할 
	String execute(HttpServletRequest request) 
			throws ServletException, IOException, SQLException, ClassNotFoundException, SeatHistoryNotFoundException,
			RoomListNotFoundException;
}