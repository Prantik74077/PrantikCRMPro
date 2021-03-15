package com.genericlib;

import java.io.FileInputStream;     
import java.util.Properties;

public class Propertyfile implements AutoConstant
{
     public String getPropertyData(String keysvalue) throws Throwable
     {
    	 Properties p=new Properties();
    	 FileInputStream fis=new FileInputStream(propertyfilepath);
    	 p.load(fis);
    	 return p.getProperty(keysvalue);
     }
}
