package com.jw.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AFilter implements Filter {

	public void destroy() {
		
		System.out.println("����");
	}

	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {

		System.out.println("����ǰ");
		chain.doFilter(request, response);//���У�
		System.out.println("���غ�");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		System.out.println("��ʼ");
	}
}
