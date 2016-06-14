package com.deployautomation.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deployautomation.dao.SequenceDAO;



public class SequenceDAOImpl implements SequenceDAO{

	
	@Override
	public int headerSequence(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		int id = 0;
		PreparedStatement statement=conn.prepareStatement("select deploymentId.NEXTVAL from dual" );
		synchronized( this ) {
			   ResultSet rs = statement.executeQuery();
			   if(rs.next())
			     id = rs.getInt(1);
		}
		
		statement.close();
		return  id;
	}

	@Override
	public int itemSequence(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		int id = 0;
		PreparedStatement statement=conn.prepareStatement("select deployItemId.NEXTVAL from dual" );
		synchronized( this ) {
			   ResultSet rs = statement.executeQuery();
			   if(rs.next())
			     id = rs.getInt(1);
		}
		statement.close();
		return  id;
	}

}
