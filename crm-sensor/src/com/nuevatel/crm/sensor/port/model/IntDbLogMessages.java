package com.nuevatel.crm.sensor.port.model;

import java.sql.Timestamp;

public class IntDbLogMessages {
	
	private Long idLogMessage;
	private String codeError;
	private String idIntegration;
	private String idRequest;
	private String idProcessInstance;
	private String module;
	private String severity;
	private String message;
	private Timestamp registerDate;
	private String statusCode;
	
	public Long getIdLogMessage() {
		return idLogMessage;
	}
	public void setIdLogMessage(Long idLogMessage) {
		this.idLogMessage = idLogMessage;
	}
	public String getCodeError() {
		return codeError;
	}
	public void setCodeError(String codeError) {
		this.codeError = codeError;
	}
	public String getIdIntegration() {
		return idIntegration;
	}
	public void setIdIntegration(String idIntegration) {
		this.idIntegration = idIntegration;
	}
	public String getIdRequest() {
		return idRequest;
	}
	public void setIdRequest(String idRequest) {
		this.idRequest = idRequest;
	}
	public String getIdProcessInstance() {
		return idProcessInstance;
	}
	public void setIdProcessInstance(String idProcessInstance) {
		this.idProcessInstance = idProcessInstance;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


}
