package com.nuevatel.crm.sensor.cron;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import com.nuevatel.crm.sensor.dao.CashBoxDaoFactory;
import com.nuevatel.crm.sensor.integration.WebPushOneSignal;
import com.nuevatel.crm.sensor.port.model.CashBoxProcess;

public class CashBoxProcessCron implements Job {

	private static Log log;
	public CashBoxProcessCron(){
		
		log = LogFactory.getLog(CashBoxProcessCron.class);	
	}
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		  List<CashBoxProcess> cbxs= CashBoxDaoFactory.retrieve(null);
	        StringBuilder st =new StringBuilder();
	        for(CashBoxProcess cbx:cbxs){
	        	System.out.println(cbx.getEtapa());
	        	st.append(cbx.getProcessId() +"   ");
	        	st.append(cbx.getEtapa() +"  ");
	        	st.append(cbx.getFechaEtapa() +"  \n ");
	        }

	        WebPushOneSignal.sendWebPushMessage(st.toString());
		
	}

}
