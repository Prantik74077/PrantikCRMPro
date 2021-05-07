package com.commonlib;

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
    
    	
    	public String getCurrentSystemDate() 
    	{
              Date date = new Date();
              String currentDate = date.toString();
    		  return currentDate;
    	}
    }
