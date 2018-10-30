package com.nuevatel.crm.sensor.dao;

import java.util.List;

import com.nuevatel.crm.sensor.port.dao.IPortDao;
import com.nuevatel.crm.sensor.port.dao.PortDao;
import com.nuevatel.crm.sensor.port.model.ParamIn;
import com.nuevatel.crm.sensor.port.model.Port;

public class PortDaoFactory {

	public static IPortDao getPortDao() {
		return new PortDao();
	}

	public static List<Port> retrieve(ParamIn paramIn) {
		return getPortDao().retrieve(paramIn);
	}
}

