package com.nuevatel.crm.sensor.port.dao;

import java.util.List;

import com.nuevatel.crm.sensor.port.model.CashBoxProcess;
import com.nuevatel.crm.sensor.port.model.ParamIn;

public interface ICashBoxProcessDao {

	public List<CashBoxProcess> retrieve(ParamIn paramIn);
}
