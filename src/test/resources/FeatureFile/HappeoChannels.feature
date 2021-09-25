Feature: Happeo Assesment for Channels
Description: This feature will test given scenario as part of Assesment

Background: As a user, I want to Login into the app
	Given I am on the login screen
	When I click on sign in with google button
	And I enter username & password and click on next
	Then I am navigated to Dashboard screen
	
@test
Scenario Outline: As a user, I want to add a random reaction from random reaction list
	Given I am on the Dashboard screen
	When I click on Channels Menu from menubar
	And I enter channel name as "<channelname>" in search box
	And I click on "<channelname>"
	Then I verify whether am on "<channelname>" screen
	When I view one of the post from the channel
	And I add reaction as "<reaction>" from default reaction list
	Then I verify whether selected reaction "<reaction>" is added to the post
	Examples:
	|channelname|reaction|
	|Interview Channel|Celebrate|
	
@test
Scenario Outline: As a user, I want to replace or remove a random reaction from random reaction list
	Given I am on the Dashboard screen
	When I click on Channels Menu from menubar
	And I enter channel name as "<channelname>" in search box
	And I click on "<channelname>"
	Then I verify whether am on "<channelname>" screen
	When I view one of the post from the channel that is been already reacted
	And I "<action>" the reaction
	Then I verify whether the "<action>" took place
	Examples:
	|channelname|action|
	|Interview Channel|replace|
	|Interview Channel|remove|
	
@test
Scenario Outline: As a user, I want to create an Announcement
	Given I am on the Dashboard screen
	When I click on Channels Menu from menubar
	And I enter channel name as "<channelname>" in search box
	And I click on "<channelname>"
	Then I verify whether am on "<channelname>" screen
	When I enter something in Post in input area
	And I click on Post options to select share as an announcement
	And I select expiry period as "<expiry>" 
	And I click on Share button
	Then I verify whether the post is posted successfully with "<expiry>" period
	Examples:
	|channelname|expiry|
	|Interview Channel|Choose a custom date && 21/09/2021|
	|Interview Channel|2 week|