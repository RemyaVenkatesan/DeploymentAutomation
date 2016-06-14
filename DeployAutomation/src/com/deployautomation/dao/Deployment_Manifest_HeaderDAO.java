package com.deployautomation.dao;


	import java.sql.SQLException;
import java.util.List;

import com.deployautomation.model.Deployment_Manifest_Header;

	

	public interface Deployment_Manifest_HeaderDAO {
		
		boolean insertHeader(Deployment_Manifest_Header header) throws SQLException;
		
		boolean updateHeader(Deployment_Manifest_Header header) throws SQLException;
		
		boolean deleteHeader(Deployment_Manifest_Header header) throws SQLException;
		
		Deployment_Manifest_Header viewHeaderbyDeploymentId(int deploymentId) throws SQLException;
		
		List<Deployment_Manifest_Header> viewHeader() throws SQLException;

	}


