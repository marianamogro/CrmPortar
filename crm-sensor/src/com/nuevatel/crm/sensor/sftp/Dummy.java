package com.nuevatel.crm.sensor.sftp;

import org.apache.log4j.xml.DOMConfigurator;

import com.nuevatel.crm.sensor.config.Configuration;
import com.nuevatel.crm.sensor.cron.CronExecutor;
import com.nuevatel.crm.sensor.util.Util;

public class Dummy {
	public static void main (String args[]) {
		String parametersCron = null;
		Configuration.loadProperties();
		parametersCron= Configuration.ftpParamCron;
		DOMConfigurator.configure("log4jLog.xml");
		CronExecutor ftpCron = new CronExecutor();
		ftpCron.setCronClass("com.nuevatel.crm.sensor.cron.SftpCron");
		ftpCron.setJobName("FirstJobSftpCron");
		ftpCron.setJobGroup("FirstGroupSftpCron");
		ftpCron.setTriggerName("TriggerNameSftpCron");
		ftpCron.setTriggerGroup("FirstTriggerGroupSftpCron");		
		ftpCron.setCronTimer(parametersCron);
		ftpCron.excuteCron();
		
	}
		

}
