package com.nuevatel.crm.sensor.cron;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CronProcessControlQuery implements Job {
	private static Log log;
	
	public CronProcessControlQuery(){
		log = LogFactory.getLog(CronProcessControlQuery.class);	
	}
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.debug("*******IT STARTS PORT NUMBER QUERY CONTROL**********");
		TPortProcessControl tPortProcessControl = new TPortProcessControl();
		Thread tThreadControl = new Thread(tPortProcessControl);
		tThreadControl.start();

	}

}
