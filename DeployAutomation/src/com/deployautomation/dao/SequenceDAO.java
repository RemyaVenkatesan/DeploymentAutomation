package com.deployautomation.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface SequenceDAO {
	
	int headerSequence(Connection conn) throws SQLException;
	
	int itemSequence(Connection conn) throws SQLException;

}
