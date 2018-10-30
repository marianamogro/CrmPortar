package com.nuevatel.crm.sensor.port.dao;

import java.io.IOException;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.nuevatel.crm.sensor.db.DataBase;
import com.nuevatel.crm.sensor.port.model.GwPortabilidad;
import com.nuevatel.crm.sensor.port.model.PortTransaction;


public class PortTransactionDao implements IPortTransactionDao {
	private SqlSession session = null;
	private static Log log;

	public PortTransactionDao() {
		log = LogFactory.getLog(PortTransactionDao.class);
	}
	@Override
	public void create(PortTransaction portTransaction) {
		session = null;
		GwPortabilidad result = null;
		try {
			session = DataBase.getSession("RepDwhDS");
			IPortTransactionDao mapper = session.getMapper(IPortTransactionDao.class);
			mapper.create(portTransaction);
			session.commit();
		} catch (IllegalArgumentException ex) {
			log.error("RepDwh: ", ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("RepDwh: ", ex);
		} catch (Exception ex) {
			log.error("RepDwh: ", ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void truncateTable()  {
		session = null;
		IPortTransactionDao result = null;
		try {
			session = DataBase.getSession("RepDwhDS");
			IPortTransactionDao mapper = session.getMapper(IPortTransactionDao.class);
			mapper.truncateTable();
			session.commit();
		} catch (IllegalArgumentException ex) {
			log.error("RepDwh: ", ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("RepDwh: ", ex);
		} catch (Exception ex) {
			log.error("RepDwh: ", ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		// return result;
	}
	@Override
	public void backup(PortTransaction portTransaction) {
		session = null;
	//	GwPortabilidad result = null;
		try {
			session = DataBase.getSession("PostGresDS");
			IPortTransactionDao mapper = session.getMapper(IPortTransactionDao.class);
			mapper.backup(portTransaction);
			session.commit();
		} catch (IllegalArgumentException ex) {
			log.error("RepDwh: ", ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("RepDwh: ", ex);
		} catch (Exception ex) {
			log.error("RepDwh: ", ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}


}
