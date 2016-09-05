package com.itaki.radyodinlenir.persistence.dao.jpa_impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.itaki.radyodinlenir.persistence.dao.GenericDAO;

public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	private Class<T> clazz;

	@PersistenceContext
	EntityManager em;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@Override
	public T findOne(long id) {
		return em.find(clazz, id);
	}

	@Override
	public T findOne(int id) {
		return em.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return em.createQuery("from " + clazz.getName()).getResultList();
	}

	@Transactional
	@Override
	public void create(T entity) {
		em.persist(entity);
	}

	@Transactional
	@Override
	public T update(T entity) {
		return em.merge(entity);
	}

	@Transactional
	@Override
	public void delete(T entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Transactional
	@Override
	public void deleteById(long id) {
		T entity = em.find(clazz, id);
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public int getRowCount() {
		return ((Long) em.createQuery("select count(d.id) from " + clazz.getName() + " d").getSingleResult()).intValue();
	}

}
