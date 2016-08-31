package com.itaki.radyodinlenir.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itaki.radyodinlenir.exception.UserNotFoundException;
import com.itaki.radyodinlenir.persistence.dao.UserDAO;
import com.itaki.radyodinlenir.persistence.model.User;
import com.itaki.radyodinlenir.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User getUserByUserName(String userName) throws UserNotFoundException {
		try {
			return userDAO.getUserByUserName(userName);
		}catch (Exception e) {
			throw new UserNotFoundException(userName);
		}
	}

}
