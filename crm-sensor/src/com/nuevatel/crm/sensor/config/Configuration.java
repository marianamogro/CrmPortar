package com.nuevatel.crm.sensor.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	public static String ftpDirLocal = null;
	public static String ftpDirExtern = null;
	public static String ftpParamCron = null;

	public static void loadProperties() {
		try {
			Properties props = new Properties();
			FileInputStream file = new FileInputStream("./configuration.properties");
			props.load(file);
			ftpDirLocal = props.getProperty("ftp_dir_name_local");
			ftpDirExtern = props.getProperty("ftp_dir_name_extern");
			ftpParamCron =  props.getProperty("ftp_param_cron");
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
