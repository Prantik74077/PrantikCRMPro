package com.sqlquery;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class ExecuteNonSelectQuery1
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
				String query = "insert into dept values(40,'NonTech','KER')";
				
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
  				System.out.println("Row inserted with values==PASS");  //err==>for red colour
  			 }
        	 else 
        	 {
  				System.err.println("Row inserted with values==FAIL");  //out==>for black colour
  			 }
			 
			 conn.close();
			 System.out.println("close Connection ");
			 
		     }
	}
}
