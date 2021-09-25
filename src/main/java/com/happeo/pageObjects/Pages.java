package com.happeo.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;

public class Pages extends BasePage {

	private static By pagebtn = By.xpath("//button[@id = 'nav-pages-button']");
	private static By searchbox = By.xpath("//input[@id = 'nav-pages-search']");
	private static By pageediticon = By.xpath("//a[@gapps-tooltip='Edit Page']");
	private static By managepagesbtn = By.xpath("//span[contains(text(), 'Manage pages')]");
	private static By page = By.xpath("//div[@class = 'page__background']");
	private static By subpagebtn = By.xpath("//p[text() = 'Add sub-page']");
	private static By inputfield = By.xpath("//input[@id = 'newPageModalInput']");
	private static By inputurl = By.xpath("//input[@name = 'url']");
	private static By createbtn = By.xpath("//button[@type = 'submit']");
	private static By newlinktab = By.xpath("//span[text() = 'New link']");

	private static String pagename;

	public static void clickOnPagesBtn() {
		clickOn(pagebtn);
	}

	public static void sendPageName(String pagename) {
		sendKeysOn(searchbox, pagename);
	}

	public static void presenceOfPage() {
		Assert.assertTrue(isElementDisplayed(page));
	}

	public static void ClickOnSettingsIcon() {
		clickOn(pageediticon);
	}

	public static void ClickOnManagePages() {
		clickOn(managepagesbtn);
	}

	public static void clickOnAddSubpage(String subpage) {
		By by = By.xpath("(//div[contains(text(),'" + subpage + "')]/ancestor::div/universe-dropdown)[1]");
		clickOn(by);
		clickOn(subpagebtn);
	}

	public static void iEnterStringinPagenameField() {
		pagename = "Assesment Test " + getRandomNo();
		sendKeysOn(inputfield, pagename);
		clickOn(createbtn);
		pause(10);
	}

	public static void presenceOfNewCreatedPage(String subpage) {
		By subpageexpansion = By
				.xpath("(//a[@name = '" + subpage + "']/parent::div/a[contains(@class,'item--expand')])[1]");
		clickOn(subpageexpansion);
		By subpages = By.xpath("//a[text() = '" + pagename + "']");
		scrollTillElement(subpages);
		Assert.assertTrue(isElementDisplayed(subpages));
	}

	public static void iEnterStringinPagenameFieldandLink() {
		clickOn(newlinktab);
		pagename = "Assesment Test " + getRandomNo();
		sendKeysOn(inputfield, pagename);
		sendKeysOn(inputurl, "google.com");
		clickOn(createbtn);
		pause(10);
	}

}
