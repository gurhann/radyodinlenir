package com.itaki.radyodinlenir.persistence.dao.jpa_impl;

import org.springframework.stereotype.Repository;

import com.itaki.radyodinlenir.persistence.dao.AuthoritiesDAO;
import com.itaki.radyodinlenir.persistence.model.Authorities;

@Repository
public class AuthoritiesDAOImpl extends GenericDAOImpl<Authorities> implements AuthoritiesDAO {

	public AuthoritiesDAOImpl() {
		setClazz(Authorities.class);
	}
}
