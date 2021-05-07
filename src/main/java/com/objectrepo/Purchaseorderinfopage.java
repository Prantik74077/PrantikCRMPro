package com.objectrepo;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class Purchaseorderinfopage  
	{
		public WebDriver driver;
		@FindBy(className = "lvtHeaderText")
		private WebElement successfulMsg;

		public WebElement getSuccessfulMsg() 
		{
			return successfulMsg;
		}	
		
		public Purchaseorderinfopage (WebDriver driver)
		{
			this.driver =  driver;
			PageFactory.initElements(driver, this);
		}		
	}
