package com.Besant.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Besant.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	
	@Test
	public void bankManagerLoginTest() throws InterruptedException {
		log.debug("Inside login test");
		click("bmlBtn_CSS");
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))), "Login not Successful");
		log.debug("Login test completed");
		Reporter.log("Login successfully executed");
	}

}
