package com.nuevatel.crm.sensor.port.dao;

import java.util.List;

import com.nuevatel.crm.sensor.port.model.IntDbLogMessages;
import com.nuevatel.crm.sensor.port.model.ParamIn;

public interface IIntDbLogMessagesDao {
	 public List<IntDbLogMessages> retrieve(ParamIn paramIn);
}
