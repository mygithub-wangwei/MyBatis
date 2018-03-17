package com.dqsy.spring.jdbctemplate.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dqsy.spring.jdbctemplate.dao.IUserDao;
import com.dqsy.spring.jdbctemplate.entity.User;
	@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean addUser(User user) {
		boolean flag = false;
		String addsql = "insert into user(name, account) values(?, ?)";
		int rows = this.jdbcTemplate.update(addsql, user.getName(), user.getAccount());
		if(rows > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String delsql = "delete from user where id=?";
		int rows = this.jdbcTemplate.update(delsql, id);
		if(rows > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String uptsql = "update user set name=?,account=? where id=?";
		int rows = this.jdbcTemplate.update(uptsql, user.getName(), user.getAccount(), user.getId());
		
		if(rows > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		String querysql = "select id,name,account from user";
		//匿名内部类,转换成User对象
		return this.jdbcTemplate.query(querysql, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAccount(rs.getBigDecimal("account"));
				return null;
			}
			
		});
	}

}
