package com.nuevatel.crm.sensor.cron;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.nuevatel.crm.sensor.dao.MassiveProcessControlDaoFactory;
import com.nuevatel.crm.sensor.port.model.MassiveProcessControl;

public class CronMassiveProcessControl implements Job{
	private static Log log;
	public CronMassiveProcessControl(){
		log = LogFactory.getLog(CronMassiveProcessControl.class);	
	}
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		   List<MassiveProcessControl> massives= MassiveProcessControlDaoFactory.retrieve(null);
	        for(MassiveProcessControl mpc:massives){
	        	log.debug(mpc.getStatus()+" " +mpc.getCounter());
	        }      
		
	}

}
