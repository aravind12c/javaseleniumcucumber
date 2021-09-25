package com.happeo.pageObjects;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.support.ui.WebDriverWait;
import com.happeo.driverInit.DriverInitialization;
import com.happeo.webUtilities.DateUtils;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage extends DriverInitialization {

	private static String waitstrategyvisible = "Visible";
	private static String waitstrategyclickable = "Clickable";

	protected static void clickOn(By by) {
		WebElement element = performExplicitWait(waitstrategyclickable, by);
		element.click();
	}

	protected static boolean isElementDisplayed(By by) {
		boolean flag = false;
		WebElement element = performExplicitWait(waitstrategyvisible, by);
		if (element.isDisplayed()) {
			flag = true;
		}
		return flag;
	}

	protected static String getTextOn(By by) {
		WebElement element = performExplicitWait(waitstrategyvisible, by);
		return element.getText();
	}

	protected static String getAttributeOn(By by, String key) {
		WebElement element = performExplicitWait(waitstrategyvisible, by);
		return element.getAttribute(key);
	}

	protected static void sendKeysOn(By by, String value) {
		WebElement element = performExplicitWait(waitstrategyclickable, by);
		element.sendKeys(value);
	}

	protected static void pause(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}

	protected static int getNumOfElements(By by) {
		List<WebElement> ele = driver.findElements(by);
		int i = ele.size();
		return i;
	}

	protected static void moveToElement(By by) {
		Actions actions = new Actions(driver);
		WebElement element = performExplicitWait(waitstrategyvisible, by);
		actions.moveToElement(element).perform();
	}

	protected static List<WebElement> listOfElements(By by) {
		List<WebElement> ele = driver.findElements(by);
		return ele;
	}

	protected static WebElement performExplicitWait(String waitstrategy, By by) {
		WebElement element = null;
		if (waitstrategy.equalsIgnoreCase("Clickable")) {
			element = new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitstrategy.equalsIgnoreCase("Visible")) {
			element = new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitstrategy.equalsIgnoreCase("None")) {
			element = driver.findElement(by);
		}
		return element;
	}

	protected static void setValueinClipboard(String clipboardtext) {
		StringSelection stringSelection = new StringSelection(clipboardtext);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}

	protected static void sendActionKeysOn(By by, String controlkey) {
		clickOn(by);
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(controlkey).keyUp(Keys.CONTROL).build().perform();
	}

	protected static void clickDoubleClickOn(By by) {
		WebElement element = performExplicitWait(waitstrategyclickable, by);
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	protected static String getDate(String dates, String key) {
		return DateUtils.fetchSpecifics(dates, key);
	}

	protected static String getDateAddition(int noOfDays) {
		return DateUtils.dateAddition(noOfDays);
	}

	protected static String getCompleteDate(String dates) {
		String date = DateUtils.fetchSpecifics(dates, "day");
		String completemonth = DateUtils.getMonth(DateUtils.fetchSpecifics(dates, "month"));
		String year = DateUtils.fetchSpecifics(dates, "year");
		return date + " " + completemonth + " " + year;
	}

	protected static String getRandomNo() {
		Random random = new Random();
		int randomnumber = random.nextInt(1000);
		return String.valueOf(randomnumber);
	}

	protected static void scrollTillElement(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = performExplicitWait(waitstrategyvisible, by);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

}
