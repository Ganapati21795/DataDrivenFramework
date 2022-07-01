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

public class OpenAccountTest extends TestBase{
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void openAccountTest(Hashtable<String, String> data) throws InterruptedException {
		click("openaccount_CSS");
		select("customer_CSS",data.get("customer"));
		select("currency_CSS",data.get("currency"));
		click("process_CSS");
		Thread.sleep(2000);
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}
	

}
