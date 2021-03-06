package com.nuevatel.crm.sensor.port.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.nuevatel.crm.sensor.db.DataBase;
import com.nuevatel.crm.sensor.port.model.IntDbLogMessages;
import com.nuevatel.crm.sensor.port.model.ParamIn;

public class IntDbLogMessagesDao implements IIntDbLogMessagesDao {
	private SqlSession session = null;
	private static Log log;

	public IntDbLogMessagesDao() {
		log = LogFactory.getLog(IntDbLogMessagesDao.class);
	}

	@Override
	public List<IntDbLogMessages> retrieve(ParamIn paramIn) {
		session = null;
		List<IntDbLogMessages> result = null;
		try {
			session = DataBase.getSession("IntDbDS");
			IIntDbLogMessagesDao mapper = session.getMapper(IIntDbLogMessagesDao.class);
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
