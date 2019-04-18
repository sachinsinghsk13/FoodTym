package com.foodtym.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.json.simple.JSONObject;

import com.foodtym.beans.Customer;
import com.foodtym.dao.CustomerDao;

@WebServlet(description = "Registraters a new customer to foodtym", urlPatterns = { "/CustomerRegistration" })
public class CustomerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties sql = (Properties) getServletContext().getAttribute("SqlQueries");
		BasicDataSource dataSource = (BasicDataSource) getServletContext().getAttribute("DataSource");
		
		CustomerDao dao = new CustomerDao(sql, dataSource);
		JSONObject res = new JSONObject();
		String mobileno = request.getParameter("mobileno");
		try {
			if (!dao.isCustomerExist(mobileno)) {
				String fullName = request.getParameter("fullname");
				String password = request.getParameter("password");
				Customer customer = new Customer();
				customer.setName(fullName);
				customer.setMobile(mobileno);
				customer.setPassword(password);
				dao.insertCustomer(customer);
				res.put("message", "Registration Successful");
				res.put("code", "1");
			}
			else {
				res.put("message", "User Already Exist");
				res.put("code", "2");
			}
			
			response.getWriter().print(res.toJSONString());
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
	}

}
