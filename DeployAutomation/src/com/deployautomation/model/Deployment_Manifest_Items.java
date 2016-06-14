package com.deployautomation.model;

public class Deployment_Manifest_Items {
private int deployment_Id;
private int item_Id;
private int project_Id;
private int deployment_Order;
private String comments;
private String notes;
private Project project;
public int getDeployment_Id() {
	return deployment_Id;
}
public void setDeployment_Id(int deployment_Id) {
	this.deployment_Id = deployment_Id;
}
public int getItem_Id() {
	return item_Id;
}
public void setItem_Id(int item_Id) {
	this.item_Id = item_Id;
}
public int getProject_Id() {
	return project_Id;
}
public void setProject_Id(int project_Id) {
	this.project_Id = project_Id;
}
public int getDeployment_Order() {
	return deployment_Order;
}
public void setDeployment_Order(int deployment_Order) {
	this.deployment_Order = deployment_Order;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}
public Project getProject() {
	return project;
}
public void setProject(Project project) {
	this.project = project;
}
@Override
public String toString() {
	return "Deployment_Manifest_Items [deployment_Id=" + deployment_Id
			+ ", item_Id=" + item_Id + ", project_Id=" + project_Id
			+ ", deployment_Order=" + deployment_Order + ", comments="
			+ comments + ", notes=" + notes + ", project=" + project + "]";
}



}
