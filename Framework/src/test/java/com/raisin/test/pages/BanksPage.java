package com.raisin.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.GenericComponents;

public class BanksPage {


	private static String bankTitles = "//div[@class='bank-archive-item-title']";
	private static String moodysCountryRating = "(.//span[@class='bank-archive-item-country-rating-score'])";
	private static String viewMore = "(.//i[@class='fa-chevron-right'])";
	private static String banktitle = "(.//div[@class='bank-archive-item-title'])";
	private static String investNowButton = "//*[@id=\"sticky-wrapper\"]/div[1]/div[2]/a[1]";
     
	
	GenericComponents object;
	WebDriver driver;
	
	public BanksPage(WebDriver driver){
		object = new GenericComponents();
		this.driver = driver;
	}
	
	public List<WebElement> list_Of_Banks_Displayed() {
		object.wait_For_Object_Exists(driver, By.xpath(bankTitles));
		return driver.findElements(By.xpath(bankTitles));
	}

	public WebElement moodys_Country_Rating_of_Index(int i) {
		object.wait_For_Object_Exists(driver, By.xpath(moodysCountryRating + "[" + i + "]"));
		return driver.findElement(By.xpath(moodysCountryRating + "[" + i + "]"));
	}
	
	public WebElement view_More_Of_Index(int i) {
		object.wait_For_Object_Exists(driver, By.xpath(viewMore + "[" + i + "]"));
		return driver.findElement(By.xpath(viewMore + "[" + i + "]"));
	}
	
	public WebElement bank_Title_Of_Index(int i) {
		object.wait_For_Object_Exists(driver, By.xpath(banktitle + "[" + i + "]/div/a"));
		return driver.findElement(By.xpath(banktitle + "[" + i + "]/div/a"));
	}
	
	public WebElement invest_Now_Button() {
		object.wait_For_Object_Exists(driver, By.xpath(investNowButton));
		return driver.findElement(By.xpath(investNowButton));
	}
}
