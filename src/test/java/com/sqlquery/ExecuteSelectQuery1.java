package com.sqlquery;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQuery1
{
     public static void main(String[] args) throws Throwable 
     {
		Connection conn = null;
        try 
        {
				/*step-1  : load or register the data base*/
				Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);
				
				/*step-2  : connect to database*/
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
				System.out.println("connect to database");
				
				/*step-3  : create/issue SQL statement*/
				Statement stat = conn.createStatement();
				String query = "select * from employee";
				
				/*step-4  : execute query*/
				 ResultSet resultSet =  stat.executeQuery(query);
				 
				 while (resultSet.next()) 
				 {
				   System.out.println(resultSet.getInt(1)+ "\t" +resultSet.getString(2)+ "\t" +resultSet.getString(3)+ "   \t" + resultSet.getInt(4)+ "\t" +resultSet.getInt(5)+ "\t" +resultSet.getInt(6));
			     }
          }
           catch (Exception e) 
           {
		      e.printStackTrace();
		   }
           finally 
           {
			 /*step-5  : close the Connection*/
			 conn.close();
			 System.err.println("close Connection ");
		   }
	}

}
