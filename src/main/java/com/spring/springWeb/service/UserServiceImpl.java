package com.spring.springWeb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springWeb.dao.UserDao;
import com.spring.springWeb.model.User;


  @Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public User authenticate(User user) {
//System.out.println("UserServiceImpl  : authenticate");
return userDao.authenticate(user);
	}

	public List<User> list() {
		return userDao.list();
	}

	public User getOneUser(Long id) {
		return userDao.getOneUser(id);
	}

	public User save(User user) {
		return userDao.save(user);
	}

	public void delete(Long id) {
		userDao.delete(id);
		
	}

}
