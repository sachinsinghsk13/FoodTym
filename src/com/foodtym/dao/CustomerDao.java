package com.foodtym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.foodtym.beans.Customer;

public class CustomerDao {
	private Properties sql;
	private BasicDataSource dataSource;
	
	public CustomerDao(Properties sql, BasicDataSource dataSource) {
		this.sql = sql;
		this.dataSource = dataSource;
	}
	
	public boolean isCustomerExist(String mobile) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql.getProperty("CHECK_CUSTOMER_EXISTANCE"));
		statement.setString(1, mobile);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}
	
	public void insertCustomer(Customer customer) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql.getProperty("INSERT_CUSTOMER"));
		statement.setString(1, customer.getName());
		statement.setString(2, customer.getMobile());
		statement.setString(3, customer.getPassword());
		statement.executeUpdate();
	}
	
	public Customer checkLogin(String mobile, String password) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql.getProperty("CHECK_CUSTOMER_LOGIN"));
		statement.setString(1, mobile);
		statement.setString(2, password);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			Customer customer = new Customer();
			customer.setName(resultSet.getString(1));
			customer.setMobile(resultSet.getString(2));
			return customer;
		}
		return null;
	}
	
}
