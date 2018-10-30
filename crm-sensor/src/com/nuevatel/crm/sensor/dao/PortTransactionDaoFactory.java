package com.nuevatel.crm.sensor.dao;

import com.nuevatel.crm.sensor.port.dao.IPortTransactionDao;
import com.nuevatel.crm.sensor.port.dao.PortTransactionDao;
import com.nuevatel.crm.sensor.port.model.PortTransaction;

public class PortTransactionDaoFactory {
	
	public static IPortTransactionDao getPortTransactionDao() {
		return new PortTransactionDao();
	}
	
	public static void create(PortTransaction portTransaction) {
		getPortTransactionDao().create(portTransaction);
	}

	public static void truncateTable(){
		getPortTransactionDao().truncateTable();
	}
	
	public static void backup(PortTransaction portTransaction) {
		getPortTransactionDao().backup(portTransaction);
	}
	
}
