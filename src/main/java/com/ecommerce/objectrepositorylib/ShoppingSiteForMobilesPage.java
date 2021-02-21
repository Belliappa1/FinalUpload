package com.ecommerce.objectrepositorylib;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingSiteForMobilesPage {

	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement loginPage;
	
	@FindBy(name="q")
	private WebElement searchBox;
	
	@FindBy(xpath="//span[contains(text(),'Showing 1 – 24')]")
	private WebElement rangeCheck;
	
	@FindBy(xpath="//div[@class='_4rR01T']")
	private List<WebElement> iphoneDevices;
	

	public WebElement getloginPage() {
		return loginPage;
	}

	public WebElement getsearchBox() {
		return searchBox;
	}

	public WebElement rangeCheck() {
	return rangeCheck;
	}

	public List<WebElement>getiphoneDevices() {
		return iphoneDevices;
	}

	public List<WebElement>getiphoneRatings() {
		return iphoneRatings;
	}

	public List<WebElement> getiphonePrices() {
		return iphonePrices;
	}

	@FindBy(xpath="//span[contains(text(),'Ratings')]")
	private List<WebElement>iphoneRatings;
	
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private List<WebElement>iphonePrices;
	
	public WebElement getPage(){
		return loginPage;
	}

	public ShoppingSiteForMobilesPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
}
