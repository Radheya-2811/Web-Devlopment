package com.site.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String Url="jdbc:mysql://localhost:3306/logindetails";
	private static final String Username="root";
	private static final String Password="1414";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//laoding jdbc driver
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(Url,Username,Password);
	}
}
