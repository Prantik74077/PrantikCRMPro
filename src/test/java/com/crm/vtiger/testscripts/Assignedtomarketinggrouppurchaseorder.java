package com.crm.vtiger.testscripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.commonlib.Rootclass;
import com.objectrepo.Purchaseorderinfopage;
import com.objectrepo.VtigerHomepage;
import com.objectrepo.Vtigercreatenewpurchaseorder;
import com.objectrepo.Vtigerpurchaseorder;

@Listeners(com.commonlib.ItestListenerIMP.class)
public class Assignedtomarketinggrouppurchaseorder extends Rootclass
{
	   @Test(retryAnalyzer = com.commonlib.RetryAnalyzer.class)
       public void createpurchaseordeassignedtomarketinggroup() throws Throwable
       { 
		   VtigerHomepage vh=new  VtigerHomepage(driver);
    	   u.mouseAction(driver,vh.getMorebutn());
    	   u.visibilityofelement(driver,vh.getPurchaseordertb());
    	   vh.getPurchaseordertb().click();
    	   
    	   
    	   Vtigerpurchaseorder vp=new Vtigerpurchaseorder(driver);
    	   u.visibilityofelement(driver,vp.getPlusbutn());
    	   vp.getPlusbutn().click();
    	   
    	   
    	   Vtigercreatenewpurchaseorder vcp=new Vtigercreatenewpurchaseorder(driver);
    	   String data=e.getExcelData("Sheet1",0,0) + "_" + j.getRandomnum();
    	   String vendordata=e.getExcelData("Sheet1",0,1);
    	   String billingaddress = e.getExcelData("Sheet1",0,2);
    	   String shippingaddress = e.getExcelData("Sheet1",0,3);
    	   String product = e.getExcelData("Sheet1",0,4);
    	   String qtydata = e.getExcelData("Sheet1",0,5);
    	   
    	   vcp.createnewpurchaseorderassignedtogroup(data, vendordata, billingaddress, shippingaddress, product, qtydata);
    	      
    	   Purchaseorderinfopage poi = new Purchaseorderinfopage(driver);
    	   u.visibilityofelement(driver,poi.getSuccessfulMsg());
    	   String purchaseordernmae =poi.getSuccessfulMsg().getText();
    	   Assert.assertTrue(purchaseordernmae.contains(data));
        }
}
