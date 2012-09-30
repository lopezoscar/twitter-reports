package com.davinci.twitter.test;

import org.junit.Test;

import com.davinci.twitter.model.Keyword;

public class KeywordTest extends BaseTest{
	
	@Test
	public void test(){
		Keyword keyword = new Keyword();
		keyword.setName("Lanata");
		em.persist(keyword);
	}

}
