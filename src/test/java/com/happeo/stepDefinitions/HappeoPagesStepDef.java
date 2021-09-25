package com.happeo.stepDefinitions;

import com.happeo.pageObjects.Pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HappeoPagesStepDef {
	
	
	@When("I click on Pages Menu from menubar")
	public void iClickOnPagesMenuFromMenubar() {
		Pages.clickOnPagesBtn();
	}
	
	@And("I enter page name as {string} in search box")
	public void iEnterChannelNameinSearchBox(String pagename) {
		Pages.sendPageName(pagename);
	}
	
	@Then("I verify whether am on page")
	public void iVerifyWhetherAmOnAptChannel() {
		Pages.presenceOfPage();
	}
	
	@When("I click on Settings Icon and select Manage pages")
	public void iSelectSettingsIconandManagePages() {
		Pages.ClickOnSettingsIcon();
		Pages.ClickOnManagePages();
	}
	
	@And("I select Add sub page button from {string}")
	public void iAddReactionFromDefaultReactionList(String subpage) {
		Pages.clickOnAddSubpage(subpage);
	}
	
	@And("I enter some value in pagename field and click on create")
	public void iViewOneofPostFromtheChannelThatisAlreadyReacted() {
		Pages.iEnterStringinPagenameField();
	}
	
	@Then("I verify whether created new page is associated under {string}")
	public void iVerifyWhatherSelectedReactionisAdded(String subpage) {
		Pages.presenceOfNewCreatedPage(subpage);
	}
	
	@And("I enter some value in pagename and link and click on create")
	public void iENterSomeValueInPagenameandLink() {
		Pages.iEnterStringinPagenameFieldandLink();
	}
	

}