package com.oopsw.javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.crypto.spec.PSource;

public class RoomDAO {
	private Connection conn;

	public RoomDAO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "hr";
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("1, 2, conn ok");
	}

	public Collection<Room> searchRoomList() throws SQLException {
		ArrayList<Room> result = new ArrayList<Room>();
		String sql = "select room_number as roomNumber, location as location from rooms";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
			result.add(new Room(rs.getInt("roomNumber"), rs.getString("location")));

		rs.close();
		pstmt.close();

		return result;
	}

	public Room searchRoom(int roomNumber) throws SQLException {
		Room result = null;
		String sql = "SELECT room_number as roomNumber, location, capacity, row_count as rowCount, col_count as colCount,"
				+ " structure_picture as structurePicture, labtop, cabinet, monitor, keyboard, chair, desk"
				+ " FROM rooms WHERE room_number=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, roomNumber);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			result = new Room(rs.getInt("roomNumber"), rs.getString("location"), rs.getInt("capacity"),
					rs.getInt("rowCount"), rs.getInt("colCount"), rs.getString("structurePicture"), rs.getInt("labtop"),
					rs.getInt("cabinet"), rs.getInt("monitor"), rs.getInt("keyboard"), rs.getInt("chair"),
					rs.getInt("desk"));

		rs.close();
		pstmt.close();

		return result;
	}

	public Room searchRoom(String date, int memberId) throws SQLException {
		Room result = null;
		String sql = "select r.room_number as roomNumber, r.location as location,"
				+ " r.structure_picture as structurePicture"
				+ " FROM rooms r, educations e, education_historys eh"
				+ " WHERE ? BETWEEN e.start_date AND e.end_date AND eh.education_number = e.education_number"
				+ " AND e.room_number = r.room_number AND eh.member_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, date);
		pstmt.setInt(2, memberId);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			result = new Room(rs.getInt("roomNumber"), rs.getString("location"), rs.getString("structurePicture"));

		rs.close();
		pstmt.close();

		return result;
	}

	public String getRoomName(int roomNumber) throws SQLException {
		String result = null;
		String sql = "select location FROM rooms WHERE room_number = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, roomNumber);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			result = rs.getString("location");

		rs.close();
		pstmt.close();

		return result;
	}
}
