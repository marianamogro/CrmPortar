package com.nuevatel.crm.sensor.port.dao;

import com.nuevatel.crm.sensor.port.model.PortTransaction;


public interface IPortTransactionDao {
	  public void create(PortTransaction portTransaction);
	  public void truncateTable();
	  public void backup(PortTransaction portTransaction);
}