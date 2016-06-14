package com.deployautomation.utility;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {
	Connection dataBaseConnection() throws ClassNotFoundException, SQLException;

}
