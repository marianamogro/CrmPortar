package com.nuevatel.crm.sensor.cron;

import java.util.List;

import com.nuevatel.crm.sensor.dao.MassiveProcessControlDaoFactory;
import com.nuevatel.crm.sensor.dao.ProcessPortControlDaoFactory;
import com.nuevatel.crm.sensor.port.model.MassiveProcessControl;
import com.nuevatel.crm.sensor.port.model.ProcessPortControl;

public class TPortProcessControl implements Runnable {
	private Boolean stopRunning = false;

	public void setStopRunning(Boolean stopRunning) {
		this.stopRunning = stopRunning;
	}

	@Override
	public void run() {
		while (!stopRunning) {
			try {
	
         		List<MassiveProcessControl> mpcs=	MassiveProcessControlDaoFactory.retrieve(null);
         		if ( (mpcs.size()==1) && (mpcs.get(0).getStatus().equals("COM")) ) {
         		   ProcessPortControl pc = new ProcessPortControl();
         		   pc.setStage("FTP");
         		   ProcessPortControl amountFtpRecords=	ProcessPortControlDaoFactory.retrieveOne(pc);
         		   if(amountFtpRecords.getPortNumberAmount()==mpcs.get(0).getCounter()  ) {
             		   this.stopRunning=true; 
         		   }else{
       				Thread.sleep(60L * 1000L);	
         		   }
         		}

				System.out.println("Ejecutar query");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Temino de ejecutar el query");
	}

}
