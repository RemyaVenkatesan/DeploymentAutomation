package com.deployautomation.dao;

import java.sql.SQLException;
import java.util.List;

import com.deployautomation.model.Project;



public interface ProjectDAO {

	public String findProjectName(int id) throws SQLException;
	
	public List<Project> projectNames() throws SQLException;
}
