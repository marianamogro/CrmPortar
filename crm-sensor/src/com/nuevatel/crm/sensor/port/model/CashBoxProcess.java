package com.nuevatel.crm.sensor.port.model;

import java.sql.Timestamp;

public class CashBoxProcess {

	private Long processId;
	private String processTypeCode;
	private String status;
	private Long formId;
	private String sellerCode;
	private String saleChannelCode;
	private String registroProceso;
	private String etapa;
	private String flowId;
	private String actionId;
	private Timestamp fechaEtapa;
	
	public Long getProcessId() {
		return processId;
	}
	public void setProcessId(Long processId) {
		this.processId = processId;
	}
	public String getProcessTypeCode() {
		return processTypeCode;
	}
	public void setProcessTypeCode(String processTypeCode) {
		this.processTypeCode = processTypeCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getFormId() {
		return formId;
	}
	public void setFormId(Long formId) {
		this.formId = formId;
	}
	public String getSellerCode() {
		return sellerCode;
	}
	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}
	public String getSaleChannelCode() {
		return saleChannelCode;
	}
	public void setSaleChannelCode(String saleChannelCode) {
		this.saleChannelCode = saleChannelCode;
	}
	public String getRegistroProceso() {
		return registroProceso;
	}
	public void setRegistroProceso(String registroProceso) {
		this.registroProceso = registroProceso;
	}
	public String getEtapa() {
		return etapa;
	}
	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getActionId() {
		return actionId;
	}
	public void setActionId(String actionId) {
		this.actionId = actionId;
	}
	public Timestamp getFechaEtapa() {
		return fechaEtapa;
	}
	public void setFechaEtapa(Timestamp fechaEtapa) {
		this.fechaEtapa = fechaEtapa;
	}
	
	
	
}
