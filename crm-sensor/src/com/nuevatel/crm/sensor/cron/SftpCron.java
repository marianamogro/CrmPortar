package com.nuevatel.crm.sensor.cron;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.nuevatel.crm.sensor.sftp.SFtp;

public class SftpCron implements Job {
	private static Log log;
	public SftpCron(){
		
		log = LogFactory.getLog(SftpCron.class);	
	}
	@Override
	
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		try {
			log.debug("Ejecutando Cron");
			SFtp sFtp = new SFtp();
			sFtp.downloadSftp();
		}
		catch(Exception e ){
			log.error("execute cron: ",e);
			
		}
		
		

	}

}
