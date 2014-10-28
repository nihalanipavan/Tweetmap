package com.cloud.project.tweetmap.dao.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {

	public boolean checkLogin(String userName, String password) {
		
		int count = 0;
		boolean loginResult = false;
		
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");

			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select email, password from login where email='"+userName+"' AND password='"+password+"'");
			
			while(rs.next())
			{
				if(rs.getString(1) == userName && rs.getString(2) == password)
					count = 1;
			}
			
			if(count == 1)
				loginResult = true;
			else
				loginResult = false;
		}
		catch(Exception Ex)
		{
			Ex.printStackTrace();
			
		}
		
		return loginResult;
	}

}
