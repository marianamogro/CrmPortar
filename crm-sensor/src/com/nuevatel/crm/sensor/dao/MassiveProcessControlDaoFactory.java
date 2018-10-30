package com.nuevatel.crm.sensor.dao;

import java.util.List;

import com.nuevatel.crm.sensor.port.dao.IMassiveProcessControlDao;
import com.nuevatel.crm.sensor.port.dao.MassiveProcessControlDao;
import com.nuevatel.crm.sensor.port.model.MassiveProcessControl;
import com.nuevatel.crm.sensor.port.model.ParamIn;

public class MassiveProcessControlDaoFactory {
	
	public static IMassiveProcessControlDao getMassiveProcessControlDao() {
		return new MassiveProcessControlDao();
	}

	public static List<MassiveProcessControl> retrieve(ParamIn paramIn) {
		return getMassiveProcessControlDao().retrieve(paramIn);
	}
}
