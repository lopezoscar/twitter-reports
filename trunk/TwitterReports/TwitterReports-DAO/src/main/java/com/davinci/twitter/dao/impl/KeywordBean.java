package com.davinci.twitter.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionRequiredException;

import org.springframework.transaction.annotation.Transactional;

import com.davinci.twitter.dao.interfaces.KeywordManager;
import com.davinci.twitter.model.Keyword;

public class KeywordBean implements KeywordManager{
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public Keyword create(Keyword entity) throws EntityExistsException,
			IllegalStateException, IllegalArgumentException,
			TransactionRequiredException {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}
	
	@Transactional
	public Keyword read(Serializable primaryKey) throws IllegalStateException,
			IllegalArgumentException {
		// TODO Auto-generated method stub
		Keyword keyword = em.find(Keyword.class, primaryKey);
		return keyword;
	}
	
	@Transactional
	public Keyword update(Keyword entity) throws IllegalStateException,
			IllegalArgumentException, TransactionRequiredException {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
	}
	
	@Transactional
	public void delete(Keyword entity) throws IllegalStateException,
			IllegalArgumentException, TransactionRequiredException,
			PersistenceException {
		em.remove(entity);
		
	}

}
