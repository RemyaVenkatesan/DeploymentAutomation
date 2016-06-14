package com.deployautomation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deployautomation.dao.Deployment_Manifest_ItemsDAO;
import com.deployautomation.model.Deployment_Manifest_Items;
import com.deployautomation.model.Project;
import com.deployautomation.utility.impl.DatabaseConnectionImpl;



public class Deployment_Manifest_ItemsDAOImpl implements Deployment_Manifest_ItemsDAO {

	
	private Connection conn;
	private SequenceDAOImpl daoImpl;
	private ProjectDAOImpl projectDAOImpl;
	private List<Deployment_Manifest_Items> itemsArray; 		

	
	public Deployment_Manifest_ItemsDAOImpl() throws ClassNotFoundException, SQLException
	{
		this.conn=DatabaseConnectionImpl.getInstance().dataBaseConnection();
		this.daoImpl=new SequenceDAOImpl();
		this.projectDAOImpl=new ProjectDAOImpl();
		this.itemsArray=new ArrayList<Deployment_Manifest_Items>();

	}
	@Override
	public boolean insertItems(Deployment_Manifest_Items items)
			throws SQLException {
		// TODO Auto-generated method stub
			int itemId=daoImpl.itemSequence(conn);
		
		//	items.setProject_Id(projectId);
			items.setItem_Id(itemId);
			
			PreparedStatement statement=conn.prepareStatement("Insert into Deployment_Manifest_Items(Comments,Item_Id,Deployment_Id,Project_Id,Deployment_Order,Notes) values(?,?,?,?,?,?)");
			statement.setString(1,items.getComments());
			statement.setInt(2,items.getItem_Id());
			statement.setInt(3,items.getDeployment_Id());
			statement.setInt(4,items.getProject_Id());
			statement.setInt(5,items.getDeployment_Order());
			statement.setString(6,items.getNotes());
			statement.executeUpdate();
			conn.commit();
			
			statement.close();
			return true;
	}

	@Override
	public boolean updateItems(Deployment_Manifest_Items items)
			throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement statement=conn.prepareStatement("update Deployment_Manifest_Items SET Comments=?,Project_Id=?,Deployment_Order=?,Notes=? WHERE item_id=?");
		statement.setString(1,items.getComments());
		statement.setInt(2,items.getProject_Id());
		statement.setInt(3,items.getDeployment_Order());
		statement.setString(4,items.getNotes());
		statement.setInt(5,items.getItem_Id());
		
		
		statement.executeUpdate();
		conn.commit();
		statement.close();
		
		return true;
	}

	@Override
	public boolean deleteItems(Deployment_Manifest_Items items)
			throws SQLException {
		// TODO Auto-generated method stub
PreparedStatement statement=conn.prepareStatement("Delete from Deployment_Manifest_Items where Item_Id=?");
		
		statement.setInt(1,items.getItem_Id());
		statement.executeUpdate();
		
		statement.close();
		
		return true;
	}

	@Override
	public List<Deployment_Manifest_Items> viewItems(int deploymentId)
			throws SQLException {
		// TODO Auto-generated method stub
		Deployment_Manifest_Items items;
		
		PreparedStatement statement=conn.prepareStatement("select Comments,Item_Id,Deployment_Id,Project_Id,Deployment_Order,Notes from Deployment_Manifest_Items where Deployment_Id=?");
		statement.setInt(1,deploymentId);
		
		ResultSet set=statement.executeQuery();
		
		while(set.next())
		{
			items=new Deployment_Manifest_Items();
			
			items.setComments(set.getString(1));
			items.setItem_Id(set.getInt(2));
			items.setDeployment_Id(set.getInt(3));
			items.setProject_Id(set.getInt(4));
			items.setDeployment_Order(set.getInt(5));
			items.setNotes(set.getString(6));
			
			//System.out.println(items.getProject_Id());
			Project project=new Project();
			project.setProject_id(items.getProject_Id());
			project.setProject_Name(projectDAOImpl.findProjectName(items.getProject_Id()));
	
			items.setProject(project);
			itemsArray.add(items);
			
		}
		
		set.close();
		statement.close();
		
		return itemsArray;
	}

	}


