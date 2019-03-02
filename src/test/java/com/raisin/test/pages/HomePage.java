package com.raisin.test.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.GenericComponents;

public class HomePage {
	
	private static String countryChoice = "//select[@name='country_choice']";
	private static String countryOkbutton = "//button[text()='OK']";
	private static String banksOption = "//a[text()='Banks']";
	private static String ourOffersOption = "//a[text()='Our Offers']";
	private static String importantInfo = "//div[@class='modal-dialog modal-ml']";
	private static String iUnderstandButton = "//a[text()='I Understand']";
	private static String welcomeBonusScreen = "//div[@class='modal-dialog modal-lg']";
	private static String closeButton = "//div[@class='modal-dialog modal-lg']/div/div/button";
	
	GenericComponents object;
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		object = new GenericComponents();
		this.driver = driver;
	}

	
	public WebElement country_Dropdown() {
		object.wait_For_Object_Exists(driver, By.xpath(countryChoice));
		return driver.findElement(By.xpath(countryChoice));
	}
	
	public WebElement country_Ok_Button() {
		object.wait_For_Object_Exists(driver, By.xpath(countryOkbutton));
		return driver.findElement(By.xpath(countryOkbutton));
	}
	
	public WebElement banks_Link() {
		object.wait_For_Object_Exists(driver, By.xpath(banksOption));
		return driver.findElement(By.xpath(banksOption));
	}
	
	public WebElement our_Offers_Link() {
		object.wait_For_Object_Exists(driver, By.xpath(ourOffersOption));
		return driver.findElement(By.xpath(ourOffersOption));
	}
	
	public WebElement important_Info() {
		object.wait_For_Object_Exists(driver, By.xpath(importantInfo));
		return driver.findElement(By.xpath(importantInfo));
	}
	
	public WebElement i_Understand_Button() {
		object.wait_For_Object_Exists(driver, By.xpath(iUnderstandButton));
		return driver.findElement(By.xpath(iUnderstandButton));
	}
	
	public WebElement welcome_Bonus_Screen() {
		object.wait_For_Object_Exists(driver, By.xpath(welcomeBonusScreen));
		return driver.findElement(By.xpath(welcomeBonusScreen));
	}
	
	public WebElement close_Button() {
		object.wait_For_Object_Exists(driver, By.xpath(closeButton));
		return driver.findElement(By.xpath(closeButton));
	}
}
