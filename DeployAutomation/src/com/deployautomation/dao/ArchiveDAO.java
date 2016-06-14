package com.deployautomation.dao;

import java.sql.SQLException;

public interface ArchiveDAO {
	
	boolean archiveValueUpdate(int deploymentId) throws SQLException;

}
