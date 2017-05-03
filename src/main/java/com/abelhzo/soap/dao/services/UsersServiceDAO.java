package com.abelhzo.soap.dao.services;

import java.util.List;

import com.abelhzo.jpa.User;

public interface UsersServiceDAO {
	
	public User saveUser(User user);
	public User updateUser(User user);
	public User getUser(User user);
	public List<User> listUsers();
	public User loginUser(User user);

}
