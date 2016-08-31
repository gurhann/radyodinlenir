package com.itaki.radyodinlenir.persistence.dao;

import javax.persistence.NoResultException;

import com.itaki.radyodinlenir.persistence.model.User;

public interface UserDAO extends GenericDAO<User> {

	public User getUserByUserName(String userName) throws NoResultException;
}
