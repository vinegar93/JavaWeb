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
		 * 两个头一个流
		 * Content-Type：你传递给客户端的文件是什么MIME类型
		 * Content-Disposition：激活文件下载对话框，它的文件名为头中指定的文件名
		 * 流：要下载的文件数据
		 */
		String filename = "F:/cat.jpg";
		//通过文件类型获取MIME类型
		String contentType = this.getServletContext().getMimeType(filename);
		String contentDisposition = "attachment;filename=cat.jpg";
		//两个头
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);
		//一个流
		FileInputStream fis = new FileInputStream(filename);
		ServletOutputStream sos = response.getOutputStream();
		IOUtils.copy(fis, sos);
		fis.close();
	}

}
