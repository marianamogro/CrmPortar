/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuevatel.crm.sensor.db;

import org.apache.ibatis.session.SqlSessionFactory;

/**
 *
 * @author rquiroz
 */
public class DataSourceVo {

    private String resource;
    private SqlSessionFactory sqlSessionFactory;

    /**
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * @param resource the resource to set
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * @return the sqlSessionFactory
     */
    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    /**
     * @param sqlSessionFactory the sqlSessionFactory to set
     */
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}
