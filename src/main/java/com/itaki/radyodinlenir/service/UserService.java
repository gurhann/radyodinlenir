package com.itaki.radyodinlenir.service;

import com.itaki.radyodinlenir.exception.UserNotFoundException;
import com.itaki.radyodinlenir.persistence.model.User;

public interface UserService {
	
	public User getUserByUserName(String userName) throws UserNotFoundException;
	
}
