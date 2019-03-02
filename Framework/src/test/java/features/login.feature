Feature: Free CRM Login Feature

Background: User login
	Given User opens the Raisin url

Scenario: Verify the offers header text on the offers page

	When Selects the country "Other"
	When User clicks on offers page
	Then Offers header text should appear as per the value selected in the Term downdown

Scenario: Verify user is able to navigate to registration page of bank with highest interest rate

	When Selects the country "Other"
	When User clicks on offers page
	And Selects EasyAccess check box
	When Clicks on the bank with highest interest rate
	Then User need to navigated to the banks registration page
