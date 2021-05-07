package com.objectrepo;

import org.openqa.selenium.WebDriver;     
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonlib.WebUtility;

public class Vtigercreatenewpurchaseorder extends WebUtility
{
	 public WebDriver driver;
	 
     @FindBy(name="subject")
     private WebElement subjecttextb;
      
 	 @FindBy(xpath="//img[@alt='Select']")
     private WebElement vendornameplusbtn;
     
     @FindBy(name="postatus")
     private WebElement statustb;
     
     public WebElement getStatustb() 
     {
		return statustb;
	 }
     
     @FindBy(xpath="//input[@value='T']")
     private WebElement assignedtogroupradiobtn;
     
     @FindBy(name="assigned_group_id")
     private WebElement groupdd;
     
     
     public WebElement getGroupdd() 
     {
		return groupdd;
	 }

	 @FindBy(xpath="//textarea[@name='bill_street']")
     private WebElement billingaddresstb;
     
     @FindBy(xpath="//textarea[@name='ship_street']")
     private WebElement shippingaddresstb;
		
     @FindBy(id="searchIcon1")
     private WebElement productitemnameimg;
     
     
     
     @FindBy(id="qty1")
     private WebElement quantitytextb;

     @FindBy(name="button")
     private WebElement savebtn;
     
     @FindBy(xpath="//a[text()='Purchase Order']")
     private WebElement Purchaseorderlnk;
     
     @FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
     private WebElement Homebtnlnk;
     
  
     public Vtigercreatenewpurchaseorder(WebDriver driver)
     {
 		this.driver =  driver;
 		PageFactory.initElements(driver, this);
 	 }
 	

	 public void createnewpurchaseorder(String data,String vendordata,String billingaddress,String shippingaddress,String product,String qtydata) throws Throwable
	 {
		    subjecttextb.sendKeys(data);
		    vendornameplusbtn.click();
		    switchToBrowser(driver, "module=Vendors&action");
		    
		    Vendorspage vp=new Vendorspage(driver);
		    vp.createvendor(vendordata);
		    
		    waitforElement(billingaddresstb);
		    billingaddresstb.sendKeys(billingaddress);
		    shippingaddresstb.sendKeys(shippingaddress);
		    productitemnameimg.click();
		    switchToBrowser(driver, "module=Products&action");
		    
		    Productspage pd=new Productspage(driver);
		    pd.products(product);
		     
		    waitforElement(quantitytextb);
		    quantitytextb.sendKeys(qtydata);
		    savebtn.click();
	 }
	 
	 public void createnewpurchaseorderwithdeliveredstatus(String data,String vendordata,String billingaddress,String shippingaddress,String product,String qtydata) throws Throwable
	 {
		    subjecttextb.sendKeys(data);
		    vendornameplusbtn.click();
		    switchToBrowser(driver, "module=Vendors&action");
		    
		    Vendorspage vp=new Vendorspage(driver);
		    vp.createvendor(vendordata);
		    
		    waitforElement(getStatustb());
		    dropdownbyvalue(getStatustb(),"Delivered");
		    
		    billingaddresstb.sendKeys(billingaddress);
		    shippingaddresstb.sendKeys(shippingaddress);
		    productitemnameimg.click();
		    switchToBrowser(driver, "module=Products&action");
		    
		    Productspage pd=new Productspage(driver);
		    pd.products(product);
		    
		    waitforElement(quantitytextb);
		    quantitytextb.sendKeys(qtydata);
		    savebtn.click();
	 }
	 
	 public void createnewpurchaseorderwithcancelledstatus(String data,String vendordata,String billingaddress,String shippingaddress,String product,String qtydata) throws Throwable
	 {
		    subjecttextb.sendKeys(data);
		    vendornameplusbtn.click();
		    switchToBrowser(driver, "module=Vendors&action");
		    
		    Vendorspage vp=new Vendorspage(driver);
		    vp.createvendor(vendordata);
		    
		    
		    dropdownbyvalue(getStatustb(),"Cancelled");
		    
		    billingaddresstb.sendKeys(billingaddress);
		    shippingaddresstb.sendKeys(shippingaddress);
		    productitemnameimg.click();
		    switchToBrowser(driver, "module=Products&action");
		    
		    Productspage pd=new Productspage(driver);
		    pd.products(product);
		    
		    
		    quantitytextb.sendKeys(qtydata);
		    savebtn.click();
	 }
	 
	 public void createnewpurchaseorderwithreceivedshipmentstatus(String data,String vendordata,String billingaddress,String shippingaddress,String product,String qtydata) throws Throwable
	 {
		    subjecttextb.sendKeys(data);
		    vendornameplusbtn.click();
		    switchToBrowser(driver, "module=Vendors&action");
		    
		    Vendorspage vp=new Vendorspage(driver);
		    vp.createvendor(vendordata);
		    
		    
		    dropdownbyvalue(getStatustb(),"Received Shipment");
		    
		    billingaddresstb.sendKeys(billingaddress);
		    shippingaddresstb.sendKeys(shippingaddress);
		    productitemnameimg.click();
		    switchToBrowser(driver, "module=Products&action");
		    
		    Productspage pd=new Productspage(driver);
		    pd.products(product);
		    
		    
		    quantitytextb.sendKeys(qtydata);
		    savebtn.click();
	 }
	 
	 public void createnewpurchaseorderassignedtogroup(String data,String vendordata,String billingaddress,String shippingaddress,String product,String qtydata) throws Throwable
	 {
		    subjecttextb.sendKeys(data);
		    vendornameplusbtn.click();
		    switchToBrowser(driver, "module=Vendors&action");
		    
		    Vendorspage vp=new Vendorspage(driver);
		    vp.createvendor(vendordata);
		    
		    assignedtogroupradiobtn.click();
		    
		    billingaddresstb.sendKeys(billingaddress);
		    shippingaddresstb.sendKeys(shippingaddress);
		    productitemnameimg.click();
		    switchToBrowser(driver, "module=Products&action");
		    
		    Productspage pd=new Productspage(driver);
		    pd.products(product);
		    
		    
		    quantitytextb.sendKeys(qtydata);
		    savebtn.click();
	 }
	 
	 public void createnewpurchaseorderassignedtomarketinggroup(String data,String vendordata,String billingaddress,String shippingaddress,String product,String qtydata) throws Throwable
	 {
		    subjecttextb.sendKeys(data);
		    vendornameplusbtn.click();
		    switchToBrowser(driver, "module=Vendors&action");
		    
		    Vendorspage vp=new Vendorspage(driver);
		    vp.createvendor(vendordata);
		    
		    waitforElement(assignedtogroupradiobtn);
		    assignedtogroupradiobtn.click();
		    dropdownbyvalue(groupdd,"Marketing Group");
		    
		    billingaddresstb.sendKeys(billingaddress);
		    shippingaddresstb.sendKeys(shippingaddress);
		    productitemnameimg.click();
		    switchToBrowser(driver, "module=Products&action");
		    
		    Productspage pd=new Productspage(driver);
		    pd.products(product);
		    
		    waitforElement(quantitytextb);
		    quantitytextb.sendKeys(qtydata);
		    savebtn.click();
	 }
}