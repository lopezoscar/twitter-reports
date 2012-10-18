package com.davinci.twitter.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.davinci.twitter.dao.interfaces.MongoDBManager;
import com.davinci.twitter.dao.interfaces.TwitterSearchManager;

public class TwitterSearchBean implements TwitterSearchManager{
	
	@Autowired
	private MongoDBManager mongoDb;
	
	
	
	public void searchKeyword(String keyword){
		StringBuilder sb = new StringBuilder();
		sb.append("http://search.twitter.com/search.json?q=");
		sb.append(keyword);
		String response = HTTPManager.get(sb.toString());
		mongoDb.insertCollection("tweets",response);
	}
	
	public String searchFollowersByAccountName(String accountName){
		StringBuilder sb = new StringBuilder();
		sb.append("http://api.twitter.com/1/followers/ids.json?cursor=-1&screen_name=");
		sb.append(accountName);
		String response = HTTPManager.get(sb.toString());
		return response;
	}

}
	