package com.lee.protgresql.base;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 数据库连接类
 * @author jack
 * @since 2017/10/13 15:41
 */
@Component
public class DBControl
{
	private  Logger logger = LoggerFactory.getLogger(getClass());

	//main数据源
	private  DataSource dataSource;

    @Value("${pg.driverClassName}")
    private String driverClassName;

    @Value("${pg.url}")
    private String url;

    @Value("${pg.username}")
    private String username;

    @Value("${pg.password}")
    private String password;

    @Value("${pg.filters}")
    private String filters;

    @Value("${pg.maxActive}")
    private String maxActive;

    @Value("${pg.initialSize}")
    private String initialSize;

    @Value("${pg.maxWait}")
    private String maxWait;

    @Value("${pg.minIdle}")
    private String minIdle;

    @Value("${pg.timeBetweenEvictionRunsMillis}")
    private String timeBetweenEvictionRunsMillis;

    @Value("${pg.minEvictableIdleTimeMillis}")
    private String minEvictableIdleTimeMillis;

    @Value("${pg.validationQuery}")
    private String validationQuery;

    @Value("${pg.testWhileIdle}")
    private String testWhileIdle;

    @Value("${pg.testOnBorrow}")
    private String testOnBorrow;

    @Value("${pg.testOnReturn}")
    private String testOnReturn;

    @Value("${pg.maxOpenPreparedStatements}")
    private String maxOpenPreparedStatements;

    @Value("${pg.removeAbandoned}")
    private String removeAbandoned;

    @Value("${pg.removeAbandonedTimeout}")
    private String removeAbandonedTimeout;

    @Value("${pg.logAbandoned}")
    private String logAbandoned;


    @PostConstruct
    public void init(){
        try{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("driverClassName",driverClassName);
            map.put("url",url);
            map.put("username",username);
            map.put("password",password);
            map.put("filters",filters);
            map.put("maxActive",maxActive);
            map.put("initialSize",initialSize);
            map.put("maxWait",maxWait);
            map.put("minIdle",minIdle);
            map.put("timeBetweenEvictionRunsMillis",timeBetweenEvictionRunsMillis);
            map.put("minEvictableIdleTimeMillis",minEvictableIdleTimeMillis);
            map.put("validationQuery",validationQuery);
            map.put("testWhileIdle",testWhileIdle);
            map.put("testOnBorrow",testOnBorrow);
            map.put("testOnReturn",testOnReturn);
            map.put("maxOpenPreparedStatements",maxOpenPreparedStatements);
            map.put("removeAbandoned",removeAbandoned);
            map.put("removeAbandonedTimeout",removeAbandonedTimeout);
            map.put("logAbandoned",logAbandoned);
            dataSource = DruidDataSourceFactory.createDataSource(map);
        }catch(Exception ex){
            logger.error("",ex);
        }
    }


    /**
     * 获取main 库连接
     * @return
     * @throws Exception
     */
    public  Connection getConnection() throws Exception{
        return dataSource.getConnection();
    }



}
