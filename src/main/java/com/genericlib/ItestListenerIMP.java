package com.genericlib;
 
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ItestListenerIMP implements ITestListener 
{
	ExtentReports report;
	ExtentTest test;
	 		
	   public void onFinish(ITestContext result) 
	   {					
	        	report.flush();			      		
	   }	

	   		
	    public void onStart(ITestContext result) 
	    {					
	        				
	        	ExtentSparkReporter htmlReporter=new ExtentSparkReporter("./ExtentReport.html");
	        	htmlReporter.config().setTheme(Theme.DARK);
	        	htmlReporter.config().setDocumentTitle("VTiger App");
	        	
	        	 report=new ExtentReports();
	        	report.attachReporter(htmlReporter);
	        	report.setSystemInfo("Platform","Windows");
	        	report.setSystemInfo("OS","Windows 10 Pro");
	        	report.setSystemInfo("Environment","Testing Environment");
	        	report.setSystemInfo("Reporter","Prantik");
	    }		

			
	    /*public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	    {					
	        				
	        		
	    }*/

	  		
	    public void onTestFailure(ITestResult result) 
	    {	
	    	    test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
	    	    test.log(Status.FAIL, result.getThrowable());
	            String	date=new JavaUtility().getCurrentSystemDate().replace(" ", "_").replace(":", "_");
	    	    WebDriverUtility wlib=new WebDriverUtility();
	        	try 
	        	{
	        		String path=wlib.takeScreenShot(BaseClass.driver, result.getMethod().getMethodName()+date);
	        		test.addScreenCaptureFromPath(path);
	        	} 
	        	
				catch (Throwable e) 
	        	{
					e.printStackTrace();
				}			     		
	    }		
 		
	     public void onTestSkipped(ITestResult result) 
	     {					
	        test.log(Status.SKIP,result.getMethod().getMethodName()+"is skipped");			 		
	     }		

	   	
	    public void onTestStart(ITestResult result) 
	    {					
	       		test=report.createTest(result.getMethod().getMethodName());		
	    }		

	   		
	    public void onTestSuccess(ITestResult result) 
	    {					
	        	test.generateLog(Status.PASS,result.getMethod().getMethodName()+" is passed");  
	    }
	    
}
