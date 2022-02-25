package com.oopsw.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.oopsw.javabean.ArrangeSeatListVO;
import com.oopsw.javabean.SeatHistory;
import com.oopsw.javabean.SeatHistoryDAO;


public class InsertArrangeSeatAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException, SQLException,
			ClassNotFoundException, SeatHistoryNotFoundException, RoomListNotFoundException {
		
		SeatHistoryDAO seatHistoryDAO = new SeatHistoryDAO();
		String url = "error.jsp";
		
		int educationNumber = Integer.valueOf(request.getParameter("educationNumber"));
	    int roomNumber = Integer.valueOf(request.getParameter("roomNumber"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
	    
		String seatHistoryInfo = request.getParameter("seatHistorysInfo");
		
		String[] memberSeatHistory =  seatHistoryInfo.split("/");
		Collection<SeatHistory> seatHistoryList = new ArrayList<SeatHistory>();
		for(String s : memberSeatHistory) {
			String[] temp = s.split("-");
			seatHistoryList.add(new SeatHistory(Integer.valueOf(temp[0]),
					Integer.valueOf(temp[1]), startDate, endDate, Integer.valueOf(temp[2]), educationNumber, roomNumber));
		}
		
		for(SeatHistory sh :seatHistoryList) {
			System.out.println(sh);
		}
		seatHistoryDAO.arrangeSeats(seatHistoryList);
		return "insertOk.jsp";
	}

}
