package com.Besant.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Besant.Utilities.TestUtil;
import com.Besant.base.TestBase;

public class AddCustomerTest extends TestBase{
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void addCustomerTest(Hashtable<String,String> data) throws InterruptedException {
		click("addCustBtn_CSS");
		Thread.sleep(3000);
		type("firstname_CSS", data.get("firstname"));
		Thread.sleep(2000);
		type("lastname_CSS", data.get("lastname"));
		Thread.sleep(2000);
		type("postcode_CSS", data.get("postcode"));
		click("addbtn_CSS");
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		alert.accept();
		Thread.sleep(3000);
	}
	
	

}
