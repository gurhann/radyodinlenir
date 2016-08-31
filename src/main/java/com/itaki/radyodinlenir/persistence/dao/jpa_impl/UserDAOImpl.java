package com.itaki.radyodinlenir.persistence.dao.jpa_impl;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.itaki.radyodinlenir.persistence.dao.UserDAO;
import com.itaki.radyodinlenir.persistence.model.User;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

	public UserDAOImpl() {
		setClazz(User.class);
	}

	@Override
	public User getUserByUserName(String userName) throws NoResultException {
		Query query = em.createNamedQuery(User.FIND_BY_USER_NAME).setParameter("userName", userName);
		return (User) query.getSingleResult();
	}
}
