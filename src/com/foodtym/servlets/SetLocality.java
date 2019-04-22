package com.foodtym.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.foodtym.beans.CustomerInfoBean;
import com.foodtym.beans.Location;

@WebServlet("/SetLocality")
public class SetLocality extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int localityid = Integer.parseInt(request.getParameter("localityid"));
		Properties sql = (Properties) getServletContext().getAttribute("SqlQueries");
		BasicDataSource dataSource = (BasicDataSource) getServletContext().getAttribute("DataSource");
		
		
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql.getProperty("GET_LOCALITY"));
			statement.setInt(1, localityid);
			ResultSet resultSet = statement.executeQuery();
			Location location = new Location();
			location.setId(localityid);
			if (resultSet.next()) {
				location.setLocality(resultSet.getString(3));
				location.setRegion(resultSet.getString(2));
			}
			
			HttpSession session = request.getSession();
			CustomerInfoBean customerInfoBean = (CustomerInfoBean) session.getAttribute("customerinfobean");
			customerInfoBean.setLocation(location);
			response.sendRedirect(request.getContextPath() + "/Restaurants");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
