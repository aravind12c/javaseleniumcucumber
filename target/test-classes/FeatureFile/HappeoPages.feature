Feature: Happeo Assesment for Pages
Description: This feature will test given scenario as part of Assesment

Background: As a user, I want to Login into the app
	Given I am on the login screen
	When I click on sign in with google button
	And I enter username & password and click on next
	Then I am navigated to Dashboard screen
	
@test
Scenario Outline: As a user, I to add a Sub page under Firstpage
	Given I am on the Dashboard screen
	When I click on Pages Menu from menubar
	And I enter page name as "<pagename>" in search box
	And I click on "<pagename>"
	Then I verify whether am on page
	When I click on Settings Icon and select Manage pages
	And I select Add sub page button from "<subpage>"
	And I enter some value in pagename field and click on create
	Then I verify whether created new page is associated under "<subpage>"
	Examples:
	|pagename|subpage|
	|This Page Group|First Page|

@test
Scenario Outline: As a user, I to add a Sub Link under Firstpage
	Given I am on the Dashboard screen
	When I click on Pages Menu from menubar
	And I enter page name as "<pagename>" in search box
	And I click on "<pagename>"
	Then I verify whether am on page
	When I click on Settings Icon and select Manage pages
	And I select Add sub page button from "<subpage>"
	And I enter some value in pagename and link and click on create
	Then I verify whether created new page is associated under "<subpage>"
	Examples:
	|pagename|subpage|
	|This Page Group|First Page|