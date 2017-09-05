package com.jw.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class AServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 上传三步
		 * 1、创建工厂
		 * 2、创建解析器
		 * 3、使用解析器来解析request，得到FileItem集合
		 */
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			for (FileItem fi : fileItemList) {
				//是否为普通表单项，返回true为普通表单项，如果为false即文件表单项
				if (fi.isFormField()) {
					String name = fi.getFieldName();//表单项名称
					System.out.println(name);
					String value = fi.getString("utf-8");//表单项值
					System.out.println(value);
				} else {
					String contentType = fi.getContentType();//上传文件MIME类型
					System.out.println(contentType);
					long size = fi.getSize();//上传文件字节数
					System.out.println(size);
					String filename = fi.getName();//上传文件名称
					System.out.println(filename);
					File file = new File("F:/" + filename);
					fi.write(file);//把上传的文件内容保存到指定的文件中
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
