package com.oopsw.javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class SeatHistoryDAO {
	private Connection conn;

	public SeatHistoryDAO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "hr";
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("1, 2, conn ok");
	}

	/**
	 * 자리배치이력조회
	 * 
	 * @throws SQLException
	 */
	public Collection<SeatHistory> searchSeatHistory(String date, int educationNumber) throws SQLException {
		ArrayList<SeatHistory> result = new ArrayList<SeatHistory>();

		String sql = "SELECT s.row_number as rowNumber, s.col_number as colNumber, s.member_id as memberId, m.name as name"
				+ " FROM seat_historys s, rooms r, educations e, members m"
				+ " WHERE ? BETWEEN s.arranging_start_date AND s.arranging_end_date AND s.education_number = e.education_number"
				+ " AND e.room_number = r.room_number AND e.education_number = ? AND m.member_id = s.member_id";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, date);
		pstmt.setInt(2, educationNumber);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
			result.add(new SeatHistory(rs.getInt("rowNumber"), rs.getInt("colNumber"), rs.getInt("memberId"), rs.getString("name")));

		rs.close();
		pstmt.close();

		return result;
	}

	public SeatHistory searchSeatHistoryByMemberId(String date, int memberId) throws SQLException {
		SeatHistory result = null;

		String sql = "SELECT education_number as educationNumber, room_number as roomNumber "
				+ " FROM seat_historys"
				+ " WHERE ? BETWEEN arranging_start_date AND arranging_end_date"
				+ " AND member_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, date);
		pstmt.setInt(2, memberId);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) result = new SeatHistory(rs.getInt("educationNumber"), rs.getInt("roomNumber"));
		rs.close();
		pstmt.close();

		return result;
	}
	
	/** 자리배치 
	 * @throws SQLException */
	public boolean arrangeSeats(Collection<SeatHistory> sh_list) throws SQLException {
//		if(sh_list.isEmpty())
//			throw new EmptyValuesExceoption("입력할 자리배치 이력이 없습니다.");
		
		String sql = "INSERT INTO seat_historys(arranging_number, row_number, col_number,"
				+ " arranging_start_date, arranging_end_date, member_id, education_number, room_number)"
				+ " VALUES (seq_arranging_number.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);

		for (SeatHistory sh : sh_list) {
			pstmt.setInt(1, sh.getRowNumber());
			pstmt.setInt(2, sh.getColNumber());
			pstmt.setString(3, sh.getArrangingStartDate());
			pstmt.setString(4, sh.getArrangingEndDate());
			pstmt.setInt(5, sh.getMemberId());
			pstmt.setInt(6, sh.getEducationNumber());
			pstmt.setInt(7, sh.getRoomNumber());
			pstmt.addBatch();
			pstmt.clearParameters(); // 파라미터 초기화
		}

		pstmt.executeBatch();
		pstmt.clearParameters(); // Batch 초기화

		pstmt.close();

		return true;
	}
	
	public boolean SeatHistoryCheck(String startDate, String endDate, int educationNumber) throws SQLException {
		boolean result = true;
		String sql = "select * from seat_historys where education_number=? and "
				+ "((arranging_start_date<=? and arranging_end_date >=?) "
				+ "or (arranging_start_date<=? and arranging_end_date <=?) "
				+ "or (arranging_start_date>=? and arranging_end_date>=?) "
				+ "or (arranging_start_date>=? and arranging_end_date <=?))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, educationNumber);
		pstmt.setString(2, startDate);
		pstmt.setString(4, startDate);
		pstmt.setString(6, startDate);
		pstmt.setString(8, startDate);
		
		pstmt.setString(3, endDate);
		pstmt.setString(5, endDate);
		pstmt.setString(7, endDate);
		pstmt.setString(9, endDate);

		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) result = false;
		rs.close();
		pstmt.close();

		return result;
	}
	
}
