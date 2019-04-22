package com.foodtym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.foodtym.beans.FoodItem;

public class FoodItemDao {
	private BasicDataSource dataSource;
	private Properties sql;
	
	public FoodItemDao(BasicDataSource dataSource, Properties sql) {
		this.dataSource = dataSource;
		this.sql = sql;
	}
	
	public List<FoodItem> getRestaurantFoodItems(int id) throws SQLException {
		List<FoodItem> list = new ArrayList<>();
		Connection connection = dataSource.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql.getProperty("GET_FOOD_ITEMS_OF_RESTAURANTS"));
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			FoodItem foodItem = new FoodItem();
			foodItem.setId(resultSet.getInt(1));
			foodItem.setPriceId(resultSet.getInt(2));
			foodItem.setTitle(resultSet.getString(3));
			foodItem.setType(resultSet.getString(4));
			foodItem.setPriceType(resultSet.getString(5));
			foodItem.setPrice(resultSet.getDouble(6));
			foodItem.setCategory(resultSet.getString(7));
			foodItem.setSubcategory(resultSet.getString(8));
			list.add(foodItem);
		}
		connection.close();
		return list;
	}
}











