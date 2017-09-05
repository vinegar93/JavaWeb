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
		 * �ϴ�����
		 * 1����������
		 * 2������������
		 * 3��ʹ�ý�����������request���õ�FileItem����
		 */
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		try {
			List<FileItem> fileItemList = sfu.parseRequest(request);
			for (FileItem fi : fileItemList) {
				//�Ƿ�Ϊ��ͨ�������trueΪ��ͨ������Ϊfalse���ļ�����
				if (fi.isFormField()) {
					String name = fi.getFieldName();//��������
					System.out.println(name);
					String value = fi.getString("utf-8");//����ֵ
					System.out.println(value);
				} else {
					String contentType = fi.getContentType();//�ϴ��ļ�MIME����
					System.out.println(contentType);
					long size = fi.getSize();//�ϴ��ļ��ֽ���
					System.out.println(size);
					String filename = fi.getName();//�ϴ��ļ�����
					System.out.println(filename);
					File file = new File("F:/" + filename);
					fi.write(file);//���ϴ����ļ����ݱ��浽ָ�����ļ���
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
