package com.davinci.twitter.dao.impl;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.bson.BSON;
import org.bson.BSONObject;

import com.davinci.twitter.dao.interfaces.MongoDBManager;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

public class MongoDBBean implements MongoDBManager{

	public DB connect(){
		DB db = null;
		try {
			Mongo m = new Mongo( "localhost" , 27017 );
			db = m.getDB( "twitterreports" );
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return db;
	}

	public void insertCollection(String collectionName,String jsonResponse) {
		DB db = connect();
		DBCollection collection = db.getCollection(collectionName);
		Object o = JSON.parse(jsonResponse);
		DBObject dbObj = (DBObject) o;
		collection.save(dbObj);
	}
	

	
	

}
