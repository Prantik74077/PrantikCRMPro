package com.JDBC.practice;

import java.util.Random; 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericlib.ExcelUtility;

public class Organisation
{
	   String sheetName="Sheet1";
	   ExcelUtility excel =new ExcelUtility();
	   @Test
	   public void org() throws Throwable
	  { 
		Random r=new Random();
		int rint = r.nextInt(100000);
		String name=excel.getExcelData(sheetName,0,0);
		String orgname= name+rint;
		
		System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?module=Accounts&action=index");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@style='width:74%;']")).sendKeys(excel.getExcelData(sheetName,0,1));
		driver.findElement(By.id("phone")).sendKeys(excel.getExcelData(sheetName,0,2));

		driver.findElement(By.name("button")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Organizations")).click();
	}
}
