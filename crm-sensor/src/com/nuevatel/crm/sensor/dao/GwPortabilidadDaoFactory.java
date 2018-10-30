package com.nuevatel.crm.sensor.dao;

import com.nuevatel.crm.sensor.port.dao.GwPortabilidadDao;
import com.nuevatel.crm.sensor.port.dao.IGwPortabilidadDao;
import com.nuevatel.crm.sensor.port.model.GwPortabilidad;

public class GwPortabilidadDaoFactory {

	public static IGwPortabilidadDao getGwPortabilidadDao() {
		return new GwPortabilidadDao();
	}

	public static void create(GwPortabilidad gwPortabilidad) {
		getGwPortabilidadDao().create(gwPortabilidad);
	}

	public static void truncateTable(){
		getGwPortabilidadDao().truncateTable();
	}
	
	public static void backup(GwPortabilidad gwPortabilidad){
		getGwPortabilidadDao().backup(gwPortabilidad);
	}
}
