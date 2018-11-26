package com.nuevatel.crm.sensor.port.model;

import java.sql.Timestamp;

public class ProcessPortControl {

	private Integer processPortControlId;
	private String stage;
	private Integer portNumberAmount;
	private Timestamp processDate;
	private Timestamp endDate;

	public Integer getProcessPortControlId() {
		return processPortControlId;
	}

	public void setProcessPortControlId(Integer processPortControlId) {
		this.processPortControlId = processPortControlId;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public Integer getPortNumberAmount() {
		return portNumberAmount;
	}

	public void setPortNumberAmount(Integer portNumberAmount) {
		this.portNumberAmount = portNumberAmount;
	}

	public Timestamp getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Timestamp processDate) {
		this.processDate = processDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	
   @Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		str.append("processPortControlId | "+processPortControlId);
		str.append("stage  " + stage);
		str.append("portNumberAmount | " + portNumberAmount);
		str.append("processDate | " + processDate);
		str.append("endDate | " + endDate);

		return str.toString();
	}
}
