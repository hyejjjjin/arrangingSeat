package com.oopsw.javabean;

public class Member {
	private int memberId;
	private String loginId;
	private String password;
	private String email;
	private String phoneNumber;
	private String name;
	private String birthday;
	private String picture;
	private boolean isLeader;
	private int eduationNumber;
	private String educationName;
	private int roomNumber;
	private String roomLocation;
	private String department;
	private String position;

	Member(String name, String birthday, String phoneNumber, String email, String picture, boolean isLeader,
			String educationName, String roomLocation) {
		this(0, "", "", email, phoneNumber, name, birthday, picture, isLeader, 0, educationName, 0, roomLocation, "",
				"");
	}

	Member(String name, String birthday, String phoneNumber, String email, String picture, boolean isLeader,
			int educationNumber, String educationName, int roomNumber, String roomLocation) {
		this(0, "", "", email, phoneNumber, name, birthday, picture, isLeader, educationNumber, educationName,
				roomNumber, roomLocation, "", "");
	}

	Member(int memberId, String name, String phoneNumber, String email, String department, String position) {
		this(memberId, "", "", email, phoneNumber, name, "", "", false, 0, "", 0, "", department, position);
	}

	public Member(int memberId, String loginId, String password, String email, String phoneNumber, String name,
			String birthday, String picture, boolean isLeader, int educationNumber, String educationName,
			int roomNumber, String roomLocation, String department, String position) {
		super();
		setMemberId(memberId);
		setLoginId(loginId);
		setPassword(password);
		setEmail(email);
		setPhoneNumber(phoneNumber);
		setName(name);
		setBirthday(birthday);
		setPicture(picture);
		setLeader(isLeader);
		setEduationNumber(educationNumber);
		setEducationName(educationName);
		setRoomNumber(roomNumber);
		setRoomLocation(roomLocation);
		setDepartment(department);
		setPosition(position);
	}

	public int getMemberId() {
		return memberId;
	}

	private void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getLoginId() {
		return loginId;
	}

	private void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	private String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public boolean getIsLeader() {
		return isLeader;
	}

	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}

	public String getEducationName() {
		return educationName;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}

	public int getEduationNumber() {
		return eduationNumber;
	}

	public void setEduationNumber(int eduationNumber) {
		this.eduationNumber = eduationNumber;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomLocation() {
		return roomLocation;
	}

	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", loginId=" + loginId + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", name=" + name + ", birthday=" + birthday + ", picture=" + picture + ", isLeader="
				+ isLeader + ", educationName=" + educationName + ", roomLocation=" + roomLocation + ", department="
				+ department + ", position=" + position + "]";
	}
}
