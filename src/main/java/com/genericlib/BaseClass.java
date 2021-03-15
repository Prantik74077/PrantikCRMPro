package com.genericlib;

import org.openqa.selenium.WebDriver;    
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.pom.pages.VtigerHomepage;
import com.pom.pages.Vtigerloginpage;


public class BaseClass implements AutoConstant
{
	/*Object creation*/
	public static WebDriver driver;
	public Propertyfile p=new Propertyfile() ;
	public ExcelUtility e=new ExcelUtility();
	public PhotoUtility p1;
	public WebDriverUtility  u=new WebDriverUtility();
	public JavaUtility j=new JavaUtility();
	public DataBaseUtility dbLb = new DataBaseUtility();
	String mybrowser="chrome";
	
	
	public WebDriverUtility wu=new WebDriverUtility();
	
	@BeforeSuite(groups = {"smokeTest" , "regressionTest"})
	public void configBeforeSuite() throws Throwable 
	{
		System.out.println("==============Connect to DB=============");
		dbLb.connectToDB();
	}
	
	
	@BeforeClass(groups = {"smokeTest" , "regressionTest"})
    public void configBeforeClass() throws Throwable
    {	
		System.out.println("============launch the Browser==========");
		/*launch the Browser*/
		/*read Common Data*/
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
	
	@Parameters("BROWSER")
	//@BeforeClass(groups = {"smokeTest" , "regressionTest"})
    public void configBeforeClassParallel(String mybrowser) throws Throwable
    {	
		
		System.out.println("============launch the Browser==========");
		/* launch the Browser*/
		/*read Common Data*/
    	if(mybrowser.equals("chrome"))
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
	
	    @BeforeMethod(groups = {"smokeTest" , "regressionTest"})
	    public void configBeforeMtd() throws Throwable 
	    {
	    	System.out.println("====login to Application=====");
			/*step-1 : login to Application*/
		    String USERNAME = p.getPropertyData("username");
		    String PASSWORD = p.getPropertyData("password");
	        Vtigerloginpage lp= new Vtigerloginpage(driver);
		    lp.loginToAPP(USERNAME,PASSWORD);
        }
	    
	    @AfterMethod(groups = {"smokeTest" , "regressionTest"})
		public void configAfterMethod() throws Throwable 
	    {
	    	System.out.println("====logout from Application=====");
			VtigerHomepage hp = new VtigerHomepage(driver);
		      /*step-* : logout */
				  hp.Signoutlink();     
	    }
		
	@AfterClass(groups = {"smokeTest" , "regressionTest"})
    public void configAfterClass() throws Throwable
    {
    	System.out.println("============Close the Browser==========");
    	driver.close();
    }
    
    @AfterSuite(groups = {"smokeTest" , "regressionTest"})
	public void configAfterSuite() throws Throwable 
    {
    	dbLb.closeDb();
    	System.out.println("==============close db Connection=============");
	}   
}
