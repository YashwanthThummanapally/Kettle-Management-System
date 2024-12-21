package com.edubridge.kettle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// singleton design pattern
public class DBConnection {
	private static Connection con = null;
	
	private DBConnection() {}

	public static Connection getCon() {
		if (con == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/edubridge12980", "root", "root");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return con;
	}
	
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
