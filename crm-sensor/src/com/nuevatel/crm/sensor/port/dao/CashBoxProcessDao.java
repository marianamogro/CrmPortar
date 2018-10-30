package com.nuevatel.crm.sensor.port.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import com.nuevatel.crm.sensor.db.DataBase;
import com.nuevatel.crm.sensor.port.model.CashBoxProcess;
import com.nuevatel.crm.sensor.port.model.ParamIn;

public class CashBoxProcessDao implements ICashBoxProcessDao {
	private SqlSession session = null;
	private static Log log;

	public CashBoxProcessDao() {
		log = LogFactory.getLog(CashBoxProcessDao.class);
	}

	@Override
	public List<CashBoxProcess> retrieve(ParamIn paramIn) {
		session = null;
		List<CashBoxProcess> result = null;
		try {
			session = DataBase.getSession("OdbDS");
			ICashBoxProcessDao mapper = session.getMapper(ICashBoxProcessDao.class);
			result = mapper.retrieve(paramIn);
		} catch (IllegalArgumentException ex) {
			log.error("CashBoxProcess: ", ex);
			session.rollback();
		} catch (IOException ex) {
			log.error("CashBoxProcess: ", ex);
		} catch (Exception ex) {
			log.error("CashBoxProcess: ", ex);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;

	}

}
