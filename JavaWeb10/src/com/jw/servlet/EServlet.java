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
		byte[] bytes = name.getBytes("iso-8859-1");//����ָ���ı��뷵��ĳ�ַ����ڸñ����µ��ֽ�����
		name = new String(bytes, "utf-8");//ʹ��ָ���ı��������ֽ�����������ַ���
		System.out.println(name);
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");//������ָ������
		String name = request.getParameter("name");
		System.out.println(name);
	}
}
