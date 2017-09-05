package com.jw.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jw.domain.User;

import cn.itcast.jdbc.TxQueryRunner;

public class UserDao {
	
	private QueryRunner qr = new TxQueryRunner();
	
	public void add(User user) {
		
		try {
			String sql = "insert into user values(?,?,?)";
			Object[] params = {
					user.getId(),
					user.getName(),
					user.getPassword()
			};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(int id) {
		
		try {
			String sql = "delete from user where id=?";
			Object[] params = { id };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(User user) {
		
		try {
			String sql = "update user set name=?,password=? where id=?";
			Object[] params = { 
					user.getName(),
					user.getPassword(),
					user.getId()
			};
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public User find(int id) {
		
		try {
			String sql = "select * from user where id=?";
			Object[] params = { id };
			return qr.query(sql, new BeanHandler<User>(User.class), params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<User> findAll() {
		
		try {
			String sql = "select * from user";
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int count() {
		
		try {
			String sql = "select count(*) from user";
			Object obj = qr.query(sql, new ScalarHandler());
			return Integer.parseInt(String.valueOf(obj));
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
