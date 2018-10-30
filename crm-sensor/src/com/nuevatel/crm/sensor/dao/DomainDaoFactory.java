package com.nuevatel.crm.sensor.dao;

import com.nuevatel.crm.sensor.model.Domain;

public class DomainDaoFactory {

	public static DomainDao getDomain() {
		return new DomainDao();
	}

	public static Domain retreive(Domain domain) {
		return getDomain().retrieve(domain);
	}
}
