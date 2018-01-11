package com.gk.mapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.gk.model.User;

public class UserMapper implements RowMapper {

	public User mapRow(ResultSet resultSet, int arg1) throws SQLException {
		
		 User user = new User();
		
		 user.setUsername(resultSet.getString("username"));
		 user.setPassword(resultSet.getString("password"));
		 user.setFirstname(resultSet.getString("firstname"));
		 user.setLastname(resultSet.getString("lastname"));
		 user.setEmail(resultSet.getString("email"));
		 user.setAddress(resultSet.getString("address"));
		 user.setPhone(resultSet.getLong("phone"));
		
		return user;
	}

	

}
