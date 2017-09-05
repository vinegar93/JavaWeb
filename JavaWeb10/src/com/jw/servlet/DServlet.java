package com.jw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().write("Scheme:" + request.getScheme());
		response.getWriter().write(";ServerName:" + request.getServerName());
		response.getWriter().write(";ServerPort:" + request.getServerPort());
		response.getWriter().write(";ContextPath:" + request.getContextPath());
		response.getWriter().write(";ServletPath:" + request.getServletPath());
		response.getWriter().write(";Query:" + request.getQueryString());
		response.getWriter().write(";URI:" + request.getRequestURI());
		response.getWriter().write(";URL:" + request.getRequestURL());
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
	}
}
