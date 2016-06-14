package com.deployautomation.model;

import java.util.Date;
import java.util.List;

public class Deployment_Manifest_Header
{
	private int deployment_Id;
	private String deployment_Name;
	private Date deploy_Date;
	private int environment_Id;
	private String tag;
	private int archive_Flag;
	private List<Deployment_Manifest_Items> items;
	
	
	public int getDeployment_Id() {
		return deployment_Id;
	}
	public void setDeployment_Id(int deployment_Id) {
		this.deployment_Id = deployment_Id;
	}
	public String getDeployment_Name() {
		return deployment_Name;
	}
	public void setDeployment_Name(String deployment_Name) {
		this.deployment_Name = deployment_Name;
	}
	public Date getDeploy_Date() {
		return deploy_Date;
	}
	public void setDeploy_Date(Date deploy_Date) {
		this.deploy_Date = deploy_Date;
	}
	public int getEnvironment_Id() {
		return environment_Id;
	}
	public void setEnvironment_Id(int environment_Id) {
		this.environment_Id = environment_Id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getArchive_Flag() {
		return archive_Flag;
	}
	public void setArchive_Flag(int archive_Flag) {
		this.archive_Flag = archive_Flag;
	}
	public List<Deployment_Manifest_Items> getItems() {
		return items;
	}
	public void setItems(List<Deployment_Manifest_Items> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Deployment_Manifest_Header [deployment_Id=" + deployment_Id
				+ ", deployment_Name=" + deployment_Name + ", deploy_Date="
				+ deploy_Date + ", environment_Id=" + environment_Id + ", tag="
				+ tag + ", archive_Flag=" + archive_Flag + ", items=" + items
				+ "]";
	}
	
	
	

}
