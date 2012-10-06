package com.davinci.twitter.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/projectsrv")
public class ProjectService {
	
	@GET
	@Path("/getprojectbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void getProjectById(@PathParam("id")Long id){
		System.out.println(id);
	}

}
