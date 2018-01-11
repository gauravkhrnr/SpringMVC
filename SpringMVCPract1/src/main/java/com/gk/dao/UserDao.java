package com.gk.dao;

import com.gk.model.User;

public interface UserDao {

	int register(User user);
	User validateUser(User user);
}
