package com.JDBC.practice;

import org.openqa.selenium.By; 
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.genericlib.BaseClass;

public class Makemytrip extends BaseClass
{
  @Test
  public void calenderWindowTest() throws InterruptedException
  {
	  Actions act=new Actions(driver);
	  act.moveByOffset(10,10).click().perform();
	  Thread.sleep(1000);
	  int count=0;
	  driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	  while(count<11)
	  {
		  try
		  {
			  String x="//div[@aria-label='Sat Dec 25 2021']/div/p[text()='25']";
			  driver.findElement(By.xpath(x)).click();
			  System.out.println("given date is valid");
			  break;
		  }
		  catch(Exception e)
		  {
			  //click on next button
			  driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			  count++;
		  }
	  }
	  if(count==11)
	  {
		  System.out.println("Given data is invalid");
	  }
  }
}
