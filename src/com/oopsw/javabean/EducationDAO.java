package com.oopsw.javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationDAO {
	private Connection conn;

	public EducationDAO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "hr";
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("1, 2, conn ok");
	}

	public String getEducationName(int educationNumber) throws SQLException {
		String result = null;
		String sql = "select name FROM educations WHERE education_number = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, educationNumber);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			result = rs.getString("name");

		rs.close();
		pstmt.close();

		return result;
	}
	
	public Education searchEducation(String startDate, String endDate, int memberId) throws SQLException {
		Education result = null;
		String sql = "select e.room_number as roomNumber, e.education_number as educationNumber"
				+ " FROM educations e, education_historys eh"
				+ " WHERE ? >= e.start_date AND e.end_date >= ? and eh.education_number = e.education_number"
				+ " AND eh.member_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, startDate);
		pstmt.setString(2, endDate);
		pstmt.setInt(3, memberId);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			result = new Education(rs.getInt("educationNumber"), rs.getInt("roomNumber"));
		rs.close();
		pstmt.close();

		return result;
	}
	
}
