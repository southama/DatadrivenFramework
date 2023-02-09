package com.bank.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bank.base.TestBase;

public class AddCustomerTest extends TestBase {
	
	@Test(dataProvider="getData")
	public void addCustomer(String firstname,String lastname,String postcode,String alerttext) throws InterruptedException {
		
	driver.findElement(By.xpath(OR.getProperty("addcus"))).click();
	driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstname);
	driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastname);
	driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postcode);
	driver.findElement(By.xpath(OR.getProperty("addbutton"))).click();
	
	
	Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	Assert.assertTrue(alert.getText().contains(alerttext), "Login not sucessful");
	Thread.sleep(2000);
	alert.accept();
	//Reporter.log("Customer added Successfuly");	
	
//	Assert.fail("Customer not added Successfuly");
			
	
	
	}
	@DataProvider
	public Object[][] getData(){
		String sheetname ="AddCustomerTest";
		int rows = excel.getRowCount(sheetname);
		int cols = excel.getColumnCount(sheetname);
		
		Object[][] data = new Object[rows-1][cols];
		for(int row =2;row<=rows;row++) {
			for(int col =0;col<cols;col++) {
				data[row-2][col] =excel.getCellData(sheetname, col, row);
			}
		}
		return data;
	}
	
	

}
