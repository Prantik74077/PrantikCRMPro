package com.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vtigerloginpage
{
	@FindBy(name="user_name")
	private WebElement usernametb;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordtextb;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	public Vtigerloginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void loginToAPP(String username , String password) 
	{
		usernametb.sendKeys(username);
		passwordtextb.sendKeys(password);
		loginbtn.click();
	}

	public WebElement getLoginbtn() 
	{
		return loginbtn;
	}
}
