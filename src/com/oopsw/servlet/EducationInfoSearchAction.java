package com.oopsw.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.oopsw.javabean.Education;
import com.oopsw.javabean.EducationDAO;
import com.oopsw.javabean.Room;
import com.oopsw.javabean.RoomDAO;
import com.oopsw.javabean.SeatHistoryDAO;

public class EducationInfoSearchAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, SQLException, ClassNotFoundException, SeatHistoryNotFoundException, ArrangeSeatDateException {
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		int memberId = (int)request.getSession().getAttribute("memberId");
		
		
		EducationDAO educationDAO = new EducationDAO();
		RoomDAO roomDAO = new RoomDAO();
		SeatHistoryDAO seatHistoryDAO = new SeatHistoryDAO();
		
		//해당 날짜에 해당하는 교육이 존재하지 않으경우 예외 발생
		Education education = educationDAO.searchEducation(startDate, endDate, memberId);
		if(education==null) throw new ArrangeSeatDateException("해당날짜에 해당하는 교육이 존재하지 않습니다.");
		
		//해당 날짜를 포함하는 자리배치가 존재할시에 예외 발생.
		if(!seatHistoryDAO.SeatHistoryCheck(startDate, endDate, education.getEducationNumber())) throw new ArrangeSeatDateException("자리배치가 이미 존재합니다.");
		
		Room room = roomDAO.searchRoom(education.getRoomNumber());
		request.setAttribute("roomVO", room);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("educationNumber", education.getEducationNumber());
		return "arrangeSeat.jsp";
	}

}
