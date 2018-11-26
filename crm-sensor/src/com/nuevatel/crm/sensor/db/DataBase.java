/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuevatel.crm.sensor.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author rquiroz
 */
public class DataBase {

    private static Log log;
    /**
     * This class variable holds all dataSources that can be used by the application
     */
    private static HashMap<String, DataSourceVo> dataSource = new HashMap<String, DataSourceVo>();

    /**
     * This static block reads mybatis xml configuration
     */
    static {
        log = LogFactory.getLog(DataBase.class);

        DataSourceVo dataSourceVo = new DataSourceVo();
        dataSourceVo.setResource("./com/nuevatel/crm/sensor/db/mybatis-config.xml");
        dataSourceVo.setSqlSessionFactory(getSqlSessionFactory(dataSourceVo.getResource()));
        dataSource.put("PortDS", dataSourceVo);
        
        DataSourceVo dataSourceOraOdbBillingVo = new DataSourceVo();
        dataSourceOraOdbBillingVo.setResource("./com/nuevatel/crm/sensor/db/oracle_odb_billing-config.xml");
        dataSourceOraOdbBillingVo.setSqlSessionFactory(getOraBillingSqlSessionFactory(dataSourceOraOdbBillingVo.getResource()));
        dataSource.put("BillDS", dataSourceOraOdbBillingVo);
      
        DataSourceVo dataSourceOraOdbRepDwhVo = new DataSourceVo();
        dataSourceOraOdbRepDwhVo.setResource("./com/nuevatel/crm/sensor/db/oracle_odb_rep_dwh-config.xml");
        dataSourceOraOdbRepDwhVo.setSqlSessionFactory(getOraRepDwhSqlSessionFactory(dataSourceOraOdbRepDwhVo.getResource()));
        dataSource.put("RepDwhDS", dataSourceOraOdbRepDwhVo);
        
        DataSourceVo dataSourceOraIntDbVo = new DataSourceVo();
        dataSourceOraIntDbVo.setResource("./com/nuevatel/crm/sensor/db/oracle_intdb-config.xml");
        dataSourceOraIntDbVo.setSqlSessionFactory(getOraIntDbSqlSessionFactory(dataSourceOraIntDbVo.getResource()));
        dataSource.put("IntDbDS", dataSourceOraIntDbVo);
        
        DataSourceVo dataSourceOdbVo = new DataSourceVo();
        dataSourceOdbVo.setResource("./com/nuevatel/crm/sensor/db/oracle_odb-config.xml");
        dataSourceOdbVo.setSqlSessionFactory(getOraODBSqlSessionFactory(dataSourceOdbVo.getResource()));
        dataSource.put("OdbDS", dataSourceOdbVo);
        
        DataSourceVo dataSourcePostGresVo = new DataSourceVo();
        dataSourcePostGresVo.setResource("./com/nuevatel/crm/sensor/db/postgres_db-config.xml");
        dataSourcePostGresVo.setSqlSessionFactory(getPostGreSqlSessionFactory(dataSourcePostGresVo.getResource()));
        dataSource.put("PostGresDS", dataSourcePostGresVo);
        
        
    }

    private static void initMessage(String url) {
        System.out.println("+====================================+");
        System.out.println("|       CRM SENSOR v1.0     |");
        System.out.println("+====================================+");
        System.out.println("DataBase: " + url);
        log.debug("+====================================+");
        log.debug("|       CRM SENSOR v1.0     |");
        log.debug("+====================================+");
        log.debug("DataBase: " + url);
    }

    /**
     * It creates a SqlSessionFactory based on the HashMap data
     * @param resource  dataSource Name
     * @return
     */
    private static SqlSessionFactory getSqlSessionFactory(String resource) {
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        Properties properties = new Properties();
        String path = "./ora_port_database.properties";
        try {
            try {
                inputStream = new FileInputStream(path);
                properties.load(inputStream);
            } catch (IOException ioe) {
            }
            inputStream = Resources.getResourceAsStream(resource);
            // Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
            ComboPooledDataSource ds = (ComboPooledDataSource) sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
            ds.setUser(properties.getProperty("username"));
            initMessage(properties.getProperty("url"));
            return sqlSessionFactory;
        } catch (IOException ex) {
            log.error("Error DataSource", ex);
        } catch (Exception ex) {
        	log.error("Error DataSource", ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
            	log.error("Error DataSource", ex);
            }
        }
        return sqlSessionFactory;
    }

    /**
     * It creates a SqlSessionFactory based on the HashMap data
     * @param resource  dataSource Name
     * @return
     */
    private static SqlSessionFactory getOraBillingSqlSessionFactory(String resource) {
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        Properties properties = new Properties();
        String path = "./ora_bill_database.properties";
        try {
            try {
                inputStream = new FileInputStream(path);
                properties.load(inputStream);
            } catch (IOException ioe) {
            }
            inputStream = Resources.getResourceAsStream(resource);
            // Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
            ComboPooledDataSource ds = (ComboPooledDataSource) sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
            ds.setUser(properties.getProperty("username"));
            initMessage(properties.getProperty("url"));
            return sqlSessionFactory;
        } catch (IOException ex) {
        	log.error("Error DataSource", ex);
        } catch (Exception ex) {
        	log.error("Error DataSource", ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
            	log.error("Error DataSource", ex);
            }
        }
        return sqlSessionFactory;
    }     
    /**
     * It creates a SqlSessionFactory based on the HashMap data
     * @param resource  dataSource Name
     * @return
     */
    private static SqlSessionFactory getOraRepDwhSqlSessionFactory(String resource) {
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        Properties properties = new Properties();
        String path = "./ora_rep_dwh_database.properties";
        try {
            try {
                inputStream = new FileInputStream(path);
                properties.load(inputStream);
            } catch (IOException ioe) {
            }
            inputStream = Resources.getResourceAsStream(resource);
            // Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
            ComboPooledDataSource ds = (ComboPooledDataSource) sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
            ds.setUser(properties.getProperty("username"));
            initMessage(properties.getProperty("url"));
            return sqlSessionFactory;
        } catch (IOException ex) {
        	log.error("Error DataSource", ex);
        } catch (Exception ex) {
        	log.error("Error DataSource", ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
            	log.error("Error DataSource", ex);
            }
        }
        return sqlSessionFactory;
    } 
    
    /**
     * It creates a SqlSessionFactory based on the HashMap data
     * @param resource  dataSource Name
     * @return
     */
    private static SqlSessionFactory getOraIntDbSqlSessionFactory(String resource) {
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        Properties properties = new Properties();
        String path = "./ora_intdb_database.properties";
        try {
            try {
                inputStream = new FileInputStream(path);
                properties.load(inputStream);
            } catch (IOException ioe) {
            }
            inputStream = Resources.getResourceAsStream(resource);
            // Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
            ComboPooledDataSource ds = (ComboPooledDataSource) sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
            ds.setUser(properties.getProperty("username"));
            initMessage(properties.getProperty("url"));
            return sqlSessionFactory;
        } catch (IOException ex) {
        	log.error("Error DataSource", ex);
        } catch (Exception ex) {
        	log.error("Error DataSource", ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
            	log.error("Error DataSource", ex);
            }
        }
        return sqlSessionFactory;
    } 
    /**
     * It creates a SqlSessionFactory based on the HashMap data
     * @param resource  dataSource Name
     * @return
     */
    private static SqlSessionFactory getOraODBSqlSessionFactory(String resource) {
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        Properties properties = new Properties();
        String path = "./ora_odb_database.properties";
        try {
            try {
                inputStream = new FileInputStream(path);
                properties.load(inputStream);
            } catch (IOException ioe) {
            }
            inputStream = Resources.getResourceAsStream(resource);
            // Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
            ComboPooledDataSource ds = (ComboPooledDataSource) sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
            ds.setUser(properties.getProperty("username"));
            initMessage(properties.getProperty("url"));
            return sqlSessionFactory;
        } catch (IOException ex) {
        	log.error("Error DataSource", ex);
        } catch (Exception ex) {
        	log.error("Error DataSource", ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
            	log.error("Error DataSource", ex);
            }
        }
        return sqlSessionFactory;
    }
    /**
     * It creates a SqlSessionFactory based on the HashMap data
     * @param resource  dataSource Name
     * @return
     */
    private static SqlSessionFactory getPostGreSqlSessionFactory(String resource) {
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        Properties properties = new Properties();
        String path = "./postgres_database.properties";
        try {
            try {
                inputStream = new FileInputStream(path);
                properties.load(inputStream);
            } catch (IOException ioe) {
            }
            inputStream = Resources.getResourceAsStream(resource);
            // Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
            ComboPooledDataSource ds = (ComboPooledDataSource) sqlSessionFactory.getConfiguration().getEnvironment().getDataSource();
            ds.setUser(properties.getProperty("username"));
            initMessage(properties.getProperty("url"));
            return sqlSessionFactory;
        } catch (IOException ex) {
        	log.error("Error DataSource", ex);
        } catch (Exception ex) {
        	log.error("Error DataSource", ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
            	log.error("Error DataSource", ex);
            }
        }
        return sqlSessionFactory;
    } 

    /**
     * It opens a DataBase session based on the dataSource name
     * @param dataSourceName
     * @return
     * @throws IOException
     */
    public static SqlSession getSession(String dataSourceName) throws IOException {
        return dataSource.get(dataSourceName).getSqlSessionFactory().openSession();
    }
}
