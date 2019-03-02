package com.raisin.stepdefinitions;

import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.WebDriverFact;


public class LoginStepDef extends BaseClass {

	WebDriver driver;	 
    
    @Before
    public void load_Driver_And_Page_Objects() {
		driver = WebDriverFact.get_Driver(WebDriverFact.load_Properties_File().getProperty("Browser"));
		super.load_Page_Objects(driver);  			
    }
			
	 @Given("^User opens the Raisin url$")
	 public void user_Opens_The_RaisinUrl(){	 
		 driver.get("https://www.raisin.com");
		 driver.manage().window().maximize();
		 logger.info("Webbrowser opened and maximized");
	 }	
	
	 @When("^Selects the country \"([^\"]*)\"$")
	 public void selects_The_Country(String country){	 
		 Select Countrydrp = new Select(homePage.country_Dropdown());
		 Countrydrp.selectByVisibleText(country);
		 homePage.country_Ok_Button().click();
	 }
	
	 @When("^User clicks on offers page$")
	 public void user_Clicks_On_Offers_Page(){
		 homePage.our_Offers_Link().click();
	 }
	
	 @Then("^Offers header text should appear as per the value selected in the Term downdown$")
	 public void offers_header_text_should_appear_as_per_the_value_selected_in_the_Term_downdown() throws InterruptedException {
		 Thread.sleep(3000);
		 Select TermDrpDwn = new Select(ourOffersPage.term_Drop_Drown());
		 String drpdwnText = TermDrpDwn.getFirstSelectedOption().getText();
		 String Expected = drpdwnText.substring(drpdwnText.indexOf("(") + 1, drpdwnText.indexOf(")")) + " offers match your search" ;
		 String Actual = ourOffersPage.offers_List_Header().getText();
		 System.out.println("Expected:" + Expected + ";Actual:" + Actual);
		 Assert.assertEquals(Actual, Expected);
	 }	
	 
	 @And("^Selects EasyAccess check box$")
	 public void selects_EasyAccess_check_box() {
		 ourOffersPage.easy_Access_Checkbox().click();
	 }
	 
	 @When("^Clicks on the bank with highest interest rate$")
	 public void clicks_on_the_bank_with_highest_interest_rate() {
		 List<Double> OffersInterestRates = new ArrayList<Double>();
		 for(int i=1; i<=ourOffersPage.list_Of_Offers_Displayed().size(); i++) {
			 OffersInterestRates.add((Double.parseDouble(ourOffersPage.interest_Rate_Value_Of_Index(i).getText())));			
			}
		 int indx = OffersInterestRates.indexOf(Collections.max(OffersInterestRates)) + 1;
		 System.out.println("Highest Rate Of Intrest:" + Collections.max(OffersInterestRates));
		 ourOffersPage.register_Now_Button_Of_Index(indx).click();
	 }
	 
	 @Then("^User need to navigated to the banks registration page$")
	 public void user_need_to_navigated_to_the_banks_registration_page() {
		 System.out.println(driver.getCurrentUrl());
		 assertTrue(driver.getCurrentUrl().contains("www.raisin.com/register"));
	 }
	 
	 @After
	 public void close() {
		 driver.quit();
		 super.relase_Page_Objects();
		 super.relase_Driver();
	 }
}