package com.davinci.twitter.test;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.davinci.twitter.model.Keyword;
import com.davinci.twitter.model.Project;

public class ProjectTest extends BaseTest{
	
	@Test
	public void test(){
		Project project = new Project();
		project.setProjectName("Política");
		project.setProjectAdd(new Date());
		List<Keyword> keywords = em.createQuery("Select k from Keyword k").getResultList();
		project.setKeywords(keywords);
		
		em.persist(project);
		
		Assert.assertNotNull(project.getId());
		
	}

}
