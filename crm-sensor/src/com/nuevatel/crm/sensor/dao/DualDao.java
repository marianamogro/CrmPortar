package com.nuevatel.crm.sensor.dao;

import java.io.IOException;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.nuevatel.crm.sensor.bl.CrmSensor;
import com.nuevatel.crm.sensor.db.DataBase;
import com.nuevatel.crm.sensor.model.Dual;

public class DualDao implements IDualDao {
	private SqlSession session = null;
	private static Log log;
	
	
	public DualDao(){
		log = LogFactory.getLog(DualDao.class);	
	}

	@Override
	public Dual retrieve(Dual dual) {
		session = null;
		Dual result = null;
		try {
			session = DataBase.getSession("PortDS");
			IDualDao mapper = session.getMapper(IDualDao.class);
			result = mapper.retrieve(dual);
		} catch (IllegalArgumentException ex) {
			log.error("Dual: ",ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("Dual: ",ex);
		} catch (Exception ex) {
			log.error("Dual: ",ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;

	}

}
