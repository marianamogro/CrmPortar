package com.nuevatel.crm.sensor.dao;

import java.util.List;

import com.nuevatel.crm.sensor.port.dao.CashBoxProcessDao;
import com.nuevatel.crm.sensor.port.dao.ICashBoxProcessDao;
import com.nuevatel.crm.sensor.port.model.CashBoxProcess;
import com.nuevatel.crm.sensor.port.model.ParamIn;

public class CashBoxDaoFactory {

	
	public static ICashBoxProcessDao getCashBoxProcessDao() {
		return new CashBoxProcessDao();
	}

	public static List<CashBoxProcess> retrieve(ParamIn paramIn) {
		return getCashBoxProcessDao().retrieve(paramIn);
	}
	
}
