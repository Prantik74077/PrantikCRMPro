package com.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vtigerpurchaseorder 
{
	 @FindBy(xpath="//img[@alt='Create Purchase Order...']")
	 private WebElement plusbutn;
	 
	 public Vtigerpurchaseorder(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }

	public WebElement getPlusbutn() 
	{
		return plusbutn;
	}	 
}
