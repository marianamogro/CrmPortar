package com.nuevatel.crm.sensor.dao;

import java.util.List;

import com.nuevatel.crm.sensor.port.dao.IProcessPortControlDao;
import com.nuevatel.crm.sensor.port.dao.ProcessPortControlDao;
import com.nuevatel.crm.sensor.port.model.ProcessPortControl;

public class ProcessPortControlDaoFactory {
	
	public static IProcessPortControlDao getProcessPortControlDaoFactory() {
		return new ProcessPortControlDao();
	}
	
	public static void create(ProcessPortControl processPortControl) {
    	 getProcessPortControlDaoFactory().create(processPortControl);
	}
	
	public static List<ProcessPortControl> retrieve(ProcessPortControl processPortControl) {
		return getProcessPortControlDaoFactory().retrieve(processPortControl);
	}
	public static ProcessPortControl retrieveOne(ProcessPortControl processPortControl) {
		return getProcessPortControlDaoFactory().retrieveOne(processPortControl);
	}
	
	public static void updateProcess(ProcessPortControl processPortControl) {
   	 getProcessPortControlDaoFactory().updateProcess(processPortControl);
	}
}
