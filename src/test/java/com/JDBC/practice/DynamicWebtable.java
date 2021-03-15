package com.JDBC.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DynamicWebtable
{	
@Test
public void CaptureDynamicWebtable()
{
	//login
	 System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://localhost:8888/index.php?module=Accounts&action=index");
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 
     driver.findElement(By.name("user_name")).sendKeys("admin");
     driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
     driver.findElement(By.id("submitButton")).click();
     
     //navigate to organization page
     driver.findElement(By.linkText("Organizations")).click();
     
     //capture all the organization name from 3rd column
     String x="//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']";
     
     List<WebElement> list = driver.findElements(By.xpath(x));
    
     String ExpOrganisation ="jkl101112";
     for(WebElement wb:list)
     {
    	 String Text = wb.getText();
    	 if(Text.equals(ExpOrganisation))
    	 {
    		 wb.click();
    		 break;
    		 //driver.findElement(By.linkText("jkl101112")).click();	 
    	 }  	 
     } 
     driver.findElement(By.name("Delete")).click();
     Alert a = driver.switchTo().alert();
     a.accept();
     driver.findElement(By.name("search_text")).sendKeys(ExpOrganisation);
     WebElement orgno = driver.findElement(By.id("bas_searchfield"));
     Select s=new Select(orgno);
     s.selectByVisibleText("Organization Name");
     driver.findElement(By.name("submit")).click();
     
     List<WebElement> list2 = driver.findElements(By.xpath(x));
     for(WebElement wb:list2)
     {
    	 String latestorgname = wb.getText();
    	 if(latestorgname.equals(ExpOrganisation))
    	 {
    		 System.out.println("orgnisation found");
    		 break;
    	 }
     }
     WebElement notfound = driver.findElement(By.xpath("//span[@class='genHeaderSmall']"));
     System.out.println(notfound.getText());
     driver.close();
}
}