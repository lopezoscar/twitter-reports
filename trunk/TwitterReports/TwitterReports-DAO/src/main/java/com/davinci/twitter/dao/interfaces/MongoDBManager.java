package com.davinci.twitter.dao.interfaces;

import com.mongodb.DB;

public interface MongoDBManager {
	
	public DB connect();
	
	public void insertCollection(String collectionName,String jsonResponse);

}
