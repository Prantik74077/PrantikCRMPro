package com.commonlib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


public class DataBaseUtility 
{
	static Connection con = null;
	static ResultSet result = null;
	Driver driverRef;
	
	public  void connectToDB() throws Throwable 
	{
		    driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");			
	}
	
	public  void closeDb() throws SQLException 
	{
		con.close();
	}
	

	
	public static ResultSet execyteQuery(String query) throws Throwable 
	{
	         
			 result = con.createStatement().executeQuery(query);
				return result;	
	}
	
    public static  String executeQueryAndGetData(String query ,int columnName , String expectedData) throws Throwable
    {
         boolean flag = false;
		 result = con.createStatement().executeQuery(query);
			
		 while (result.next()) 
		 {
			if(result.getString(columnName).equals(expectedData)) 
			{
			  	flag= true;
			  	break;
			 }
		}
			
		if(flag) 
		{
			System.out.println(expectedData + "===> data verified in data base table");
			return expectedData;
		}
		else 
		{
			System.out.println(columnName + "===> data not verified in data base table");
			return expectedData;
		}		
	}	
}
