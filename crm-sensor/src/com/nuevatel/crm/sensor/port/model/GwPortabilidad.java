package com.nuevatel.crm.sensor.port.model;

import java.sql.Timestamp;

public class GwPortabilidad {
	private Timestamp requestDateTime;
	private String npOrderId;
	private String telePhoneNumber;
	private String donorOperator;
	private String receptorOperator;
	private String status;
	private String subTransactionType;
	private Timestamp fechaLectura;

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

	public String getTelePhoneNumber() {
		return telePhoneNumber;
	}

	public void setTelePhoneNumber(String telePhoneNumber) {
		this.telePhoneNumber = telePhoneNumber;
	}

	public String getDonorOperator() {
		return donorOperator;
	}

	public void setDonorOperator(String donorOperator) {
		this.donorOperator = donorOperator;
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

	public Timestamp getFechaLectura() {
		return fechaLectura;
	}

	public void setFechaLectura(Timestamp fechaLectura) {
		this.fechaLectura = fechaLectura;
	}

}
