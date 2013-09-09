package com.practice.dao;
import javax.sql.*;
import javax.naming.*;


public class DatabaseConnection {

	private static DataSource DatabaseConnection=null;
	private static Context context=null;
	
	public static DataSource DatabaseConnectiontry() throws Exception
	{
		
		if(DatabaseConnection!=null)
		{
			return DatabaseConnection;
		}
		
		
		try
		{
			if(context == null)
			{
				context= new InitialContext();
			}
			DatabaseConnection= (DataSource)context.lookup("java:comp/env/jdbc/MySQLDB");	
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return DatabaseConnection;
	}
}
