package com.davinci.twitter.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="proj_id")
	private Long id;
	
	@Column(name="proj_name")
	private String projectName;
	
	@Column(name="proj_add")
	private Date projectAdd;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private List<Keyword> keywords;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getProjectAdd() {
		return projectAdd;
	}

	public void setProjectAdd(Date projectAdd) {
		this.projectAdd = projectAdd;
	}

	public List<Keyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}
	
	
	

}
