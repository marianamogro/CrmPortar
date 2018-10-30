package com.nuevatel.crm.sensor.port.model;

import java.sql.Timestamp;

public class PortTransaction {
	private Timestamp requestDateTime; // endDateTime
	private String npOrderId;
	private String phoneNumber;
	private String receptorOperator;
	private String donorOperator;
	private String status;
	private String subTransactionType;
	private Timestamp recordDateTime;
	private Timestamp startDateTime;
	private Timestamp endDateTime;

	public Timestamp getRequestDateTime() {
		return requestDateTime;
	}

	public void setRequestDateTime(Timestamp requestDateTime) {
		this.requestDateTime = requestDateTime;
	}

	public String getNpOrderId() {
		return npOrderId;
	}

	public void setNpOrderId(String npOrderId) {
		this.npOrderId = npOrderId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getReceptorOperator() {
		return receptorOperator;
	}

	public void setReceptorOperator(String receptorOperator) {
		this.receptorOperator = receptorOperator;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubTransactionType() {
		return subTransactionType;
	}

	public void setSubTransactionType(String subTransactionType) {
		this.subTransactionType = subTransactionType;
	}

	public Timestamp getRecordDateTime() {
		return recordDateTime;
	}

	public void setRecordDateTime(Timestamp recordDateTime) {
		this.recordDateTime = recordDateTime;
	}

	public Timestamp getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Timestamp startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Timestamp getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Timestamp endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getDonorOperator() {
		return donorOperator;
	}

	public void setDonorOperator(String donorOperator) {
		this.donorOperator = donorOperator;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("requestDateTime: ");
		result.append(requestDateTime);
		result.append(" npOrderId: ");
		result.append(npOrderId);
		result.append(" phoneNumber: ");
		result.append(phoneNumber);
		result.append(" receptorOperator: ");
		result.append(receptorOperator);
		result.append(" donorOperator: ");
		result.append(donorOperator);
		result.append(" status: ");
		result.append(status);
		result.append(" subTransactionType: ");
		result.append(subTransactionType);
		result.append(" recordDateTime: ");
		result.append(recordDateTime);
		result.append(" startDateTime: ");
		result.append(startDateTime);
		result.append(" endDateTime: ");
		result.append(endDateTime);
		return result.toString();
	}
}
