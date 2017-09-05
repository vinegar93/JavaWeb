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
		 * �ض���
		 * 1������302״̬��
		 * 2������Location��Ӧͷ
		 * ��ݷ�ʽ��response.sendRedirect("BServlet");
		 */
		response.setStatus(302);
		response.setHeader("Location", "BServlet");
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
	}
}
