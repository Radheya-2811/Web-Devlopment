package com.site.dao;
import java.sql.*;

import com.site.util.DBUtil;
public class UserDaoImp implements UserDao {

	@Override
	public boolean isValidUser(String username, String password) {
		String query="SELECT *FROM users WHERE username=? AND password=?";
		try {
			Connection con= DBUtil.getConnection();
			PreparedStatement preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			return resultSet.next();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addUser(NewUser user) {
		
		String query="INSERT INTO users (username,email,password) VALUES(?,?,?)";
		try{
			Connection conn=DBUtil.getConnection();
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1, user.getUsername());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getPassword());
			
			int rowsAffected=ps.executeUpdate();
	
			return rowsAffected>0;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}
