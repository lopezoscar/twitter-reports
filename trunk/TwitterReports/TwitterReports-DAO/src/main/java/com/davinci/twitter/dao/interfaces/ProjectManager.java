package com.davinci.twitter.dao.interfaces;


import java.util.List;

import com.davinci.twitter.model.Project;

public interface ProjectManager extends CRUD<Project>{

	 List<Project> getAllProjects();
	
}
