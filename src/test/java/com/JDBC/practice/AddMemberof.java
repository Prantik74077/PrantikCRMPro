package com.JDBC.practice;

import java.util.Iterator;     
import java.util.Set; 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.genericlib.ExcelUtility;
 
public class AddMemberof 
{
	   String sheetName="Sheet1";
	   ExcelUtility excel =new ExcelUtility();
	   @Test
	   public void org() throws Throwable
	  { 
		String orgname = excel.getExcelData(sheetName,0,0);
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?module=Accounts&action=index");
		//driver.navigate().to("http://localhost:8888/index.php?module=Accounts&action=index");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@style='width:74%;']")).sendKeys(excel.getExcelData(sheetName,0,1));
		driver.findElement(By.id("phone")).sendKeys(excel.getExcelData(sheetName,0,2));
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		Set<String> child = driver.getWindowHandles();
		Iterator<String> win = child.iterator();
		String pwin = win.next();
		String cwin = win.next();
		driver.switchTo().window(cwin);
		
		driver.findElement(By.name("search_text")).sendKeys("abc123");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='abc123']")).click();
		driver.switchTo().alert().accept();
		
		driver.switchTo().window(pwin);
		
		
		WebElement industrydropdown = driver.findElement(By.name("industry"));
		
		Select s1=new Select(industrydropdown);
		s1.selectByValue("Banking");
		
		WebElement type = driver.findElement(By.name("accounttype"));
		Select s2=new Select(type);
		s2.selectByValue("Customer");
		
		WebElement rating = driver.findElement(By.name("rating"));
		Select s3=new Select(rating);
		s3.selectByValue("Active");
		
		driver.findElement(By.name("button")).click();
		//driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.name("search_text")).sendKeys(orgname);
	    WebElement orgno = driver.findElement(By.id("bas_searchfield"));
	    Select s=new Select(orgno);
	    s.selectByVisibleText("Organization Name");
	    driver.findElement(By.name("submit")).click();
	    
        driver.quit();
	  }
}
