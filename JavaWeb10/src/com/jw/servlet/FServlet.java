package com.jw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * ÏìÓ¦±àÂë
		 */
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");//»òresponse.setHeader("Content-Type", "text/html;charset=utf-8");
		response.getWriter().println("ÄúºÃ");
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
	}
}
