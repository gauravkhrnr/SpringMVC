package com.gk.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jca.cci.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import com.gk.mapper.UserMapper;
import com.gk.model.User;

public class UserDaoImpl implements UserDao{

	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	public int register(User user) {
	
		try {
			 if(user!=null)
			 {
				 String sql = "insert into users values(?,?,?,?,?,?,?)";
				 if(!user.getUsername().equals(" ") && !user.getPassword().equals(" ") && !user.getFirstname().equals(" ") &&
				    !user.getLastname().equals(" ") && !user.getEmail().equals(" ") && !user.getAddress().equals(" ") && 
				     user.getPhone()!= 0)
				 {
					 jdbcTemplate.update(sql,new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
							 user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
					 return 1;
				 }
			 }
			 return 0;
			 
		}catch(InvalidResultSetAccessException  ex) {
			return 0;
		}catch(DataAccessException ex) {
			return 0;
		}
	}

	public User validateUser(User user) {
		
		return null;
	}

}
