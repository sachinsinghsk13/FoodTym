package com.foodtym.utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

@WebListener
public class DatabaseConnectionListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }


    public void contextInitialized(ServletContextEvent sce)  { 
    	Properties p = new Properties();
		BasicDataSource dataSource = new BasicDataSource();
		try {
			p.load(sce.getServletContext().getResourceAsStream("WEB-INF/appconfig/database.properties"));
			dataSource.setDriverClassName(p.getProperty("driver.classname"));
			dataSource.setUrl(p.getProperty("db.url"));
			dataSource.setUsername(p.getProperty("db.credentials.user"));
			dataSource.setPassword(p.getProperty("db.credentials.password"));
			int maxConnections = Integer.parseInt(p.getProperty("db.max-connections"));
			dataSource.setMaxTotal(maxConnections);
			dataSource.getConnection();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		sce.getServletContext().setAttribute("DataSource", dataSource);
		
		Properties sqlfile = new Properties();
		try {
			sqlfile.load(sce.getServletContext().getResourceAsStream("WEB-INF/sql_queries/sql.properties"));
			sce.getServletContext().setAttribute("SqlQueries", sqlfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        
    }
	
}
