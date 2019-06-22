package com.spring.springWeb.dao;

import java.util.List;

import com.spring.springWeb.model.User;

public interface UserDao {

	public User authenticate(User user);

	public List<User> list();

	public User getOneUser(Long id);

	public User save(User user);

	public void delete(Long id);

	
}
