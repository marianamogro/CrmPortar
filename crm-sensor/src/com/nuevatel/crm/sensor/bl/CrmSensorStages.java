package com.nuevatel.crm.sensor.bl;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.log4j.xml.DOMConfigurator;

import com.nuevatel.crm.sensor.cron.CronExecutor;

public class CrmSensorStages {
	
	private static Log log;
	
	public CrmSensorStages(){
		log = LogFactory.getLog(CrmSensorStages.class);	
	}
	
	public void intStage() {
		
		CronExecutor ce1 = new CronExecutor();
		ce1.setCronClass("com.nuevatel.crm.sensor.cron.CronMassiveProcessControl");
		ce1.setJobName("FristJob1");
		ce1.setJobGroup("FirstGroup1");
		ce1.setTriggerName("TriggerName1");
		ce1.setTriggerGroup("FirstTriggerGroup1");
		//ce1.setCronTimer("0/2 * * * * ?");
		ce1.setCronTimer("0 50 20 ? * *");
		ce1.excuteCron();
		
		CronExecutor ce2 = new CronExecutor();
		ce1.setCronClass("com.nuevatel.crm.sensor.cron.CronProcessControlQuery");
		ce1.setJobName("FristJob2");
		ce1.setJobGroup("FirstGroup2");
		ce1.setTriggerName("TriggerName2");
		ce1.setTriggerGroup("FirstTriggerGroup2");
		//ce1.setCronTimer("0/2 * * * * ?");
		ce1.setCronTimer("0 58 00 ? * *");
		ce1.excuteCron();
		
	}

	public static void main(String args[]) {

		DOMConfigurator.configure("log4jLog.xml");
		
		try {
			CrmSensorStages crmSensorStages = new CrmSensorStages();
			crmSensorStages.intStage();
 
		} catch (Exception e) {
			log.error("Error general termina la ejecucion ",e);
		}
	}
}
