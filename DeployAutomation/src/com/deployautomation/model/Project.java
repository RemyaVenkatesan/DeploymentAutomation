package com.deployautomation.model;

import java.util.List;

public class Project {

	private int project_id;
	private String project_Name;
	private String project_Location;
	
	
	
	
	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", project_Name="
				+ project_Name + ", project_Location=" + project_Location
				+ "]";
	}
	
	
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_Name() {
		return project_Name;
	}
	public void setProject_Name(String project_Name) {
		this.project_Name = project_Name;
	}
	public String getProject_Location() {
		return project_Location;
	}
	public void setProject_Location(String project_Location) {
		this.project_Location = project_Location;
	}
	
	
	
}
