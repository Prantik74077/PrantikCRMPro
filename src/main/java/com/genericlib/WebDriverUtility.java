package com.genericlib;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;  
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.common.io.Files;

public class WebDriverUtility implements AutoConstant
{
	/**
	 * To handle the dropdown
	 * @param ele
	 * @param text
	 */
	
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
   /**
    * To handle the mouse action
    * @param driver
    * @param ele
    */
   
   public void mouseAction(WebDriver driver,WebElement ele)
   {
	   Actions a=new Actions(driver);
	   a.moveToElement(ele).perform();
   }
   
   /**
    * To handle doubleclick action
    * @param driver
    * @param target
    */
   
   public void doubleClick(WebDriver driver,WebElement target)
   {
	   Actions a=new Actions(driver);
	   a.doubleClick(target).perform();
   }
   
   /**
    * To handle the scrollbar
    * @param driver
    * @param x
    * @param y
    */
   
   public void location(WebDriver driver,WebElement ele)
   {
	   Point loc = ele.getLocation();
 	   int x = loc.getX();
 	   int y = loc.getY();		   
   }
   
   public void Scrollbar(WebDriver driver,int x,int y)
   {
	   JavascriptExecutor j=(JavascriptExecutor) driver;
	   j.executeScript("window.scrollBy("+x+","+y+")");
   }
   
   /**
    * To handle the alertpopup
    * @param driver
    * @param element
    */
   
   public void acceptalertpopup(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }
   
   public void rejrcttalertpopup(WebDriver driver)
   {
	   driver.switchTo().alert().dismiss();
   }
   
   /**
    * To wait for the element
    * @param driver
    * @param element
    */
   
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
   
   /**
	 * used to wait & click for expected element in GUI
	 * @param element
	 * @throws Throwable
	 */
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
	
	/**
	 * used to wait for expected element in GUI
	 * @param element
	 * @throws Throwable
	 */
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
   
   /**
	 * To handle the switchingfromparenttochild
	 * @param ele
	 * @param text
	 */
   
   public void switchingfromparenttochild(WebDriver driver)
   {
	   Set<String> child = driver.getWindowHandles();
       for(String b:child)
       {
    	   driver.switchTo().window(b); 
       }
       /* Set<String> child = driver.getWindowHandles();
		  Iterator<String> win = child.iterator();
		  String cwin = win.next();
		  driver.switchTo().window(cwin);*/
   }
   
   /**
  	 * To handle the switchingfromchildtoparent
  	 * @param ele
  	 * @param text
  	 */
   
   public void switchingfromchildtoparent(WebDriver driver)
   {
	    Set<String> child = driver.getWindowHandles();
		Iterator<String> win = child.iterator();
		String pwin = win.next();
		driver.switchTo().window(pwin);
   }
   
   /**
	 *  used to switch to another browser window based on browser partial / complete title
	 * @param driver
	 * @param browserTitle
	 */
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
   /**
	 * To handle the navigationofurl
	 * @param ele
	 * @param text
	 */
   
   public void navigatetourl(WebDriver driver,String url)
   {
	   driver.navigate().to(url);
   }
   
   /**
	 * To handle the switchingtoframe
	 * @param ele
	 * @param text
	 */
   
   public void switchtoframe(WebDriver driver)
   {
	   driver.switchTo().frame(0);
   }
   
   /**
	 * To handle the switchbackfromframe
	 * @param ele
	 * @param text
	 */
   
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
   
   /**
	 * Used to take screenshot
	 * @param driver
	 * @param methodName
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String methodName) throws Throwable 
	{
		JavaUtility jlib=new JavaUtility();
		EventFiringWebDriver event=new EventFiringWebDriver(BaseClass.driver);
		File src=event.getScreenshotAs(OutputType.FILE);
		String screenShotpath=System.getProperty("user.dir")+"/Screenshot/"+methodName+jlib.getCurrentSystemDate()+".png";
		File dest=new File("./Screenshot/"+methodName+".PNG");
		Files.copy(src, dest);
		return screenShotpath;
		
	}

}
