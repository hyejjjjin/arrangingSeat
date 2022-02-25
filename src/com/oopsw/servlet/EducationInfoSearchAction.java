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
		
		//�ش� ��¥�� �ش��ϴ� ������ �������� ������� ���� �߻�
		Education education = educationDAO.searchEducation(startDate, endDate, memberId);
		if(education==null) throw new ArrangeSeatDateException("�ش糯¥�� �ش��ϴ� ������ �������� �ʽ��ϴ�.");
		
		//�ش� ��¥�� �����ϴ� �ڸ���ġ�� �����ҽÿ� ���� �߻�.
		if(!seatHistoryDAO.SeatHistoryCheck(startDate, endDate, education.getEducationNumber())) throw new ArrangeSeatDateException("�ڸ���ġ�� �̹� �����մϴ�.");
		
		Room room = roomDAO.searchRoom(education.getRoomNumber());
		request.setAttribute("roomVO", room);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("educationNumber", education.getEducationNumber());
		return "arrangeSeat.jsp";
	}

}
