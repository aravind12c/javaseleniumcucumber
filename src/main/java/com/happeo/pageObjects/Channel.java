package com.happeo.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.happeo.webUtilities.WordUtils;

public class Channel extends BasePage {

	private static By dashboard = By.xpath("//div[@id = 'post-feed-mystream']");
	private static By channelbtn = By.xpath("//button[@id = 'nav-channels-button']");
	private static By searchbox = By.xpath("//input[@id = 'nav-channels-search']");
	private static By actionmenuicn = By.xpath(
			"(//button[@aria-label='Reactions']/p/ancestor::div/div/div/div/div/button[@aria-label = 'Post actions menu'])[1]");
	private static By actionmenuicnfrreactedpost = By.xpath(
			"(//button[@aria-label='Reactions']/div/p/ancestor::div/div/div/div/div/button[@aria-label = 'Post actions menu'])[1]");
	private static By viewpostbtn = By.xpath("//p[contains(text(),'View post')]");
	private static By backbtn = By.xpath("//span[contains(text(),'Back')]");
	private static By posts = By.xpath("//div[contains(@id,'post')]");
	private static By reactionarea = By.xpath("//button[@aria-label='Reactions']");
	private static By reactionareatext = By.xpath("//button[@aria-label='Reactions']/div/p");
	private static By channelheader = By.xpath("//div[contains(@class, 'channel-header--title')]/h1");
	private static By nonreactionareatext = By.xpath("//div[@data-tracker = 'reactions']/button/p");
	private static By defemoji = By.xpath("//a[@data-tip = 'Interesting']");
	private static By postinputarea = By
			.xpath("//div[@role = 'application']/div[contains(@class, 'show-placeholder')]/div/p");
	private static By postoptions = By.xpath("//button[@aria-label='Post options']");
	private static By shareannouncement = By.xpath("//li[@data-tracker='Publish']");
	private static By shareannouncementtitle = By.xpath("//h2[contains(text(), 'Share as an announcement')]");
	private static By parentdropdown = By.xpath("//div[contains(@class, 'dropdown__control')]");
	private static By monthandyear = By.xpath("//button[@aria-label='Select year and month']");
	private static By monthyeardone = By.xpath("//button[@data-for='datepicker-year-month-done']");
	private static By dateinput = By.xpath("//div[@class = 'DayPickerInput']/div/input");
	private static By sharebtn = By.xpath("//p[text() = 'Share']");
	private static By expirymsg = By
			.xpath("(//div[contains(@id,'post')]/div/div/div/div/p[contains(text(),'Expire')])[1]");

	public static void presenceOfDashboard() {
		Boolean actual = isElementDisplayed(dashboard);
		Assert.assertEquals(actual, true);
	}

	public static void clickOnChannelsBtn() {
		clickOn(channelbtn);
	}

	public static void sendChannelName(String channelname) {
		sendKeysOn(searchbox, channelname);
	}

	public static void clickOnChannelName(String channelname) {
		By searchresult = By.xpath("(//mark[contains(text(),'" + channelname + "')])[1]");
		clickOn(searchresult);
	}

	public static void clickOnActionBtn() {
		clickOn(actionmenuicn);
		clickOn(viewpostbtn);
		pause(3);
		Boolean actual = isElementDisplayed(backbtn);
		Assert.assertEquals(actual, true);
		int noofposts = getNumOfElements(posts);
		Assert.assertTrue(noofposts == 1);
	}

	public static void clickOnReaction(String reaction) {
		moveToElement(reactionarea);
		By emoji = By.xpath("//a[@data-tip = '" + reaction + "']");
		moveToElement(emoji);
		clickOn(emoji);
		pause(2);
	}

	public static void clickToReplaceReaction() {
		moveToElement(reactionarea);
		moveToElement(defemoji);
		clickOn(defemoji);
	}

	public static void clickToRemoveReaction() {
		clickOn(reactionarea);
	}

	public static void verifyReaction(String action) {
		if (action.equalsIgnoreCase("replace")) {
			String actualreaction = getTextOn(reactionareatext);
			Assert.assertEquals("Interesting", actualreaction);
		} else if (action.equalsIgnoreCase("remove")) {
			String actualreaction = getTextOn(nonreactionareatext);
			Assert.assertEquals("Like", actualreaction);
		}
	}

	public static void presenceOfReaction(String reaction) {
		String actualreaction = getTextOn(reactionareatext);
		Assert.assertEquals(reaction, actualreaction);
	}

	public static void presenceOfChannel(String channelname) {
		String actualchannelname = getTextOn(channelheader);
		Assert.assertEquals(channelname, actualchannelname);
	}

	public static void clickOnActionBtnforReactedPost() {
		clickOn(actionmenuicnfrreactedpost);
		clickOn(viewpostbtn);
		pause(3);
		Boolean actual = isElementDisplayed(backbtn);
		Assert.assertEquals(actual, true);
		int noofposts = getNumOfElements(posts);
		Assert.assertTrue(noofposts == 1);
	}

	public static void sendKeysOnPost() {
		setValueinClipboard(WordUtils.wordExtracter());
		sendActionKeysOn(postinputarea, "V");
	}

	public static void clickOnPostOptionsandShareAnnouncement() {
		clickOn(postoptions);
		clickOn(shareannouncement);
		Assert.assertTrue(isElementDisplayed(shareannouncementtitle));
	}

	public static void clickOnexpiryDate(String expperiod) {
		clickOn(parentdropdown);
		By by;
		if (expperiod.contains("Choose a custom date")) {
			by = By.xpath("//div[contains(@class, 'dropdown__menu')]/div[contains(text(),'" + expperiod.split(" && ")[0]
					+ "')]");
			clickOn(by);
			pause(1);
			clickDoubleClickOn(dateinput);
			clickOn(monthandyear);
			String date = expperiod.split(" && ")[1];
			System.out.println(date);
			by = By.xpath("//button[contains(@class,'DatePicker__Month')]/div/p[contains(text(),'"
					+ getDate(date, "month") + "')]");
			clickOn(by);
			clickOn(monthyeardone);
			by = By.xpath("//div[@class = 'DayPicker-Day' and text() = '" + getDate(date, "day") + "']");
			clickOn(by);
			Assert.assertEquals(date, getAttributeOn(dateinput, "value"));

		} else {
			by = By.xpath("//div[contains(@class, 'dropdown__menu')]/div[contains(text(),'" + expperiod + "')]");
			clickOn(by);
		}
	}

	public static void clickOnShareBtn() {
		clickOn(sharebtn);
		clickOn(sharebtn);
	}

	public static void verifyPostPostedWithExpDate(String expperiod) {
		pause(5);
		if (expperiod.contains("2 weeks")) {
			Assert.assertTrue(getTextOn(expirymsg).contains(getCompleteDate(getDateAddition(14))));
		} else if (expperiod.contains("Choose a custom date")) {
			Assert.assertTrue(getTextOn(expirymsg).contains("Expired"));
		}

	}

}