package com.spring.springWeb.service;

import java.util.List;

import com.spring.springWeb.model.User;

public interface UserService {
public User authenticate(User user);

public List<User> list();

public User getOneUser(Long id);

public User save(User user);

public void delete(Long id);
}
