package com.davinci.twitter.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionRequiredException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.davinci.twitter.dao.interfaces.ProjectManager;
import com.davinci.twitter.dao.interfaces.StatusManager;
import com.davinci.twitter.model.Project;
import com.davinci.twitter.model.StatusCode;

@Path("/projectsrv")
@Component
public class ProjectService {
	
	@Autowired
	private ProjectManager projectManager;
	
	@Autowired
	private StatusManager statusManager;
	
	@GET
	@Path("/getprojectbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Project getProjectById(@PathParam("id")Long id){
		Project project = projectManager.read(id);
		return project;
	}
	
	@GET
	@Path("/createproject/{name}")
//	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProject(@PathParam("name")String projectName){
		try {
			Project project = new Project();
			project.setProjectName(projectName);
			project.setProjectAdd(new Date());
			
			project = projectManager.create(project);
			
			
			return Response.ok(project).header("Access-Control-Allow-Origin", "*").build();
			
		} catch (EntityExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			return statusManager.read(2);
		} catch (TransactionRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			return statusManager.read(2);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			return statusManager.read(2);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			return statusManager.read(2);
		}
		
//		return statusManager.read(1);
		return Response.ok().build();
	}
	
	
	@POST
	@Path("/updateproject")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public StatusCode updateProject(Project project){
		try {
			projectManager.update(project);
			
			
		} catch (TransactionRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return statusManager.read(2);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return statusManager.read(2);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return statusManager.read(2);
		}
		
		return statusManager.read(1);
	}
	
	@GET
	@Path("/deleteproject")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public StatusCode deleteProject(Project project){
		try {
			
			projectManager.delete(project);
			
		} catch (TransactionRequiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return statusManager.read(2);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return statusManager.read(2);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return statusManager.read(2);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return statusManager.read(2);
		}
		return statusManager.read(1);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getallprojects")
	public List<Project> getAllProjects(){
		return projectManager.getAllProjects();
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	
	
	
	

}
