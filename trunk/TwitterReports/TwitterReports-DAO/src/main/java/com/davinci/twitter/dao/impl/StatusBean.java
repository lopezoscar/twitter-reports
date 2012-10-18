package com.davinci.twitter.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionRequiredException;

import com.davinci.twitter.dao.interfaces.StatusManager;
import com.davinci.twitter.model.StatusCode;

public class StatusBean implements StatusManager{
	
	@PersistenceContext
	private EntityManager em;

	public StatusCode create(StatusCode entity) throws EntityExistsException,
			IllegalStateException, IllegalArgumentException,
			TransactionRequiredException {
		em.persist(entity);
		return entity;
	}

	public StatusCode read(Serializable primaryKey)
			throws IllegalStateException, IllegalArgumentException {
		// TODO Auto-generated method stub
		StatusCode errorCode = em.find(StatusCode.class, primaryKey);
		return errorCode;
	}

	public StatusCode update(StatusCode entity) throws IllegalStateException,
			IllegalArgumentException, TransactionRequiredException {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
	}

	public void delete(StatusCode entity) throws IllegalStateException,
			IllegalArgumentException, TransactionRequiredException,
			PersistenceException {
		// TODO Auto-generated method stub
		em.remove(entity);
	}

}
