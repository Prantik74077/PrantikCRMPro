package com.sqlquery;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class ExecuteNonSelectQuery2 
{
	public static void main(String[] args) throws Throwable 
    {
	   Connection conn = null;
	   int result=0;
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
				String query = "delete from dept where loc='KER' ";
				
				/*step-4  : execute query*/
				 result=  stat.executeUpdate(query);
				 System.out.println("result="+result);
				 
				 
        }
          catch (Exception e) 
          {
		      e.printStackTrace();
		  }
       
          finally 
          {
        	 if(result==1) 
        	 {
  				System.out.println("Row deleted==PASS");  
  			 }
        	 else 
        	 {
  				System.err.println("Row not deleted==FAIL");  
  			 }
			 
			 conn.close();
			 System.out.println("close Connection ");
			 
		     }
	}
}
