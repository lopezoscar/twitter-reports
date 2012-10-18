package com.davinci.twitter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Errors")
public class StatusCode {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="error_id")
	private Integer id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status_code")
	private Integer statusCode;
	
	public StatusCode(){}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	
	
}
