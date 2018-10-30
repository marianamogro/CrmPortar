package com.nuevatel.crm.sensor.port.dao;

import com.nuevatel.crm.sensor.port.model.GwPortabilidad;

public interface IGwPortabilidadDao {
  public GwPortabilidad retrieve(GwPortabilidad gwPortabilidad);
  public void create(GwPortabilidad gwPortabilidad);
  public void backup(GwPortabilidad gwPortabilidad);
  public void truncateTable();
}
