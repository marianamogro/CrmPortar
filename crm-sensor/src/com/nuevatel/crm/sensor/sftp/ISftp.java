package com.nuevatel.crm.sensor.sftp;

public interface ISftp {
  public String getFile(String externalFileName, String localFileName);
  public String putFile(String fileName);
}
