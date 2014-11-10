package com.ems.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	/**
	 * @param args
	 */
	public Connection getConnection() {
		Connection conn=null;	
		try {		
			Class.forName("org.hsqldb.jdbcDriver");			
			conn=DriverManager.getConnection("jdbc:hsqldb:file:C:\\J2EEProject\\EMS\\database\\EMSoriginal1", "sa", "");		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;		
	}

}
