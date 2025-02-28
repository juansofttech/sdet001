package com.challenge.beta_x.pages.ig;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.challenge.beta_x.pages.BasePage;

public class StartSessionPage extends BasePage {

	public StartSessionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameInput;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement psswdInput;
	@FindBy(css = "button[class='_acan _acap _acas _aj1-']")
	private WebElement logInButton;
	@FindBy(id = "slfErrorAlert")
	private WebElement labelErrorMessageLogIn;
	@FindBy(xpath = "//a[normalize-space()='Forgot password?']")
	private WebElement labelForgotPasswd;
	@FindBy(name = "cppEmailOrUsername")
	private WebElement troubleLoggingInput;
	@FindBy(xpath = "//div[@role='button']")
	private WebElement buttonRescueAccount;

	public void startSessionHomePage(String user, String psswd) {
		setUserName(user);
		setPsswd(psswd);
		clickButtonLogin();
	}

	public void setEmailRescue(String emailRescue) {
		troubleLoggingInput.sendKeys(emailRescue);
	}

	public void setUserName(String userName) {
		userNameInput.sendKeys(userName);
	}

	public void clickButtonLogin() {
		logInButton.click();
	}

	public void clickRescueButton() throws InterruptedException {
		buttonRescueAccount.click();

		while (isVisibleButton()) {
			WebDriverWait webdwait = new WebDriverWait(driver, Duration.ofSeconds(50));
			webdwait.until(ExpectedConditions.elementToBeClickable(buttonRescueAccount));

			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.cssSelector("//div[@role='button']"));
			action.moveToElement(element).click().perform();
			buttonRescueAccount.click();
		}

	}

	public boolean isVisibleButton() {
		return buttonRescueAccount.isDisplayed();

	}

	public void setPsswd(String passwd) {
		psswdInput.sendKeys(passwd);
	}

	protected String getErrorMessageIncorrectCredentials() {
		return labelErrorMessageLogIn.getText();
	}

	public boolean errorCredentialMessageVisible() {
		return labelErrorMessageLogIn.isDisplayed();
	}

	public void recoveryAccount() {
		if (errorCredentialMessageVisible()) {
			labelForgotPasswd.click();
		}

	}

}
