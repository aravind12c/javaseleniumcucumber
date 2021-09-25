package com.happeo.stepDefinitions;

import com.happeo.pageObjects.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HappeoLoginStepDef {

	@Given("I am on the login screen")
	public void iamOnLoginScreen() {
		Login.presenceOfLoginScreen();
	}

	@When("I click on sign in with google button")
	public void iClickOnSignInWithGoogleAcc() {
		Login.clickOnSignIn();
	}

	@And("I enter username & password and click on next")
	public void iEnterUsernamePassowordandClickonNext() {
		Login.sendUsername();
		Login.sendPassword();
	}

	@Then("I am navigated to Dashboard screen")
	public void iNavigatedtoDashboardScreen() {
		Login.presenceOfDashboard();
	}

}
