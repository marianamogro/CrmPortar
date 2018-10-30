package com.nuevatel.crm.sensor.port.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.nuevatel.crm.sensor.db.DataBase;
import com.nuevatel.crm.sensor.port.model.ParamIn;
import com.nuevatel.crm.sensor.port.model.Port;

public class PortDao implements IPortDao {
	private SqlSession session = null;
	private static Log log;

	public PortDao() {
		log = LogFactory.getLog(PortDao.class);
	}

	@Override
	public List<Port> retrieve(ParamIn paramIn) {
		session = null;
		List<Port> result = null;
		try {
			session = DataBase.getSession("PortDS");
			IPortDao mapper = session.getMapper(IPortDao.class);
			result = mapper.retrieve(paramIn);
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
		return result;

	}

}
