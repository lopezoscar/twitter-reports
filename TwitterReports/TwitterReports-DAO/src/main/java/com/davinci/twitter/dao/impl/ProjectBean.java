package com.davinci.twitter.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionRequiredException;

import org.springframework.transaction.annotation.Transactional;

import com.davinci.twitter.dao.interfaces.ProjectManager;
import com.davinci.twitter.model.Project;

public class ProjectBean implements ProjectManager{
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public Project create(Project entity) throws EntityExistsException,
			IllegalStateException, IllegalArgumentException,
			TransactionRequiredException {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Transactional
	public Project read(Serializable primaryKey) throws IllegalStateException,
			IllegalArgumentException {
		// TODO Auto-generated method stub
		Project project = em.find(Project.class, primaryKey);
		return project;
	}

	@Transactional
	public Project update(Project entity) throws IllegalStateException,
			IllegalArgumentException, TransactionRequiredException {
		// TODO Auto-generated method stub
		em.merge(entity);
		return entity;
	}

	@Transactional
	public void delete(Project entity) throws IllegalStateException,
			IllegalArgumentException, TransactionRequiredException,
			PersistenceException {
		em.remove(entity);
		
	}

	@Transactional
	public List<Project> getAllProjects() {
		return em.createQuery("select p from Project").getResultList();
	}

}
