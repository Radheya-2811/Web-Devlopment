package com.site.dao;

public interface UserDao {

	boolean isValidUser(String username, String password);

	 boolean addUser(NewUser user);
	
}
