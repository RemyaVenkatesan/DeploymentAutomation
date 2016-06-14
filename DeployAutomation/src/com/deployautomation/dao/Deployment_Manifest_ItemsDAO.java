package com.deployautomation.dao;


	
	
	import java.sql.SQLException;
import java.util.List;

import com.deployautomation.model.Deployment_Manifest_Items;

	

	public interface Deployment_Manifest_ItemsDAO {
		
		boolean insertItems(Deployment_Manifest_Items items) throws SQLException;
		
		boolean updateItems(Deployment_Manifest_Items items) throws SQLException;
		
		boolean deleteItems(Deployment_Manifest_Items items) throws SQLException;
		
		List<Deployment_Manifest_Items> viewItems(int deploymentId) throws SQLException;

	}


