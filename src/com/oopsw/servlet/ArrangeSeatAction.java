package com.oopsw.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.oopsw.javabean.ArrangeSeatListVO;
import com.oopsw.javabean.Member;
import com.oopsw.javabean.MemberDAO;
import com.oopsw.javabean.Room;
import com.oopsw.javabean.RoomDAO;
import com.oopsw.javabean.SeatHistory;

public class ArrangeSeatAction implements Action {

	@Override
	public String execute(HttpServletRequest request)
			throws ServletException, IOException, SQLException, ClassNotFoundException, SeatHistoryNotFoundException {
		MemberDAO memberDAO = new MemberDAO();
		RoomDAO roomDAO = new RoomDAO();
		
		
		String emptySeats[] = request.getParameterValues("checkbox");
		if(emptySeats==null) emptySeats = new String[0];
		//1. ��ü �ڸ� �� - ����üũ�� �ڸ� >= ��ü�л���(educationNumber)
		//���� ����üũ�� �ڸ��� ������ ����ó��
		
		
		int rowCount =  Integer.valueOf(request.getParameter("rowCount"));
		int colCount =  Integer.valueOf(request.getParameter("colCount"));
        int seatCount = rowCount*colCount; 
		
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int educationNumber= Integer.valueOf(request.getParameter("educationNumber"));
		int roomNumber= Integer.valueOf(request.getParameter("roomNumber"));
		Room room = roomDAO.searchRoom(roomNumber);
		
		//2. �ڸ���ġ�ϱ�(educationNumber�� ���ؼ� �������Ʈ ��������
		List<Member> memberList = (List<Member>)memberDAO.searchClassMate(educationNumber);
        
		
		//3. �ڸ���ġ ���̺� �����ϱ�.
		Collection<SeatHistory> shList = shuffleSeat(memberList, rowCount, colCount, startDate, endDate, educationNumber, roomNumber, emptySeats);
		
		
		ArrangeSeatListVO listVO = new ArrangeSeatListVO(shList);
		
		request.setAttribute("list", listVO);
		request.setAttribute("roomVO", room);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		request.setAttribute("educationNumber", educationNumber);
		request.setAttribute("emptyList", emptySeats);
		
		
		return  "arrangeSeat.jsp";
	}
	
public Collection<SeatHistory> shuffleSeat(List<Member> memberList, int rowNum,
		int colNum, String startDate, String endDate, int educationNumber, int roomNumber,
		String[] emptySeat) {
	
		ArrayList<Integer> randomList = new ArrayList<Integer>();
		for(int i = 0; i<rowNum*colNum; i++) {
			//������ �ڸ��� ���� �ʴ´�.
			boolean check = true;
			for(String s : emptySeat) {
				if(Integer.valueOf(s)-1==i)  {
					check =false;
					break;
				}
			}
			
			if(check) randomList.add(i);
		}
		Collections.shuffle(randomList);
		System.out.println(randomList);
		Collection<SeatHistory> seatHistoryList = new ArrayList<>();
		for(int i =0; i < memberList.size(); i ++) {
			int tempSeatNumber = randomList.get(i);
			Member tempMember = memberList.get(i);
			seatHistoryList.add(new SeatHistory(0,tempSeatNumber/colNum, tempSeatNumber%colNum,
					startDate, endDate, tempMember.getMemberId(), tempMember.getName(),
					educationNumber, roomNumber));
		}
		return seatHistoryList;
	}
	

}
