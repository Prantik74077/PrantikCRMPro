package com.commonlib;

import java.io.File; 
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

public class WebUtility implements AutoConstant
{
   public void dropdown(WebElement ele,String text)
   {
	   Select s=new Select(ele);
	   s.selectByVisibleText(text);
   }
   
 
   public void dropdownbyvalue(WebElement ele,String value)
   {
	   Select s=new Select(ele);
	   s.selectByValue(value);
   }
   
   public void dropdownbyindex(WebElement ele,int index)
   {
	   Select s=new Select(ele);
	   s.selectByIndex(index);
   }
  
   public void mouseAction(WebDriver driver,WebElement ele)
   {
	   Actions a=new Actions(driver);
	   a.moveToElement(ele).perform();
   }
 
   
   public void doubleClick(WebDriver driver,WebElement target)
   {
	   Actions a=new Actions(driver);
	   a.doubleClick(target).perform();
   }
   
  
   

   public void Scrollbar(WebDriver driver,int x,int y)
   {
	   JavascriptExecutor j=(JavascriptExecutor) driver;
	   j.executeScript("window.scrollBy("+x+","+y+")");
   }
   
   
   
   public void acceptalertpopup(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }
   
   public void rejrcttalertpopup(WebDriver driver)
   {
	   driver.switchTo().alert().dismiss();
   }
   
   
   public void elementTobeClicked(WebDriver driver,WebElement element)
   {
	   WebDriverWait w=new  WebDriverWait(driver,explicitlyWait);
	   w.until(ExpectedConditions.elementToBeClickable(element));
   }
   
   public void visibilityofelement(WebDriver driver,WebElement element)
   {
	   WebDriverWait w=new  WebDriverWait(driver,explicitlyWait);
	   w.until(ExpectedConditions.visibilityOf(element));
   }
   
   public void getimplicitlywait(WebDriver driver)
   {
	   driver.manage().timeouts().implicitlyWait(implicitlyWait,TimeUnit.SECONDS);
   }
   
  
	public void waitAndClick( WebElement element) throws Throwable 
	{
		  int count = 0;
	        while(count < 40) 
	        {
			   try 
			   {
				   element.click();
			       break;
			   }
			   catch (Throwable e)
			   {
				Thread.sleep(5000);
				count++;
			   }
	        }
	}
	
	
	public void waitforElement( WebElement element) throws Throwable 
	{
		    int count = 0;
	        while(count < 40) 
	        {
			   try 
			   {
				   element.isDisplayed();
			       break;
			   }
			   catch (Throwable e) 
			   {
				Thread.sleep(500);
				count++;
			   }
	        }
	}
   
   
  
	public void switchToBrowser(WebDriver driver,String browserTitle) 
	{
		  Set<String> set = driver.getWindowHandles();
		  
		  for(String act : set) 
		  {
			  driver.switchTo().window(act);
			  String actPageTile = driver.getTitle();
			  if(actPageTile.contains(browserTitle)) 
			  {
				  break;
			  }
		  }
	}
  
   public void navigatetourl(WebDriver driver,String url)
   {
	   driver.navigate().to(url);
   }
 
   
   public void switchtoframe(WebDriver driver,int index)
   {
	   driver.switchTo().frame(index);
   }
   
  
   public void switchbackfromframe(WebDriver driver)
   {
	   driver.switchTo().defaultContent();
   }
   
   public void parentframe(WebDriver driver)
   {
	   driver.switchTo().parentFrame();
   }
   
   public void refreshpage(WebDriver driver)
   {
	   driver.navigate().refresh();
   }
   
   public void backwardtopage(WebDriver driver)
   {
	   driver.navigate().back();
   }
   
  
	public String takeScreenShot(WebDriver driver,String methodName) throws Throwable 
	{
		JavaUtility jlib=new JavaUtility();
		EventFiringWebDriver event=new EventFiringWebDriver(Rootclass.driver);
		File src=event.getScreenshotAs(OutputType.FILE);
		String screenShotpath=System.getProperty("user.dir")+"/Screenshot/"+methodName+jlib.getCurrentSystemDate()+".png";
		File dest=new File("./Screenshot/"+methodName+".PNG");
		Files.copy(src, dest);
		return screenShotpath;
		
	}

}
