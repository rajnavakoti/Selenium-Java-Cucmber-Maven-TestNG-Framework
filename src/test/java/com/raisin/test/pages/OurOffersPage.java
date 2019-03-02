package com.raisin.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.GenericComponents;

public class OurOffersPage {
	
	private static String interestRateValue = "(.//div[@class='prot-offer-header-interest-value ng-binding'])";
	private static String offers = "//div[@class='prot-offers-container clearfix']/div";
	private static String registerNowButton = "(.//span[text()='Register now'])";
	private static String termDropDrown = "//select[@name='investment_term']";
	private static String offersListHeader = "//div[@class='prot-listing-count']/span";
	private static String easyAccessCheckbox = "//input[@id='early_termination_cb']";
	
	GenericComponents object;
	WebDriver driver;
	
	public OurOffersPage(WebDriver driver){
		object = new GenericComponents();
		this.driver = driver;
	}
	
	public List<WebElement> list_Of_Offers_Displayed() {
		object.wait_For_Object_Exists(driver, By.xpath(offers));
		return driver.findElements(By.xpath(offers));
	}
	
	public WebElement interest_Rate_Value_Of_Index(int i) {
		object.wait_For_Object_Exists(driver, By.xpath(interestRateValue + "[" + i + "]"));
		return driver.findElement(By.xpath(interestRateValue + "[" + i + "]"));
	}
	
	public WebElement register_Now_Button_Of_Index(int i) {
		object.wait_For_Object_Exists(driver, By.xpath(registerNowButton + "[" + i + "]"));
		return driver.findElement(By.xpath(registerNowButton + "[" + i + "]"));
	}
	
	public WebElement term_Drop_Drown() {
		object.wait_For_Object_Exists(driver, By.xpath(termDropDrown));
		return driver.findElement(By.xpath(termDropDrown));
	}
	
	public WebElement offers_List_Header() {
		object.wait_For_Object_Exists(driver, By.xpath(offersListHeader));
		return driver.findElement(By.xpath(offersListHeader));
	}
	
	public WebElement easy_Access_Checkbox() {
		object.wait_For_Object_Exists(driver, By.xpath(easyAccessCheckbox));
		return driver.findElement(By.xpath(easyAccessCheckbox));
	}

}
