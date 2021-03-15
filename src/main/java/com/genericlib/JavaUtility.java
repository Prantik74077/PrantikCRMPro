package com.genericlib;

import java.util.Date; 
import java.util.Random;

public class JavaUtility 
{
	Date dateobj=new Date();
    public int getRandomnum()
    {
    	Random r=new Random();
		int count = r.nextInt(100000);
		return count; 	
    }
    
    	/**
    	 * used to get the current system Data
    	 * @return
    	 */
    	public String getCurrentSystemDate() 
    	{
              Date date = new Date();
              String currentDate = date.toString();
    		  return currentDate;
    	}
    
    public String getcurrentYear()
    {
    	String currentDate=dateobj.toString();
    	String [] arr=currentDate.split(" ");
    	return arr[5];
    }
    
    public String getMonth()
    {
    	String currentDate=dateobj.toString();
    	String [] arr=currentDate.split(" ");
    	return arr[1];
    }
    
    public int getMonthInt()
    {
		dateobj.toString();
		return dateobj.getMonth();
    }
    
    public String getDate()
    {
    	String currentDate=dateobj.toString();
    	String [] arr=currentDate.split(" ");
    	return arr[2];
    }
    
}
