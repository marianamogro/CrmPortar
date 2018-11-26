package com.nuevatel.crm.sensor.cron;

import java.util.Date;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.nuevatel.crm.sensor.dao.ProcessPortControlDaoFactory;
import com.nuevatel.crm.sensor.port.model.ProcessPortControl;
import com.nuevatel.crm.sensor.sftp.SFtp;

public class CronMassiveProcessControl implements Job {
	private static Log log;

	public CronMassiveProcessControl() {
		log = LogFactory.getLog(CronMassiveProcessControl.class);
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Date now = new Date();
		log.debug("*****IT STARTS THE PORT PROCESS DAILY CONTROL******* "+now);
		ProcessPortControl pc = new ProcessPortControl();
		pc.setStage("FTP");
		System.out.println("---------------- antes del  query");
		System.out.println("---------------- "+ ProcessPortControlDaoFactory.retrieve(pc).size());
		if (ProcessPortControlDaoFactory.retrieve(pc).size()==0) {
			ProcessPortControlDaoFactory.create(pc);
			SFtp sshConnector = new SFtp();
			Integer portNumberAmount= sshConnector.downloadSftp();
			ProcessPortControl ftpRecord=	ProcessPortControlDaoFactory.retrieveOne(pc);
			ftpRecord.setPortNumberAmount(portNumberAmount);
			ProcessPortControlDaoFactory.updateProcess(ftpRecord);
			
		}else {
			log.error("*****THE TEMPLATE CONTROL PROCESS WAS NOT GENERATED***** "+now);
		}
	}

}
