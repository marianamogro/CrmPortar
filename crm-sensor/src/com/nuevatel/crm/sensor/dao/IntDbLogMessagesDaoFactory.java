package com.nuevatel.crm.sensor.dao;

import java.util.List;

import com.nuevatel.crm.sensor.port.dao.IIntDbLogMessagesDao;
import com.nuevatel.crm.sensor.port.dao.IntDbLogMessagesDao;
import com.nuevatel.crm.sensor.port.model.IntDbLogMessages;
import com.nuevatel.crm.sensor.port.model.ParamIn;

public class IntDbLogMessagesDaoFactory {
	
	public static IIntDbLogMessagesDao getIntDbLogMessagesDao() {
		return new IntDbLogMessagesDao();
	}

	public static List<IntDbLogMessages> retrieve(ParamIn paramIn) {
		return getIntDbLogMessagesDao().retrieve(paramIn);
	}
}
