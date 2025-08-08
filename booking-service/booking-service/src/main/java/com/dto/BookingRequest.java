package com.dto;

public class BookingRequest {
	private Integer fromId;
	private Integer toId;
	private Integer cabTypeId;
	public Integer getFromId() {
		return fromId;
	}
	public void setFromId(int fromId) {
		this.fromId = fromId;
	}
	public Integer getToId() {
		return toId;
	}
	public void setToId(int toId) {
		this.toId = toId;
	}
	public Integer getCabTypeId() {
		return cabTypeId;
	}
	public void setCabTypeId(int cabTypeId) {
		this.cabTypeId = cabTypeId;
	}
}
