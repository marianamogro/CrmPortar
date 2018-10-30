package com.nuevatel.crm.sensor.bl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.log4j.xml.DOMConfigurator;

import com.nuevatel.crm.sensor.dao.GwPortabilidadDaoFactory;
import com.nuevatel.crm.sensor.dao.PortDaoFactory;
import com.nuevatel.crm.sensor.dao.PortTransactionDaoFactory;
import com.nuevatel.crm.sensor.port.model.GwPortabilidad;
import com.nuevatel.crm.sensor.port.model.Port;
import com.nuevatel.crm.sensor.port.model.PortTransaction;

public class CrmSensor {
	private static Log log;
	
	public CrmSensor(){
		log = LogFactory.getLog(CrmSensor.class);	
	}

	public static void main(String[] args){
		DOMConfigurator.configure("log4jLog.xml");
		System.out.println("inicio");
        List<Port> ports = PortDaoFactory.retrieve(null);
        System.out.println("antes del for");
      
      
       // GwPortabilidadDaoFactory.truncateTable();
        for (Port port:ports){
        	System.out.println(port.toString());
        	GwPortabilidad gwPort = new GwPortabilidad();
        	gwPort.setRequestDateTime(port.getEndDateTime());
        	gwPort.setDonorOperator(port.getDonorOperator());
        	//gwPort.setFechaLectura(port.getRecordDateTime());
        	gwPort.setNpOrderId(port.getNpOrderId());
        	gwPort.setReceptorOperator(port.getReceptorOperator());
        	gwPort.setStatus(port.getStatus());
        	gwPort.setSubTransactionType(port.getSubTransactionType());
        	gwPort.setTelePhoneNumber(port.getPhoneNumber());
        //	gwPort
        	 GwPortabilidadDaoFactory.backup(gwPort);
        	 GwPortabilidadDaoFactory.create(gwPort);
        }
      //  PortTransactionDaoFactory.truncateTable();
        for (Port port:ports){
        	System.out.println(port.toString());
        	PortTransaction portTx = new PortTransaction();
        	portTx.setRequestDateTime(port.getEndDateTime());
        	portTx.setDonorOperator(port.getDonorOperator());
        	portTx.setNpOrderId(port.getNpOrderId());
        	portTx.setReceptorOperator(port.getReceptorOperator());
        	portTx.setStatus(port.getStatus());
        	portTx.setSubTransactionType(port.getSubTransactionType());
        	portTx.setPhoneNumber(port.getPhoneNumber());
        	portTx.setStartDateTime(port.getStartDateTime());
        	portTx.setEndDateTime(port.getEndDateTime());
        //	gwPort
        	PortTransactionDaoFactory.backup(portTx);
        	PortTransactionDaoFactory.create(portTx);
        }
       
       
     /*   List<IntDbLogMessages> logMsgs= IntDbLogMessagesDaoFactory.retrieve(null);
        for(IntDbLogMessages logMessage:logMsgs){
        	System.out.println(logMessage.getMessage());
        }
        */
        /* 
        List<MassiveProcessControl> massives= MassiveProcessControlDaoFactory.retrieve(null);
        System.out.println(massives.size());
        for(MassiveProcessControl mpc:massives){
        	System.out.println(mpc.getStatus()+" " +mpc.getCounter());
        }        
        */
    	System.out.println("fin");
    	/*
    	CronExecutor ce1 = new CronExecutor();
		ce1.setCronClass("com.nuevatel.crm.sensor.cron.CashBoxProcessCron");
		ce1.setJobName("FristJob1");
		ce1.setJobGroup("FirstGroup1");
		ce1.setTriggerName("TriggerName1");
		ce1.setTriggerGroup("FirstTriggerGroup1");
		ce1.setCronTimer("0 11 20 * * ?");
		ce1.excuteCron();
		*/
    	/* alemy
    	CronExecutor ce11 = new CronExecutor();
		ce11.setCronClass("com.nuevatel.crm.sensor.cron.CashBoxProcessCron");
		ce11.setJobName("FristJob11");
		ce11.setJobGroup("FirstGroup11");
		ce11.setTriggerName("TriggerName11");
		ce11.setTriggerGroup("FirstTriggerGroup11");
		ce11.setCronTimer("0 0 18 * * ?");
		ce11.excuteCron();
		*/
	
		/*
		CronExecutor ce = new CronExecutor();
		ce.setCronClass("com.nuevatel.crm.sensor.cron.CronJob");
		ce.setJobName("FristJob");
		ce.setJobGroup("FirstGroup");
		ce.setTriggerName("TriggerName");
		ce.setTriggerGroup("FirstTriggerGroup");
		ce.setCronTimer("0/1 * * * * ?");
		ce.excuteCron();
		
		CronExecutor ce1 = new CronExecutor();
		ce1.setCronClass("com.nuevatel.crm.sensor.cron.CronInactivityUser");
		ce1.setJobName("FristJob1");
		ce1.setJobGroup("FirstGroup1");
		ce1.setTriggerName("TriggerName1");
		ce1.setTriggerGroup("FirstTriggerGroup1");
		ce1.setCronTimer("0/1 * * * * ?");
		ce1.excuteCron();
       */

	}
}
