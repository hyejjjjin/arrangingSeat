package com.oopsw.javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class MemberDAO {
	private Connection conn;

	public MemberDAO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");

		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "hr";
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("1, 2, conn ok");
	}

	public int login(String loginId, String password) throws SQLException {
		int result = 0;
		String sql = "select member_id as memberId from members where login_Id=? and password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginId);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			result = rs.getInt("memberId");

		rs.close();
		pstmt.close();

		if(result == 0) {
			throw new SQLException("로그인 에러");
		}
		return result;
	}

	public String searchLoginIdBymemberId(int memberId) throws SQLException {
		String result = null;
		String sql = "select login_id as loginId from members where member_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, memberId);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			result = rs.getString("loginId");

		rs.close();
		pstmt.close();

		return result;
	}

	public String searchLoginIdByEmail(String email) throws SQLException {
		String result = null;
		String sql = "select login_id as loginId from members where email=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			result = rs.getString("loginId");

		rs.close();
		pstmt.close();

		return result;
	}

	public String searchLoginIdByPhone(String phone) throws SQLException {
		String result = null;
		String sql = "select login_id as loginId from members where phone_number=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, phone);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			result = rs.getString("loginId");

		rs.close();
		pstmt.close();

		return result;
	}

	public String searchPassword(String loginId, int memberId) throws SQLException {
		String result = null;
		String sql = "select password from members where login_id =? and member_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, loginId);
		pstmt.setInt(2, memberId);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			result = rs.getString("password");

		rs.close();
		pstmt.close();

		return result;
	}

	public Member viewMyInfo(int memberId) throws SQLException {
		Member result = null;
		String sql = "SELECT m.name as name, m.birthday as birthday, m.phone_number as phoneNumber, m.email as email, m.picture as picture,"
				+ " eh.is_leader as isLeader, e.name as educationName, r.location as roomLocation"
				+ " FROM members m, education_historys eh, educations e, rooms r"
				+ " WHERE m.member_id = ? AND m.member_id = eh.member_id  AND eh.education_number = e.education_number"
				+ " AND e.room_number=r.room_number"
				+ " AND (select SYSDATE from DUAL) BETWEEN e.start_date AND e.end_date";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, memberId);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			result = new Member(rs.getString("name"), rs.getString("birthday").substring(0, 10), rs.getString("phoneNumber"),
					rs.getString("email"), rs.getString("picture"), rs.getBoolean("isLeader"),
					rs.getString("educationName"), rs.getString("roomLocation"));

		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Member> searchClassMateByName(int educationNumber, String name) throws SQLException {
		ArrayList<Member> result = new ArrayList<Member>();
		String sql = "select m.member_id as memberId, m.name as name, m.department as department, m.position as position,"
				+ " m.phone_number as phoneNumber, m.email as email from members m, education_historys eh"
				+ " where eh.member_id = m.member_id and eh.education_number = ? and m.name = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, educationNumber);
		pstmt.setString(2, name);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			result.add(new Member(rs.getInt("memberId"), rs.getString("name"), rs.getString("phoneNumber"),
					rs.getString("email"), rs.getString("department"), rs.getString("position")));
		}

		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Member> searchClassMateByDepartment(int educationNumber, String department) throws SQLException {
		ArrayList<Member> result = new ArrayList<Member>();
		String sql = "select m.member_id as memberId, m.name as name, m.department as department, m.position as position,"
				+ " m.phone_number as phoneNumber, m.email as email from members m, education_historys eh"
				+ " where eh.member_id = m.member_id and eh.education_number = ? and m.department = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, educationNumber);
		pstmt.setString(2, department);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			result.add(new Member(rs.getInt("memberId"), rs.getString("name"), rs.getString("phoneNumber"),
					rs.getString("email"), rs.getString("department"), rs.getString("position")));
		}

		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Member> searchClassMateByEmail(int educationNumber, String email) throws SQLException {
		ArrayList<Member> result = new ArrayList<Member>();
		String sql = "select m.member_id as memberId, m.name as name, m.department as department, m.position as position,"
				+ " m.phone_number as phoneNumber, m.email as email from members m, education_historys eh"
				+ " where eh.member_id = m.member_id and eh.education_number = ? and m.email = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, educationNumber);
		pstmt.setString(2, email);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			result.add(new Member(rs.getInt("memberId"), rs.getString("name"), rs.getString("phoneNumber"),
					rs.getString("email"), rs.getString("department"), rs.getString("position")));
		}

		rs.close();
		pstmt.close();

		return result;
	}

	public Collection<Member> searchClassMateByMemberId(int educationNumber, int memberId) throws SQLException {
		ArrayList<Member> result = new ArrayList<Member>();
		String sql = "select m.member_id as memberId, m.name as name, m.department as department, m.position as position,"
				+ " m.phone_number as phoneNumber, m.email as email from members m, education_historys eh"
				+ " where eh.member_id = m.member_id and eh.education_number = ? and m.member_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, educationNumber);
		pstmt.setInt(2, memberId);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			result.add(new Member(rs.getInt("memberId"), rs.getString("name"), rs.getString("phoneNumber"),
					rs.getString("email"), rs.getString("department"), rs.getString("position")));
		}

		rs.close();
		pstmt.close();

		return result;
	}
	
	public Collection<Member> searchClassMate(int educationNumber) throws SQLException {
		Collection<Member> memberList = new ArrayList<Member>();
		String sql = "select m.member_id as memberId, m.name as name "
				+ "from members m, education_historys eh "
				+ "where eh.education_number=? and m.member_id = eh.member_id ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, educationNumber);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			memberList.add(new Member(rs.getInt("memberId"), rs.getString("name"),"","","",""));
		}
		rs.close();
		pstmt.close();
		//conn.close()
		return memberList;
	}

}
