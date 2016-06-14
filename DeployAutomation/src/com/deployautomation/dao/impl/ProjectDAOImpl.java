package com.deployautomation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deployautomation.dao.ProjectDAO;
import com.deployautomation.model.Project;
import com.deployautomation.utility.impl.DatabaseConnectionImpl;



public class ProjectDAOImpl implements ProjectDAO {

	private Connection conn;
	private List<Project> list;

	public ProjectDAOImpl() throws ClassNotFoundException, SQLException
	{
		this.conn=DatabaseConnectionImpl.getInstance().dataBaseConnection();
		this.list=new ArrayList<Project>();
	}
	
	
	@Override
	public String findProjectName(int id) throws SQLException {
		// TODO Auto-generated method stub
		String projectName=null;
		
		PreparedStatement statement=conn.prepareStatement("select PROJECT_NAME from PROJECT where PROJECT_ID=?") ;
		statement.setInt(1,id);
		
		ResultSet set=statement.executeQuery();
		
		while(set.next())
		{
			projectName=set.getString("Project_Name");
		}
		
		set.close();
		statement.close();
		
		return projectName;
	}


	@Override
	public List<Project> projectNames() throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement statement=conn.prepareStatement("select PROJECT_ID,Project_Name,Project_Location from PROJECT");
		Project project=null;
		ResultSet set=statement.executeQuery();
		
		while(set.next())
		{
			project=new Project();
			
			project.setProject_id(set.getInt("Project_Id"));
			project.setProject_Name(set.getString("project_Name"));
			project.setProject_Location(set.getString("Project_Location"));
			
			list.add(project);
			
		}
		
		set.close();
		statement.close();
		return list;
	}

}
