package com.doglab.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String URL = "jdbc:mysql://localhost:3306/accounts";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		return conn;
	}
	
	public static void main(String[] args) {
		try {
			getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
