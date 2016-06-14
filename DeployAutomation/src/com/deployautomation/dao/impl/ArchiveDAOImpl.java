package com.deployautomation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.deployautomation.dao.ArchiveDAO;
import com.deployautomation.utility.impl.DatabaseConnectionImpl;


public class ArchiveDAOImpl implements ArchiveDAO{

	private Connection conn;
	
	public ArchiveDAOImpl() throws ClassNotFoundException, SQLException
	{
		this.conn=DatabaseConnectionImpl.getInstance().dataBaseConnection();
	}
	
	@Override
	public boolean archiveValueUpdate(int deploymentId) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement statement=conn.prepareStatement("update Deployment_Manifest_Header SET Archive_Flag=? Where Deployment_Id=? ");
		statement.setInt(1,1);
		statement.setInt(2,deploymentId);
		
		statement.executeUpdate();
		
		statement.close();
		return true;
	
	}

}
