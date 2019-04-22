package com.foodtym.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.foodtym.beans.FoodItem;
import com.foodtym.beans.Restaurant;
import com.foodtym.dao.FoodItemDao;
import com.foodtym.dao.RestaurantDao;

@WebServlet("/ViewRestaurant")
public class ViewRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("restaurantId"));
		
		BasicDataSource dataSource = (BasicDataSource) getServletContext().getAttribute("DataSource");
		Properties sql = (Properties) getServletContext().getAttribute("SqlQueries");
		
		FoodItemDao foodItemDao = new FoodItemDao(dataSource, sql);
		RestaurantDao restaurantDao = new RestaurantDao(dataSource, sql);
		try {
			List<FoodItem> list = foodItemDao.getRestaurantFoodItems(id);
			Restaurant restaurant = restaurantDao.get_restaurant(id);
			request.setAttribute("fooditems", list);
			request.setAttribute("rt", restaurant);
			request.getRequestDispatcher("ViewRestaurant.jsp").forward(request, response);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
