package com.jw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * 重定向
		 * 1、发送302状态码
		 * 2、设置Location响应头
		 * 快捷方式：response.sendRedirect("BServlet");
		 */
		response.setStatus(302);
		response.setHeader("Location", "BServlet");
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
	}
}
