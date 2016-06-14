package com.deployautomation.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.deployautomation.dao.Deployment_Manifest_HeaderDAO;
import com.deployautomation.model.Deployment_Manifest_Header;
import com.deployautomation.utility.impl.DatabaseConnectionImpl;



public class Deployment_Manifest_HeaderDAOImpl implements Deployment_Manifest_HeaderDAO {

	private Connection conn;
	private SequenceDAOImpl daoImpl;
	private List<Deployment_Manifest_Header> headerArray;

	public Deployment_Manifest_HeaderDAOImpl() throws ClassNotFoundException, SQLException
	{
		this.conn=DatabaseConnectionImpl.getInstance().dataBaseConnection();
		this.daoImpl=new SequenceDAOImpl();
		this.headerArray=new ArrayList<Deployment_Manifest_Header>();
	}

	
	@Override
	public boolean insertHeader(Deployment_Manifest_Header header)
			throws SQLException {
		// TODO Auto-generated method stub
		
		  java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    
		int deploymentId=daoImpl.headerSequence(conn);
		
		header.setDeployment_Id(deploymentId);
		header.setDeploy_Date(sqlDate);
		
		PreparedStatement statement=conn.prepareStatement("Insert into Deployment_Manifest_Header(Deployment_Name,Deployment_Id,Deploy_Date,Environment_Id,Tag,Archive_Flag) values(?,?,?,?,?,?)");
		statement.setString(1,header.getDeployment_Name());
		statement.setInt(2,header.getDeployment_Id());
		statement.setDate(3,(Date) header.getDeploy_Date());
		statement.setInt(4,header.getEnvironment_Id());
		statement.setString(5,header.getTag());
		statement.setInt(6,header.getArchive_Flag());
		
		statement.executeUpdate();
		conn.commit();
		//conn.close();
		statement.close();
		return true;
		
		
	
	}

	@Override
	public boolean updateHeader(Deployment_Manifest_Header header)
			throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement statement=conn.prepareStatement("update Deployment_Manifest_Header SET Deployment_Name=?,Environment_Id=?,Tag=? Where Deployment_Id=? ");
		statement.setString(1,header.getDeployment_Name());
		statement.setInt(2,header.getEnvironment_Id());
		statement.setString(3,header.getTag());
		statement.setInt(4,header.getDeployment_Id());
		
		statement.executeUpdate();
		conn.commit();

		statement.close();
		return true;
	}

	@Override
	public boolean deleteHeader(Deployment_Manifest_Header header)
			throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement statement=conn.prepareStatement("Delete from Deployment_Manifest_Header where Deployment_Id=?");
		statement.setInt(1,header.getDeployment_Id());
		statement.executeUpdate();
		conn.commit();
	//	conn.close();
		statement.close();
		return true;
	}

	@Override
	public Deployment_Manifest_Header viewHeaderbyDeploymentId(int deploymentId)
			throws SQLException {
		// TODO Auto-generated method stub
		Deployment_Manifest_Header header=new Deployment_Manifest_Header();
		
		PreparedStatement statement=conn.prepareStatement("select Deployment_Name,Deployment_Id,Deploy_Date,Environment_Id,Tag,Archive_Flag from Deployment_Manifest_Header where Deployment_Id=?");
		statement.setInt(1,deploymentId);
		
		ResultSet set=statement.executeQuery();
		
		while(set.next())
		{
			
		header.setDeployment_Name(set.getString(1));
		header.setDeployment_Id(set.getInt(2));
		header.setDeploy_Date(set.getDate(3));
		header.setEnvironment_Id(set.getInt(4));
		header.setTag(set.getString(5));
		header.setArchive_Flag(set.getInt(6));
			
		}
		conn.commit();
		set.close();
		statement.close();
		
		return header;
	}

	@Override
	public List<Deployment_Manifest_Header> viewHeader() throws SQLException {
		// TODO Auto-generated method stub
Deployment_Manifest_Header header;
		
		PreparedStatement statement=conn.prepareStatement("select Deployment_Name,Deployment_Id,Deploy_Date,Environment_Id,Tag,Archive_Flag from Deployment_Manifest_Header");
		
		
		ResultSet set=statement.executeQuery();
		
		while(set.next())
		{
			
			header=new Deployment_Manifest_Header();
			
		header.setDeployment_Name(set.getString(1));
		header.setDeployment_Id(set.getInt(2));
		header.setDeploy_Date(set.getDate(3));
		header.setEnvironment_Id(set.getInt(4));
		header.setTag(set.getString(5));
		header.setArchive_Flag(set.getInt(6));
		
		headerArray.add(header);
			
		}
		conn.commit();
		set.close();
		statement.close();
		
		return headerArray;
	}

}
