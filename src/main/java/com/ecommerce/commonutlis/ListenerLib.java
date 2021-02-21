package com.ecommerce.commonutlis;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerLib implements ITestListener {


	@Override
	public void onTestFailure(ITestResult result) {
String failedTestNAme = result.getMethod().getMethodName();
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.driver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		File dstFile = new File(IConstant.screenShot);
		
		try {
			FileUtils.copyFile(srcFile, dstFile);
		} catch (IOException e) {

		}
		
	}

}