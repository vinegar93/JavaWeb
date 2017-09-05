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
		 * 1����ȡSession
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
		 * 2������MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("vinegar93@163.com"));//���÷�����	
		msg.addRecipients(RecipientType.TO, "345151175@qq.com");//�����ռ���
		msg.setSubject("����");
		msg.setText("����", "utf-8");
		/**
		 * 3�������ʼ�
		 */
		Transport.send(msg);
	}
	
	@Test
	public void test2() throws AddressException, MessagingException, IOException {
		/**
		 * 1����ȡSession
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
		 * 2������MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("vinegar93@163.com"));//���÷�����	
		msg.addRecipients(RecipientType.TO, "345151175@qq.com");//�����ռ���
		msg.setSubject("����");
		MimeMultipart list = new MimeMultipart();//MimeMultipart��һ�����ϣ�����װ�����岿��
		MimeBodyPart part1 = new MimeBodyPart();//MimeBodyPart�����岿��
		part1.setContent("����", "text/html;charset=utf-8");
		list.addBodyPart(part1);
		MimeBodyPart part2 = new MimeBodyPart();
		part2.attachFile("F:/è.jpg");//���ø�������
		part2.setFileName(MimeUtility.encodeText("����.jpg"));//������ʾ�ĸ������ƣ�����encodeText����������������
		list.addBodyPart(part2);
		msg.setContent(list);
		/**
		 * 3�������ʼ�
		 */
		Transport.send(msg);
	}

}
