package com.foodtym.filters;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyCustomResponse extends HttpServletResponseWrapper {

	public MyCustomResponse(HttpServletResponse response) {
		super(response);
	}
	
}
