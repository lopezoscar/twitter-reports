package com.davinci.twitter.services;

import javax.persistence.EntityExistsException;
import javax.transaction.TransactionRequiredException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.davinci.twitter.dao.interfaces.KeywordManager;
import com.davinci.twitter.dao.interfaces.ProjectManager;
import com.davinci.twitter.model.Keyword;
import com.davinci.twitter.model.Project;

@Path("/keywordsrv")
@Component
public class KeywordService {
	
	@Autowired
	KeywordManager keywordManager;
	
	@Autowired
	ProjectManager projectManager;
	
	@Path("/createkeyonproject/{projectid}/{keyname}")
	@GET
	public Response createProject(@PathParam("projectid")Long projectId,@PathParam("keyname")String keyname){
		Keyword keyword = new Keyword();
		keyword.setName(keyname);
		Project project = projectManager.read(projectId);
		keyword.setProject(project);
		try {
			
			keywordManager.create(keyword);
			
		} catch (EntityExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransactionRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.ok().build();
	}

	public KeywordManager getKeywordManager() {
		return keywordManager;
	}

	public void setKeywordManager(KeywordManager keywordManager) {
		this.keywordManager = keywordManager;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}
	
	
	

}
