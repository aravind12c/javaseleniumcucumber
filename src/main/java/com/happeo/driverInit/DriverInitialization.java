package com.happeo.driverInit;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.happeo.webUtilities.PropertyUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverInitialization {
	public static WebDriver driver;
	
	@Before
	public static void driverInit() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
		options.setCapability("platform", "Any");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get(PropertyUtils.configProperty("URL"));
		driver.manage().window().maximize();
	}
	
	@After
	public static void teardown() {
		driver.quit();
		
	}
}
