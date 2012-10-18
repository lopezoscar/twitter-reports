package com.davinci.twitter.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.davinci.twitter.dao.interfaces.MongoDBManager;
import com.davinci.twitter.dao.interfaces.TwitterSearchManager;

@Path("/twittersrv")
@Component
public class TwitterSearchService {
	
	@Autowired
	private MongoDBManager mongo;

	@Autowired
	private TwitterSearchManager twitterManager;

	@GET
	@Path("/followersbyaccount/{account}")
	public Response searchFollowersByAccount(@PathParam("account")String account){
		String collectionName = "followers";
		String jsonResponse = twitterManager.searchFollowersByAccountName(account);
		mongo.insertCollection(collectionName, jsonResponse);
		return Response.ok().build();
	}

	public MongoDBManager getMongo() {
		return mongo;
	}

	public void setMongo(MongoDBManager mongo) {
		this.mongo = mongo;
	}

	public TwitterSearchManager getTwitterManager() {
		return twitterManager;
	}

	public void setTwitterManager(TwitterSearchManager twitterManager) {
		this.twitterManager = twitterManager;
	}
	
	
	
	
	
}
