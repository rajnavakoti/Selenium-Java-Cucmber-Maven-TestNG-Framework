package com.raisin.stepdefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.raisin.test.pages.BanksPage;
import com.raisin.test.pages.HomePage;
import com.raisin.test.pages.OurOffersPage;

import util.Browser;
import util.GeneralFunctions;
import util.GenericComponents;

public class BaseClass {
	WebDriver driver;	 
    Properties properties;
	HomePage homePage;
	BanksPage banksPage;
	OurOffersPage ourOffersPage;
	GenericComponents object ;
	Browser browser;
	String homeurl;
	String registrationPageUrl;
	GeneralFunctions general;
	
	Logger logger = Logger.getLogger(BaseClass.class);

	public void load_Page_Objects(WebDriver driver) {
		homePage = new HomePage(driver);
    	ourOffersPage = new OurOffersPage(driver);
    	PropertyConfigurator.configure(System.getProperty("user.dir")+"/log4j.properties");
	}
	
	public void relase_Page_Objects() {
		homePage=null;
		ourOffersPage=null;
	}
	
	public void relase_Driver() {
		driver=null;
	}
}
