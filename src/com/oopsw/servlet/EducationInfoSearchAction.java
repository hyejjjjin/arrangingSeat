package com.oopsw.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.oopsw.javabean.Education;
import com.oopsw.javabean.EducationDAO;
import com.oopsw.javabean.Room;
import com.oopsw.javabean.RoomDAO;

public class EducationInfoSearchAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, SQLException, ClassNotFoundException, SeatHistoryNotFoundException {
		EducationDAO educationDAO = new EducationDAO();
		RoomDAO roomDAO = new RoomDAO();
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		int memberId = (int)request.getSession().getAttribute("memberId");
		Education education = educationDAO.searchEducation(startDate, endDate, memberId);
		Room room = roomDAO.searchRoom(education.getRoomNumber());
		request.setAttribute("roomVO", room);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("educationNumber", education.getEducationNumber());
		return "arrangeSeat.jsp";
	}

}
