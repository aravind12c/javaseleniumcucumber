package com.happeo.stepDefinitions;

import com.happeo.pageObjects.Channel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HappeoChannelStepDef {
	
	@Given("I am on the Dashboard screen")
	public void iamOnDashboardScreen() {
		Channel.presenceOfDashboard();
	}
	
	@When("I click on Channels Menu from menubar")
	public void iClickOnChannelsMenuFromMenubar() {
		Channel.clickOnChannelsBtn();
	}
	
	@And("I enter channel name as {string} in search box")
	public void iEnterChannelNameinSearchBox(String channelname) {
		Channel.sendChannelName(channelname);
	}
	
	@And("I click on {string}")
	public void iClickOnChannel(String channelname) {
		Channel.clickOnChannelName(channelname);
	}
	
	@Then("I verify whether am on {string} screen")
	public void iVerifyWhetherAmOnAptChannel(String channelname) {
		Channel.presenceOfChannel(channelname);
	}
	
	@When("I view one of the post from the channel")
	public void iViewOneOfThePostFromChannel() {
		Channel.clickOnActionBtn();
	}
	
	@And("I add reaction as {string} from default reaction list")
	public void iAddReactionFromDefaultReactionList(String reaction) {
		Channel.clickOnReaction(reaction);
	}
	
	@Then("I verify whether selected reaction {string} is added to the post")
	public void iVerifyWhatherSelectedReactionisAdded(String reaction) {
		Channel.presenceOfReaction(reaction);
	}
	
	@And("I view one of the post from the channel that is been already reacted")
	public void iViewOneofPostFromtheChannelThatisAlreadyReacted() {
		Channel.clickOnActionBtnforReactedPost();
	}
	
	@And("I {string} the reaction")
	public void iActOnReaction(String action) {
		if(action.equalsIgnoreCase("replace")) {
			Channel.clickToReplaceReaction();
		}
		else if(action.equalsIgnoreCase("remove")) {
			Channel.clickToRemoveReaction();
		}
	}
	
	@And("I verify whether the {string} took place")
	public void iVerifyActionTookPlace(String action) {
		Channel.verifyReaction(action);
	}
	
	@When("I enter something in Post in input area")
	public void iEnterSomethingInPostInInputArea() {
		Channel.sendKeysOnPost();
	}
	
	@And("I click on Post options to select share as an announcement")
	public void iClickOnPostOptionsToSelectShareAnnouncement() {
		Channel.clickOnPostOptionsandShareAnnouncement();
	}
	
	@And("I select expiry period as {string}")
	public void iSelectExpiryPeriod(String expprd) {
		Channel.clickOnexpiryDate(expprd);
	}
	
	@And("I click on Share button")
	public void iClickOnShareButton() {
		Channel.clickOnShareBtn();
	}
	
	@And("I verify whether the post is posted successfully with {string} period")
	public void iVerifyPostisPosted(String expprd) {
		Channel.verifyPostPostedWithExpDate(expprd);
	}

}