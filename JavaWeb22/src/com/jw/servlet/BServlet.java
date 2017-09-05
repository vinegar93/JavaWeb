package com.jw.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class BServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * ����ͷһ����
		 * Content-Type���㴫�ݸ��ͻ��˵��ļ���ʲôMIME����
		 * Content-Disposition�������ļ����ضԻ��������ļ���Ϊͷ��ָ�����ļ���
		 * ����Ҫ���ص��ļ�����
		 */
		String filename = "F:/cat.jpg";
		//ͨ���ļ����ͻ�ȡMIME����
		String contentType = this.getServletContext().getMimeType(filename);
		String contentDisposition = "attachment;filename=cat.jpg";
		//����ͷ
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);
		//һ����
		FileInputStream fis = new FileInputStream(filename);
		ServletOutputStream sos = response.getOutputStream();
		IOUtils.copy(fis, sos);
		fis.close();
	}

}
