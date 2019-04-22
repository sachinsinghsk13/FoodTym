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
import javax.servlet.http.HttpSession;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.foodtym.beans.CustomerInfoBean;
import com.foodtym.beans.Restaurant;
import com.foodtym.dao.RestaurantDao;

@WebServlet("/Restaurants")
public class Restaurants extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerInfoBean bean = (CustomerInfoBean) session.getAttribute("customerinfobean");
		int location = bean.getLocation().getId();
		
		BasicDataSource dataSource = (BasicDataSource) getServletContext().getAttribute("DataSource");
		Properties sql = (Properties) getServletContext().getAttribute("SqlQueries");
		
		RestaurantDao restaurantDao = new RestaurantDao(dataSource, sql);
		
		try {
			List<Restaurant> restaurants = restaurantDao.restaurantsAroundLocality(location);
			request.setAttribute("restaurants", restaurants);
			request.getRequestDispatcher("Restaurants.jsp").forward(request, response);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
