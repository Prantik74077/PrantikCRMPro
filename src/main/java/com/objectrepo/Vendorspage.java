package com.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonlib.WebUtility;

public class Vendorspage extends WebUtility
{
    public WebDriver driver;
    @FindBy(id="search_txt")
    private WebElement searchtb;
    
    @FindBy(name="search")
    private WebElement serachnowbtn;
    
    @FindBy(xpath="//a[text()='TestYantra']")
    private WebElement myvendor;
    
    public Vendorspage(WebDriver driver)
    {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
    
    public void createvendor(String vendordata) throws Throwable
    {
    	waitforElement(searchtb);
        searchtb.sendKeys(vendordata);
	    serachnowbtn.click();
	    myvendor.click();
	    switchToBrowser(driver, "module=PurchaseOrder&action");
    }
}
