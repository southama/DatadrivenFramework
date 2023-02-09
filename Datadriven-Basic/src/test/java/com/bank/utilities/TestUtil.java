package com.bank.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.bank.base.TestBase;

public class TestUtil extends TestBase {
	
 public static String screenshotname;
	
	public static void captureScreenshot() throws IOException {
		File srcfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotname=d.toString().replace(" ", "_").replace(":", "_")+".jpg";
		FileHandler.copy(srcfile, new File(System.getProperty("user.dir")+"\\test-output\\html\\"+screenshotname));
	
	}
	
	

}
