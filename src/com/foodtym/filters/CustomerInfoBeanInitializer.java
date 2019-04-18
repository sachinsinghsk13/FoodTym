package com.foodtym.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.foodtym.beans.CustomerInfoBean;
import com.foodtym.beans.FoodCart;

@WebFilter("/*")
public class CustomerInfoBeanInitializer implements Filter {


	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// return only old session
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("customerinfobean") == null) { // this is a new session
			CustomerInfoBean customerInfoBean = new CustomerInfoBean();
			customerInfoBean.setCart(new FoodCart());
			session = req.getSession(); // creates a new session
			session.setAttribute("customerinfobean", customerInfoBean);
			System.out.println("customerinfobean added to session");
		}
		CustomerInfoBean bean = (CustomerInfoBean) session.getAttribute("customerinfobean");
		System.out.println(bean);
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
