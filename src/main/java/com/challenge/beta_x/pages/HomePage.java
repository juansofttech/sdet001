package com.challenge.beta_x.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.challenge.beta_x.pages.elp.SearchPositionPage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[class='box empleo'] img")
	private WebElement buttonHome;
	@FindBy(css = "[data-user-type='Company'] h2")
	private WebElement labelTitle;

	public void selectBox() {
		buttonHome.click();
	}

	public String getTitlBox() {
		return labelTitle.getText();
	}

	public SearchPositionPage jobVacanciesPage() {
		selectBox();
		return new SearchPositionPage(driver);
	}

}
