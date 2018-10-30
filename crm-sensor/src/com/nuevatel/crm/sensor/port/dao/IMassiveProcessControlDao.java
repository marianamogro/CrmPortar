package com.nuevatel.crm.sensor.port.dao;

import java.util.List;

import com.nuevatel.crm.sensor.port.model.MassiveProcessControl;
import com.nuevatel.crm.sensor.port.model.ParamIn;

public interface IMassiveProcessControlDao {
   public List<MassiveProcessControl> retrieve(ParamIn paramIn);
   
}
