package com.nuevatel.crm.sensor.port.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.nuevatel.crm.sensor.db.DataBase;
import com.nuevatel.crm.sensor.port.model.MassiveProcessControl;
import com.nuevatel.crm.sensor.port.model.ParamIn;

public class MassiveProcessControlDao implements IMassiveProcessControlDao {
	private SqlSession session = null;
	private static Log log;

	public MassiveProcessControlDao() {
		log = LogFactory.getLog(MassiveProcessControlDao.class);
	}
	
	@Override
	public List<MassiveProcessControl> retrieve(ParamIn paramIn) {
		session = null;
		List<MassiveProcessControl> result = null;
		try {
			session = DataBase.getSession("PortDS");
			IMassiveProcessControlDao mapper = session.getMapper(IMassiveProcessControlDao.class);
			result = mapper.retrieve(paramIn);
		} catch (IllegalArgumentException ex) {
			log.error("MassiveProcessControl: ", ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("MassiveProcessControl: ", ex);
		} catch (Exception ex) {
			log.error("MassiveProcessControl: ", ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;

	}

}
