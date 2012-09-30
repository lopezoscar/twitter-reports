package com.davinci.twitter.model;

import java.util.Date;

public class Tweet {
	
	private Long id;
	
	private Long resultId;
	
	private Long fromUserId;
	
	private String fromUser;
	
	private String fromUserName;
	
	private String profileImageUrl;
	
	private String tweetText;
	
	private String tweetKeyword;
	
	private String tweetSource;
	
	private Date tweetCreate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}

	public Long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public String getTweetKeyword() {
		return tweetKeyword;
	}

	public void setTweetKeyword(String tweetKeyword) {
		this.tweetKeyword = tweetKeyword;
	}

	public String getTweetSource() {
		return tweetSource;
	}

	public void setTweetSource(String tweetSource) {
		this.tweetSource = tweetSource;
	}

	public Date getTweetCreate() {
		return tweetCreate;
	}

	public void setTweetCreate(Date tweetCreate) {
		this.tweetCreate = tweetCreate;
	}
	
	

}
