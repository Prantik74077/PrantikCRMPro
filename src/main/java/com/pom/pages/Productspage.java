package com.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericlib.WebDriverUtility;

public class Productspage extends WebDriverUtility
{
	public WebDriver driver;
	@FindBy(id="search_txt")
    private WebElement productsearchtb;
    
    @FindBy(xpath="//input[@class='crmbutton small create']")
    private WebElement productsearchnowbtn;
    
    @FindBy(xpath="//a[text()='IPHONE']")
    private WebElement myproduct;
    
    public Productspage(WebDriver driver)
    {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
    
    public void products(String product) throws Throwable
    {
    waitforElement(productsearchtb);
    productsearchtb.sendKeys(product);
    productsearchnowbtn.click();
    myproduct.click();
    switchToBrowser(driver, "module=PurchaseOrder&action");
    }	
}
