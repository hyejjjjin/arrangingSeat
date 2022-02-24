package com.oopsw.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.oopsw.javabean.Room;
import com.oopsw.javabean.RoomDAO;
import com.oopsw.javabean.SeatHistory;
import com.oopsw.javabean.SeatHistoryDAO;

public class ArrangeSeatHistoryAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		SeatHistoryDAO seatHistoryDAO = new SeatHistoryDAO();
		RoomDAO roomDAO = new RoomDAO();
		
		//날짜, 교육일련번호
		String date = request.getParameter("date");
		int educationNumber = Integer.valueOf(request.getParameter("educationNumber"));
		int roomNumber = Integer.valueOf(request.getParameter("roomNumber"));
		Room room = roomDAO.searchRoom(roomNumber);
		List<SeatHistory> seatHistoryList = (List)seatHistoryDAO.searchSeatHistory(date, educationNumber);
		
		request.setAttribute("date", date);
		request.setAttribute("seatHistoryList", seatHistoryList);
		request.setAttribute("roomVO", room);
		return "arrangeSeatHistory.jsp";
	}

}
