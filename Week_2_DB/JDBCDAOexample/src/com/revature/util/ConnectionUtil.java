package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {
		// Required for Connection
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "flash_card_db";
		String password = "p4ssw0rd";
		
		return DriverManager.getConnection(url, username, password);
	}

}
