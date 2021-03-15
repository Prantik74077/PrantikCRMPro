package com.JDBC.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CompareOrganisations 
{
	  @Test
      public void compare() throws InterruptedException
      {
    	     System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
    		 WebDriver driver=new ChromeDriver();
    		 driver.manage().window().maximize();
    		 driver.get("http://localhost:8888/index.php?module=Accounts&action=index");
    		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    		 
    	     driver.findElement(By.name("user_name")).sendKeys("admin");
    	     driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
    	     driver.findElement(By.id("submitButton")).click();
             
    	     driver.findElement(By.linkText("Organizations")).click();
    	     String x="//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']";
    	     
    	     List<WebElement> list = driver.findElements(By.xpath(x));
    	     
    	     ArrayList<String> alist1=new ArrayList<String>();
    	     for(WebElement wb:list)
    	     {
    	    	 String name = wb.getText();
    	    	 alist1.add(name);
    	     }
    	     Collections.sort(alist1);
    	     
    	     String z="//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@class='listFormHeaderLinks']"; 
    	     driver.findElement(By.xpath(z)).click();
    	     
    	     Thread.sleep(2000);
    	     
    	     List<WebElement> list1 = driver.findElements(By.xpath(x));
    	     ArrayList<String> alist2=new ArrayList<String>();
    	     for(WebElement wb:list1)
    	     {
    	    	 String name = wb.getText();
    	    	 alist2.add(name);
    	     }
    	     Assert.assertEquals(alist2,alist1);
    	     driver.close();
      }
}
