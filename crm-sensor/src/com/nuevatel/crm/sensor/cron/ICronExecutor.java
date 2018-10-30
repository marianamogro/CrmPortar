package com.nuevatel.crm.sensor.cron;

import org.quartz.SchedulerFactory;

public interface ICronExecutor {
  
	public SchedulerFactory createSchedulerBuilder();
	
}
