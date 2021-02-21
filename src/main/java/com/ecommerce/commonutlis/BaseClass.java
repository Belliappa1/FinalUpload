package com.ecommerce.commonutlis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public FileUtility fLib = new FileUtility();
	public static WebDriver driver;
		
	
		@BeforeClass()
		public void configureBeforeClass() throws Throwable {
			
			String URL  = fLib.getKeyValue("url");

			String BROWSER  = fLib.getKeyValue("browser");

			 if(BROWSER.equals("chrome")) {
			    driver = new ChromeDriver();
			 }else if(BROWSER.equals("firefox")) {
				 driver = new FirefoxDriver();
			 }else if(BROWSER.equals("ie")) {
				 driver = new InternetExplorerDriver();
			 }else {
				 driver = new ChromeDriver(); 
			 }
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);
		}
		
		@AfterClass
		public void configureAfterClass() {
			
			driver.close();
		}
		
		
}
