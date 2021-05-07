package com.commonlib;

import org.openqa.selenium.WebDriver;     
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.objectrepo.VtigerHomepage;
import com.objectrepo.Vtigerloginpage;


public class Rootclass implements AutoConstant
{
	public static WebDriver driver;
	public PropertyfileUtility p=new PropertyfileUtility() ;
	public ExcelUtility e=new ExcelUtility();
	public PhotoUtility p1;
	public WebUtility  u=new WebUtility();
	public JavaUtility j=new JavaUtility();
	public DataBaseUtility dbLb = new DataBaseUtility();
	
	String mybrowser="chrome";
	public WebUtility wu=new WebUtility();
	
	@BeforeSuite
	public void configBeforeSuite() throws Throwable 
	{
		System.out.println("==============Connect to DB=============");
		dbLb.connectToDB();
	}
	
	
	@BeforeClass
    public void configBeforeClass() throws Throwable
    {	
		System.out.println("============launch the Browser==========");
    	if(mybrowser.equals(p.getPropertyData("browser")))
    	{
    		System.setProperty(key1,value1);
    	    driver=new ChromeDriver();
    	}
    	else
    	{
    		System.setProperty(key2,value2);
    	    driver=new FirefoxDriver();
    	}
	
	        u.getimplicitlywait(driver);
	        driver.get(p.getPropertyData("url"));
     }
	
	    @BeforeMethod
	    public void configBeforeMtd() throws Throwable 
	    {
	    	System.out.println("====login to Application=====");
		    String USERNAME = p.getPropertyData("username");
		    String PASSWORD = p.getPropertyData("password");
	        Vtigerloginpage lp= new Vtigerloginpage(driver);
		    lp.loginToAPP(USERNAME,PASSWORD);
        }
	    
	    @AfterMethod
		public void configAfterMethod() throws Throwable 
	    {
	    	System.out.println("====logout from Application=====");
			VtigerHomepage hp = new VtigerHomepage(driver);
	    	hp.Signoutlink();     
	    }
		
	    @AfterClass
        public void configAfterClass() throws Throwable
        {
    	System.out.println("============Close the Browser==========");
    	driver.close();
        }
    
    @AfterSuite
	public void configAfterSuite() throws Throwable 
    {
    	dbLb.closeDb();
    	System.out.println("==============close db Connection=============");
	}   
}
