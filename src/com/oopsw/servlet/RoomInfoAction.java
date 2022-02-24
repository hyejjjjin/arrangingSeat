package com.oopsw.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.oopsw.javabean.Room;
import com.oopsw.javabean.RoomDAO;

public class RoomInfoAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, SQLException, ClassNotFoundException, RoomListNotFoundException {
		Collection<Room> roomList = new RoomDAO().searchRoomList();
		request.setAttribute("roomList", roomList);

		if (roomList == null)
			throw new RoomListNotFoundException("강의실 목록이 존재하지 않습니다.");

		return "controller?cmd=roomInfoUI";
	}

}
