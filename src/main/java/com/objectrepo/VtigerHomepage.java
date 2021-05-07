package com.objectrepo;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonlib.WebUtility;

public class VtigerHomepage extends WebUtility
{
	 @FindBy(xpath="//a[text()='More']")
     private WebElement morebutn;
	 
	 @FindBy(xpath="//a[text()='Purchase Order']")
     private WebElement Purchaseordertb;
	 
	 @FindBy(xpath="(//td[@class='small'])[2]")
	 private WebElement Adminimg;

	 public WebElement getPurchaseordertb() 
	 {
		return Purchaseordertb;
	 }

	 @FindBy(linkText = "Sign Out")
	 private WebElement signoutlnk;
	 
	 public VtigerHomepage(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }

	public WebElement getMorebutn() 
	{
		return morebutn;
	}
	 
	
	
	public void Signoutlink() throws Throwable
	{
		waitAndClick(Adminimg);
		signoutlnk.click();
	}
	
}
