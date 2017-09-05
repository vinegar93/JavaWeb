package com.jw.test;

import java.util.List;

import com.jw.dao.UserDao;
import com.jw.domain.User;

public class Test {

	@org.junit.Test
	public void add() {
		
		User user = new User(3, "Diana", "123456");
		UserDao userDao = new UserDao();
		userDao.add(user);
	}
	
	@org.junit.Test
	public void delete() {
		
		int id = 3;
		UserDao userDao = new UserDao();
		userDao.delete(id);
	}
	
	@org.junit.Test
	public void update() {
		
		User user = new User(3, "borny", "789");
		UserDao userDao = new UserDao();
		userDao.update(user);
	}
	
	@org.junit.Test
	public void find() {
		
		int id = 3;
		UserDao userDao = new UserDao();
		User user = userDao.find(id);
		System.out.println(user.toString());
	}
	
	@org.junit.Test
	public void findAll() {
		
		UserDao userDao = new UserDao();
		List<User> users = userDao.findAll();
		System.out.println(users.toString());
	}
	
	@org.junit.Test
	public void count() {
		
		UserDao userDao = new UserDao();
		int count = userDao.count();
		System.out.println(count);
	}
}
