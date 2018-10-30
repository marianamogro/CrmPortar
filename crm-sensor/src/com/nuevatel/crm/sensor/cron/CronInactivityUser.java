package com.nuevatel.crm.sensor.cron;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.nuevatel.crm.sensor.dao.DualDaoFactory;
import com.nuevatel.crm.sensor.model.Dual;

public class CronInactivityUser implements Job {
	private static Log log;
	public CronInactivityUser(){
		log = LogFactory.getLog(CronInactivityUser.class);	
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		Dual dual = new Dual();
		Dual borrame = DualDaoFactory.sysDate(dual);
		log.debug("Ping1: "+borrame.getDateTime());
		
	}

}
