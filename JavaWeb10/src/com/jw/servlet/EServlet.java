package com.jw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		byte[] bytes = name.getBytes("iso-8859-1");//根据指定的编码返回某字符串在该编码下的字节数组
		name = new String(bytes, "utf-8");//使用指定的编码来将字节数组解析成字符串
		System.out.println(name);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");//服务器指定编码
		String name = request.getParameter("name");
		System.out.println(name);
	}
}
