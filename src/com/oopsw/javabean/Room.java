package com.oopsw.javabean;

public class Room {
	private int roomNumber;
	private String location;
	private int capacity;
	private int rowCount;
	private int colCount;
	private String structurePicture;
	private int labtop;
	private int cabinet;
	private int monitor;
	private int keyboard;
	private int chair;
	private int desk;
	
	public Room(int roomNumber, String location) {
		this(roomNumber, location, 0, 0, 0, "", 0, 0, 0, 0, 0, 0);
	}

	public Room(int roomNumber, String location, String structurePicture) {
		this(roomNumber, location, 0, 0, 0, structurePicture, 0, 0, 0, 0, 0, 0);
	}

	public Room(int capacity, String structurePicture, int labtop, int cabinet, int monitor, int keyboard, int chair,
			int desk) {
		this(0, "", capacity, 0, 0, structurePicture, labtop, cabinet, monitor, keyboard, chair, desk);
	}

	public Room(int roomNumber, String location, int capacity, int rowCount, int colCount, String structurePicture,
			int labtop, int cabinet, int monitor, int keyboard, int chair, int desk) {
		super();
		setRoomNumber(roomNumber);
		setLocation(location);
		setCapacity(capacity);
		setRowCount(rowCount);
		setColCount(colCount);
		setStructurePicture(structurePicture);
		setLabtop(labtop);
		setCabinet(cabinet);
		setMonitor(monitor);
		setKeyboard(keyboard);
		setChair(chair);
		setDesk(desk);
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	private void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getLocation() {
		return location;
	}

	private void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getColCount() {
		return colCount;
	}

	public void setColCount(int colCount) {
		this.colCount = colCount;
	}

	public String getStructurePicture() {
		return structurePicture;
	}

	public void setStructurePicture(String structurePicture) {
		this.structurePicture = structurePicture;
	}

	public int getLabtop() {
		return labtop;
	}

	public void setLabtop(int labtop) {
		this.labtop = labtop;
	}

	public int getCabinet() {
		return cabinet;
	}

	public void setCabinet(int cabinet) {
		this.cabinet = cabinet;
	}

	public int getMonitor() {
		return monitor;
	}

	public void setMonitor(int monitor) {
		this.monitor = monitor;
	}

	public int getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(int keyboard) {
		this.keyboard = keyboard;
	}

	public int getChair() {
		return chair;
	}

	public void setChair(int chair) {
		this.chair = chair;
	}

	public int getDesk() {
		return desk;
	}

	public void setDesk(int desk) {
		this.desk = desk;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", location=" + location + ", capacity=" + capacity + ", rowCount="
				+ rowCount + ", colCount=" + colCount + ", structurePicture=" + structurePicture + ", labtop=" + labtop
				+ ", cabinet=" + cabinet + ", monitor=" + monitor + ", keyboard=" + keyboard + ", chair=" + chair
				+ ", desk=" + desk + "]";
	}

}
