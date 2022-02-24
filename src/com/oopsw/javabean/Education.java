package com.oopsw.javabean;


public class Education {
	private int educationNumber;
	private String name;
	private String startDate;
	private String endDate;
	private String teacherName;
	private int roomNumber;
	
	
	
	public Education(int educationNumber, int roomNumber) {
		this(educationNumber, "", "","" , "", roomNumber);
	}

	public Education(int educationNumber, String name, String startDate, String endDate, String teacherName,
			int roomNumber) {
		super();
		setEducationNumber(educationNumber);
		setName(name);
		setStartDate(startDate);
		setEndDate(endDate);
		setTeacherName(teacherName);
		setRoomNumber(roomNumber);
	}
	
	private void setEducationNumber(int educationNumber) {
		this.educationNumber = educationNumber;
	}
	private void setName(String name) {
		this.name = name;
	}
	private void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	private void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	private void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	private void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getEducationNumber() {
		return educationNumber;
	}
	public String getName() {
		return name;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	@Override
	public String toString() {
		return "Education [educationNumber=" + educationNumber + ", name=" + name + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", teacherName=" + teacherName + ", roomNumber=" + roomNumber + "]";
	}
	
	
	
}
