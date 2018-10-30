package com.nuevatel.crm.sensor.port.model;

import java.sql.Timestamp;

public class ParamIn {
  private Timestamp startDate;
  private Timestamp endDate;
  private String phoneNumber;
  private String NpOrderId;
public Timestamp getStartDate() {
	return startDate;
}
public void setStartDate(Timestamp startDate) {
	this.startDate = startDate;
}
public Timestamp getEndDate() {
	return endDate;
}
public void setEndDate(Timestamp endDate) {
	this.endDate = endDate;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getNpOrderId() {
	return NpOrderId;
}
public void setNpOrderId(String npOrderId) {
	NpOrderId = npOrderId;
}
  
  
}
