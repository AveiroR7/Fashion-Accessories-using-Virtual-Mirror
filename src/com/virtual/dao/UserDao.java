package com.virtual.dao;

import com.virtual.bean.User;



public interface UserDao {
	boolean createUser(User user);
	boolean isAlreadyAvailable(User user);
	User selectUser(String email,String password);
}
