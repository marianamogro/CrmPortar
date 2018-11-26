package com.nuevatel.crm.sensor.port.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.nuevatel.crm.sensor.db.DataBase;
import com.nuevatel.crm.sensor.port.model.Port;
import com.nuevatel.crm.sensor.port.model.ProcessPortControl;

public class ProcessPortControlDao implements IProcessPortControlDao {
	private SqlSession session = null;
	private static Log log;
	
	public ProcessPortControlDao() {
		log = LogFactory.getLog(ProcessPortControlDao.class);
	}
	
	@Override
	public void create(ProcessPortControl processPortControl) {

		try {
			session = DataBase.getSession("PostGresDS");
			IProcessPortControlDao mapper = session.getMapper(IProcessPortControlDao.class);
			mapper.create(processPortControl);
			session.commit();
		} catch (IllegalArgumentException ex) {
			log.error("PostGresDS 1: ", ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("PostGresDS 2: ", ex);
		} catch (Exception ex) {
			log.error("PostGresDS 3: ", ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
				log.debug("cierra session.....");
			}
		}
	}

	@Override
	public void updateProcess(ProcessPortControl processPortControl) {
		session = null;
		ProcessPortControl result = null;
		try {
			session = DataBase.getSession("PostGresDS");
			IProcessPortControlDao mapper = session.getMapper(IProcessPortControlDao.class);
			mapper.updateProcess(processPortControl);
			session.commit();
		} catch (IllegalArgumentException ex) {
			log.error("updateProcess 1: ", ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("updateProcess 2: ", ex);
		} catch (Exception ex) {
			log.error("updateProcess 3: ", ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
				log.debug("cierra session.....");
			}
		}
		//return result;
	}

	@Override
	public List<ProcessPortControl> retrieve(ProcessPortControl processPortControl) {
		session = null;
		List<ProcessPortControl> result = null;
		try {
			session = DataBase.getSession("PostGresDS");
			IProcessPortControlDao mapper = session.getMapper(IProcessPortControlDao.class);
			result = mapper.retrieve(processPortControl);
		} catch (IllegalArgumentException ex) {
			log.error("retrieve: ", ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("retrieve: ", ex);
		} catch (Exception ex) {
			log.error("retrieve: ", ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	@Override
	public ProcessPortControl retrieveOne(ProcessPortControl processPortControl) {
		session = null;
		ProcessPortControl result = null;
		try {
			session = DataBase.getSession("PostGresDS");
			IProcessPortControlDao mapper = session.getMapper(IProcessPortControlDao.class);
			result = mapper.retrieveOne(processPortControl);
		} catch (IllegalArgumentException ex) {
			log.error("retrieve: ", ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("retrieve: ", ex);
		} catch (Exception ex) {
			log.error("retrieve: ", ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

}
