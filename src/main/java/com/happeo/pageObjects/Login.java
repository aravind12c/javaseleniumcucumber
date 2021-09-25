package com.happeo.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.happeo.webUtilities.PropertyUtils;

public class Login extends BasePage {

	private static By titlename = By.xpath("//div[@class = 'title margin-bottom-1rem']");
	private static By googlesigninbtn = By.xpath("//div[@class = 'google-signin-btn--text']");
	private static By username = By.xpath("//input[@type = 'email']");
	private static By nextbtn = By.xpath("//button[@type = 'button']/span[contains(text(),'Next')]");
	private static By password = By.xpath("//input[@type = 'password']");
	private static By dashboard = By.xpath("//div[@id = 'post-feed-mystream']");

	private static String expectedtitlename = "Happeo Staging";

	public static void presenceOfLoginScreen() {
		String actualtitlename = getTextOn(titlename);
		Assert.assertTrue(actualtitlename.contains(expectedtitlename));
	}

	public static void clickOnSignIn() {
		clickOn(googlesigninbtn);
	}

	public static void sendUsername() {
		sendKeysOn(username, PropertyUtils.configProperty("Username"));
		clickOn(nextbtn);
		pause(4);
	}

	public static void sendPassword() {
		sendKeysOn(password, PropertyUtils.configProperty("Password"));
		clickOn(nextbtn);
	}

	public static void presenceOfDashboard() {
		Assert.assertTrue(isElementDisplayed(dashboard));
	}
}