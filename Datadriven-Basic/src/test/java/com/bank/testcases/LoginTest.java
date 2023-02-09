package com.bank.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.bank.base.TestBase;

public class LoginTest extends TestBase{
	
	@Test
	public void loginasBankManager() throws InterruptedException {
		
		driver.findElement(By.xpath(OR.getProperty("bml"))).click();
		//
		Assert.assertTrue(isElementprese(By.xpath(OR.getProperty("addcus"))),"Login not Succesful");
		
		Thread.sleep(3000);
		//Assert.fail("Login not Successful");
		
//		log.info("Login Successful");
		
		
	}

}
