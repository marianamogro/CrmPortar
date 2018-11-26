package com.nuevatel.crm.sensor.port.dao;

import java.util.List;

import com.nuevatel.crm.sensor.port.model.ProcessPortControl;

public interface IProcessPortControlDao {
	
	public List<ProcessPortControl> retrieve(ProcessPortControl  processPortControl);
	public ProcessPortControl retrieveOne(ProcessPortControl  processPortControl);
	public void create(ProcessPortControl  processPortControl);
	public void updateProcess(ProcessPortControl  processPortControl);

}
