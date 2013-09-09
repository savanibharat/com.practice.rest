package com.practice.rest.status;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.practice.dao.DatabaseConnection;

import java.sql.*;

//import com.practice.dao.*;


 @Path("/v1/status/*")
public class V1_status {
	@GET
	
	@Produces(MediaType.TEXT_HTML)
	
	public String returnTitle()
	{
		return "<p>Java Web Service status</p>";
	}

 

@Path("/database")
@GET
@Produces(MediaType.TEXT_HTML)
public String returnDatabaseStatus() throws Exception
{
	PreparedStatement query=null;
	String myString=null;
	String returnString=null;
	Connection conn=null;
	
	try
	{
        conn = DatabaseConnection.DatabaseConnectiontry().getConnection();

		query=conn.prepareStatement("select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS')DATETIME "+"from sys.dual");
		ResultSet rs=query.executeQuery();
		
		while(rs.next())
		{
			myString=rs.getString("DATETIME");
		}
		query.close();
		
		returnString ="<p>Database Status</p>"+"<p>Database Date/Time return: "+myString+" </p>";
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(conn!=null)
		conn.close();
	}
	return returnString;
}
}