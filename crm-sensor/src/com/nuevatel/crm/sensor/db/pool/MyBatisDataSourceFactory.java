/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuevatel.crm.sensor.db.pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

/**
 *
 * @author rquiroz
 */
public class MyBatisDataSourceFactory implements DataSourceFactory {

    private ComboPooledDataSource dataSource = null;

    public MyBatisDataSourceFactory() {
        System.setProperty("com.mchange.v2.log.MLog", "com.mchange.v2.log.FallbackMLog");
        //System.setProperty("com.mchange.v2.log.FallbackMLog.DEFAULT_CUTOFF_LEVEL", "OFF");
    }

    public void setProperties(Properties properties) {


        this.dataSource = new ComboPooledDataSource();
        this.dataSource.setPassword(properties.getProperty("password"));
        this.dataSource.setJdbcUrl(properties.getProperty("url"));
        try {
            this.dataSource.setDriverClass(properties.getProperty("driver"));
        } catch (PropertyVetoException e) {
        }
    }

    public DataSource getDataSource() {
        return (this.dataSource);

    }
}
