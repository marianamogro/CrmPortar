package com.nuevatel.crm.sensor.port.dao;

import java.util.List;

import com.nuevatel.crm.sensor.port.model.ParamIn;
import com.nuevatel.crm.sensor.port.model.Port;

public interface IPortDao {
 public List<Port> retrieve(ParamIn paramIn);
	
}
