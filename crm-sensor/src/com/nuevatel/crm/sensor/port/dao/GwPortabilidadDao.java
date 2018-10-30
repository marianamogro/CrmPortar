package com.nuevatel.crm.sensor.port.dao;

import java.io.IOException;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.nuevatel.crm.sensor.db.DataBase;
import com.nuevatel.crm.sensor.port.model.GwPortabilidad;

public class GwPortabilidadDao implements IGwPortabilidadDao {
	private SqlSession session = null;
	private static Log log;

	public GwPortabilidadDao() {
		log = LogFactory.getLog(GwPortabilidadDao.class);
	}

	@Override
	public GwPortabilidad retrieve(GwPortabilidad gwPortabilidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(GwPortabilidad gwPortabilidad) {
		session = null;
		GwPortabilidad result = null;
		try {
			session = DataBase.getSession("BillDS");
			IGwPortabilidadDao mapper = session.getMapper(IGwPortabilidadDao.class);
			mapper.create(gwPortabilidad);
			session.commit();
		} catch (IllegalArgumentException ex) {
			log.error("Port: ", ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("Port: ", ex);
		} catch (Exception ex) {
			log.error("Port: ", ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		// return result;

	}

	@Override
	public void truncateTable() {
		session = null;
		GwPortabilidad result = null;
		try {
			session = DataBase.getSession("BillDS");
			IGwPortabilidadDao mapper = session.getMapper(IGwPortabilidadDao.class);
			mapper.truncateTable();
			session.commit();
		} catch (IllegalArgumentException ex) {
			log.error("Port: ", ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("Port: ", ex);
		} catch (Exception ex) {
			log.error("Port: ", ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		// return result;
	}

	@Override
	public void backup(GwPortabilidad gwPortabilidad) {
		session = null;
		GwPortabilidad result = null;
		try {
			session = DataBase.getSession("PostGresDS");
			IGwPortabilidadDao mapper = session.getMapper(IGwPortabilidadDao.class);
			mapper.backup(gwPortabilidad);
			session.commit();
		} catch (IllegalArgumentException ex) {
			log.error("Backup: ", ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("Backup: ", ex);
		} catch (Exception ex) {
			log.error("Backup: ", ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		// return result;
		
	}

}
