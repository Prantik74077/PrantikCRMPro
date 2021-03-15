package com.JDBC.practice;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.genericlib.BaseClass;
import com.genericlib.ExcelUtility;
 
public class AddMemberof2 extends BaseClass
{
	   String sheetName="Sheet1";
	   ExcelUtility excel =new ExcelUtility();
	   @Test
	   public void org() throws Throwable
	  { 
		int count = j.getRandomnum();
		String name=excel.getExcelData(sheetName,0,0);
		String orgname= name+count;
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@style='width:74%;']")).sendKeys(excel.getExcelData(sheetName,0,1));
		driver.findElement(By.id("phone")).sendKeys(excel.getExcelData(sheetName,0,2));
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		u.switchingfromparenttochild(driver);
		
		driver.findElement(By.name("search_text")).sendKeys("abc123");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='abc123']")).click();
		driver.switchTo().alert().accept();
		
		u.switchingfromchildtoparent(driver);
		
		u.dropdownbyvalue(driver.findElement(By.name("industry")),"Banking");
		
		u.dropdownbyvalue(driver.findElement(By.name("accounttype")), "Customer");
		
		u.dropdownbyvalue(driver.findElement(By.name("rating")),"Active");
		
		
		
		driver.findElement(By.name("button")).click();
		//driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.name("search_text")).sendKeys(orgname);
	    
	    u.dropdown(driver.findElement(By.id("bas_searchfield")),"Organization Name");
	    
	    driver.findElement(By.name("submit")).click();
	    
	    WebElement myorg = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
	   
	    if(myorg.isDisplayed())
	    {
	    	System.out.println("Org is displayed");
	    }
        driver.quit();
	  }
}
