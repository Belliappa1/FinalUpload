package com.ecommercetest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.commonutlis.BaseClass;
import com.ecommerce.commonutlis.IConstant;
import com.ecommerce.objectrepositorylib.ShoppingSiteForMobilesPage;
import com.opencsv.CSVWriter;

public class SearchIphoneTest extends BaseClass {

	@Test
	 public void iphonesearch() throws IOException
	 {
		ShoppingSiteForMobilesPage sm=new ShoppingSiteForMobilesPage(driver);
		sm.getloginPage().click();
		sm.getsearchBox().sendKeys("iphones less than price 40000",Keys.ENTER);
		String title = driver.getTitle();
		System.out.println(title);
		WebElement showingResult = sm.rangeCheck();
		Assert.assertEquals(showingResult.isDisplayed(), true);
		List<WebElement> devices = sm.getiphoneDevices();
		List<WebElement> prices = sm.getiphonePrices();
		List<WebElement> ratings = sm.getiphoneRatings();
		String[] columnName = {"Iphone Details", "Price", "Ratings"};
		List<String[]> list = new ArrayList<String[]>();
		list.add(0,columnName);
		for(int i=0;i<devices.size();i++)
		{
			String[] details = {devices.get(i).getText(),prices.get(i).getText().substring(1),ratings.get(i).getText()};
			list.add(i, details);
		}
	
		CSVWriter write = new CSVWriter(new FileWriter(IConstant.csvpath));
		write.writeAll(list);
		write.close();
	}
}
