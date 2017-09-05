package com.jw.test;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;

public class EmailTest {

	@Test
	public void test1() throws AddressException, MessagingException {
		/**
		 * 1、获取Session
		 */
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("vinegar93@163.com", "123456");
			}
		};
		Session session = Session.getDefaultInstance(prop, auth);
		/**
		 * 2、创建MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("vinegar93@163.com"));//设置发件人	
		msg.addRecipients(RecipientType.TO, "345151175@qq.com");//设置收件人
		msg.setSubject("主题");
		msg.setText("内容", "utf-8");
		/**
		 * 3、发送邮件
		 */
		Transport.send(msg);
	}
	
	@Test
	public void test2() throws AddressException, MessagingException, IOException {
		/**
		 * 1、获取Session
		 */
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("vinegar93@163.com", "123456");
			}
		};
		Session session = Session.getDefaultInstance(prop, auth);
		/**
		 * 2、创建MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("vinegar93@163.com"));//设置发件人	
		msg.addRecipients(RecipientType.TO, "345151175@qq.com");//设置收件人
		msg.setSubject("主题");
		MimeMultipart list = new MimeMultipart();//MimeMultipart是一个集合，用来装载主体部件
		MimeBodyPart part1 = new MimeBodyPart();//MimeBodyPart是主体部件
		part1.setContent("内容", "text/html;charset=utf-8");
		list.addBodyPart(part1);
		MimeBodyPart part2 = new MimeBodyPart();
		part2.attachFile("F:/猫.jpg");//设置附件内容
		part2.setFileName(MimeUtility.encodeText("喵喵.jpg"));//设置显示的附件名称，其中encodeText处理中文乱码问题
		list.addBodyPart(part2);
		msg.setContent(list);
		/**
		 * 3、发送邮件
		 */
		Transport.send(msg);
	}

}
