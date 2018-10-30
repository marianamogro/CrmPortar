package com.nuevatel.crm.sensor.cron;

import org.apache.ibatis.logging.Log;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronExecutor {
	
    private String jobName;
    public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public void setCronClass(String cronClass) {
		this.cronClass = cronClass;
	}
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}
	public void setCronTimer(String cronTimer) {
		this.cronTimer = cronTimer;
	}
	public static void setLog(Log log) {
		CronExecutor.log = log;
	}
	private String jobGroup;
    private String cronClass;
    private String triggerName;
    private String triggerGroup;
    private String cronTimer;
    private static Log log;
	
	
	public  Scheduler createScheduler() throws SchedulerException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();
		return scheduler;
	}
	@SuppressWarnings("unchecked")
	public  void excuteCron(){
		try{
		Class<? extends Job> jobClass = (Class<? extends Job>)Class.forName(cronClass);
		Scheduler scheduler =createScheduler();
		JobDetail jd = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroup).build();
		Trigger ct = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroup).withSchedule(CronScheduleBuilder.cronSchedule(cronTimer)).build();
		scheduler.scheduleJob(jd, ct);
		scheduler.start();
		}catch(ClassNotFoundException ex){
			log.error("ClassNotFoundException: ",ex);
		}catch(SchedulerException ex){
			log.error("SchedulerException: ",ex);
		}catch(Exception ex){
			log.error("Exception: ",ex);
		}
	}
	

}
