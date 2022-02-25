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
		
		Room r = new RoomDAO().searchRoom(1);
		request.setAttribute("roomVO", r);
		System.out.println(r);

		return "controller?cmd=searchedRoomInfo";
	}

}
