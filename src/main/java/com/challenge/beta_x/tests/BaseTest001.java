package com.challenge.beta_x.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.challenge.beta_x.utils.PropertiesManager;
import com.challenge.beta_x.utils.drivertemplate.DriverFactory;

public class BaseTest001 {

	protected WebDriver driver;
	public static final Logger logger = Logger.getLogger(BaseTest001.class);

	@BeforeSuite(alwaysRun = true)
	public void Start_Engine() throws Exception {
		PropertiesManager.initializeProperties();
		logger.info("Properties Initialized");
	}

	@BeforeTest
	public void setUp() {
		driver = DriverFactory.getBrowser();

	}

	@BeforeMethod(alwaysRun = true)
	public void navigateToHomePage() throws Exception {
		String URL = PropertiesManager.getProperty("URL");
		driver.navigate().to(URL);
		logger.info("Navigated to " + URL);
	}

	/*
	 * @AfterMethod(alwaysRun = true) public void closeBrowser() throws Exception {
	 * driver.close(); }
	 * 
	 * @AfterTest public void tearDown() { driver.quit(); }
	 */

}
