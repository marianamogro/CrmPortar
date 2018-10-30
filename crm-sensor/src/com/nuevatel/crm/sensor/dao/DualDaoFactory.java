package com.nuevatel.crm.sensor.dao;

import com.nuevatel.crm.sensor.model.Dual;

public class DualDaoFactory {

	public static DualDao getDual() {
		return new DualDao();
	}

	public static Dual sysDate(Dual dual) {
		return getDual().retrieve(dual);
	}
	
}
