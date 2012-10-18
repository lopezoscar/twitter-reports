package com.davinci.twitter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="keywords")
public class Keyword {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="key_id")
	private Long id;
	
	@Column(name="key_text")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="proj_id")
	private Project project;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	

}
