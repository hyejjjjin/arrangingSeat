package com.oopsw.javabean;

public class SeatHistory {

	private int arrangingNumber;
	private int rowNumber;
	private int colNumber;
	private String arrangingStartDate;
	private String arrangingEndDate;
	private int memberId;
	private String memberName;
	private int educationNumber;
	private int roomNumber;

	
	
	public SeatHistory(int educationNumber, int roomNumber) {
		this(0, 0, 0, "", "", 0,"", educationNumber, roomNumber);
	}

	public SeatHistory(int rowNumber, int colNumber, int memberId) {
		this(0, rowNumber, colNumber, "", "", memberId, "", 0, 0);
	}

	public SeatHistory(int rowNumber, int colNumber, int memberId, String memberName) {
		this(0, rowNumber, colNumber, "", "", memberId, memberName, 0, 0);
	}

	public SeatHistory(int rowNumber, int colNumber, String arrangingStartDate,
			String arrangingEndDate, int memberId, int educationNumber, int roomNumber) {
		this(0, rowNumber, colNumber, arrangingStartDate, arrangingEndDate, memberId, "", educationNumber, roomNumber);
	}
	
	public SeatHistory(int arrangingNumber, int rowNumber, int colNumber, String arrangingStartDate,
			String arrangingEndDate, int memberId, String memberName, int educationNumber, int roomNumber) {
		setArrangingNumber(arrangingNumber);
		setRowNumber(rowNumber);
		setColNumber(colNumber);
		setArrangingStartDate(arrangingStartDate);
		setArrangingEndDate(arrangingEndDate);
		setMemberId(memberId);
		setMemberName(memberName);
		setEducationNumber(educationNumber);
		setRoomNumber(roomNumber);
	}

	private void setArrangingNumber(int arrangingNumber) {
		this.arrangingNumber = arrangingNumber;
	}

	private void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	private void setColNumber(int colNumber) {
		this.colNumber = colNumber;
	}

	private void setArrangingStartDate(String arrangingStartDate) {
		this.arrangingStartDate = arrangingStartDate;
	}

	private void setArrangingEndDate(String arrangingEndDate) {
		this.arrangingEndDate = arrangingEndDate;
	}

	private void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	private void setEducationNumber(int educationNumber) {
		this.educationNumber = educationNumber;
	}

	private void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getArrangingNumber() {
		return arrangingNumber;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public int getColNumber() {
		return colNumber;
	}

	public String getArrangingStartDate() {
		return arrangingStartDate;
	}

	public String getArrangingEndDate() {
		return arrangingEndDate;
	}

	public int getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getEducationNumber() {
		return educationNumber;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	@Override
	public String toString() {
		return "SeatHistory [arrangingNumber=" + arrangingNumber + ", rowNumber=" + rowNumber + ", colNumber="
				+ colNumber + ", arrangingStartDate=" + arrangingStartDate + ", arrangingEndDate=" + arrangingEndDate
				+ ", memberId=" + memberId + ", memberName=" + memberName + ", educationNumber=" + educationNumber
				+ ", roomNumber=" + roomNumber + "]";
	}

}
