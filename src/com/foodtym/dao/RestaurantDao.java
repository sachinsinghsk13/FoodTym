package com.foodtym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.foodtym.beans.Location;
import com.foodtym.beans.Restaurant;

public class RestaurantDao {
	private BasicDataSource dataSource;
	private Properties sql;
	
	public RestaurantDao(BasicDataSource dataSource, Properties sql) {
		this.dataSource = dataSource;
		this.sql = sql;
	}
	
	public List<Restaurant> restaurantsAroundLocality(int id) throws SQLException {
		List<Restaurant> list = new ArrayList<>();
		Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql.getProperty("GET_RESTAURANTS_AROUND_LOCALITY"));
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			Restaurant restaurant = new Restaurant();
			restaurant.setId(resultSet.getInt(1));
			restaurant.setName(resultSet.getString(2));
			restaurant.setOpenTime(resultSet.getString(3));
			restaurant.setCloseTime(resultSet.getString(4));
			Location location = new Location();
			location.setRegion(resultSet.getString(5));
			location.setLocality(resultSet.getString(6));
			restaurant.setLocation(location);
			list.add(restaurant);
		}
		return list;
	}
	
	public Restaurant get_restaurant(int id) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql.getProperty("GET_RESTAURANT"));
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			Restaurant restaurant = new Restaurant();
			restaurant.setId(resultSet.getInt(1));
			restaurant.setName(resultSet.getString(2));
			restaurant.setOpenTime(resultSet.getString(3));
			restaurant.setCloseTime(resultSet.getString(4));
			restaurant.setAddress(resultSet.getString(5));
			restaurant.setMobileNumber(resultSet.getString(6));
			restaurant.setEmailAddress(resultSet.getString(7));
			return restaurant;
		}
		else {
			return null;
		}
	}
}
