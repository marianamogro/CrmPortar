package com.nuevatel.crm.sensor.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import com.nuevatel.crm.sensor.db.DataBase;
import com.nuevatel.crm.sensor.model.Domain;

public class DomainDao implements IDomainDao {
    private SqlSession session = null;
	@Override
	public Domain retrieve(Domain domain) {
		 session = null;
		    Domain result = null;
		    try {
		      session = DataBase.getSession("SensorDS");
		      DomainDao mapper = session.getMapper(DomainDao.class);
		      result = mapper.retrieve(domain);
		    } catch (IllegalArgumentException ex) {
		      ex.printStackTrace();
		      session.rollback();
		          } catch (IOException ex) {
		      ex.printStackTrace();
		      
		    } catch (Exception ex) {
		      ex.printStackTrace();
		      
		      session.rollback();
		    } finally {
		      if (session != null) {
		        session.close();
		      }
		    }
		    return result;
	}

}
