package com.deployautomation.utility.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.deployautomation.utility.DatabaseConnection;



public class DatabaseConnectionImpl implements DatabaseConnection{
	
	// singleton implementation
		private static DatabaseConnectionImpl instance = null;
		private static Connection con;

		protected DatabaseConnectionImpl() throws ClassNotFoundException,
				SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.con = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.2.226:1521:xe", "RelAut", "A1234");
			// Exists only to defeat instantiation.
		}

		public static synchronized DatabaseConnectionImpl getInstance()
				throws ClassNotFoundException, SQLException {
			if (instance == null) {
				instance = new DatabaseConnectionImpl();
			}
			return instance;
		}

		public Connection dataBaseConnection() throws ClassNotFoundException,
				SQLException {
			// TODO Auto-generated method stub

			return this.con;
		}


}
