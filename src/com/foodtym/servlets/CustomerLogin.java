package com.foodtym.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.json.simple.JSONObject;

import com.foodtym.beans.Customer;
import com.foodtym.beans.CustomerInfoBean;
import com.foodtym.dao.CustomerDao;

@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties sql = (Properties) getServletContext().getAttribute("SqlQueries");
		BasicDataSource dataSource = (BasicDataSource) getServletContext().getAttribute("DataSource");
		CustomerDao dao = new CustomerDao(sql, dataSource);
		
		String mobile = request.getParameter("mobileno");
		String password = request.getParameter("password");
		
		try {
			Customer customer = dao.checkLogin(mobile, password);
			JSONObject object = new JSONObject();
			if (customer != null) {
				HttpSession session = request.getSession();
				CustomerInfoBean bean = (CustomerInfoBean) session.getAttribute("customerinfobean");
				bean.setCustomer(customer);
				object.put("message", "Login Successful");
				object.put("code", "1");
			}
			else {
				object.put("message", "Login Failed");
				object.put("code", "2");
			}
			response.getWriter().println(object.toJSONString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
