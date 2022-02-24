package com.oopsw.javabean;

import java.util.Collection;

public class ArrangeSeatListVO {

	Collection<SeatHistory> seatHistoryList;
	
	public ArrangeSeatListVO(Collection<SeatHistory> list) {
		seatHistoryList = list;
	}

	public Collection<SeatHistory> getSeatHistoryList() {
		return seatHistoryList;
	}

	public void setSeatHistoryList(Collection<SeatHistory> seatHistoryList) {
		this.seatHistoryList = seatHistoryList;
	}
	
	
}
