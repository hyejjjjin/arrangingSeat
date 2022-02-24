package com.oopsw.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.oopsw.javabean.Room;
import com.oopsw.javabean.RoomDAO;

public class SearchRoomAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, SQLException, ClassNotFoundException, SeatHistoryNotFoundException {
		int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));

		Room r = new RoomDAO().searchRoom(roomNumber);
		request.setAttribute("roomVO", r);

		return "controller?cmd=roomInfoUI";
	}

}
