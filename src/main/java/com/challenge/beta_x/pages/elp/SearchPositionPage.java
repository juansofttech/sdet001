package com.challenge.beta_x.pages.elp;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.challenge.beta_x.pages.BasePage;

public class SearchPositionPage extends BasePage {

	public SearchPositionPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[id='searchBox']")
	private WebElement searchInput;
	@FindBy(css = "[class='form-group form-inline ee-searchbox'] button")
	private WebElement searchButton;
	@FindBy(css = "ul[class='list-unstyled result-info'] li:first-of-type")
	private List<WebElement> namesPosition;

	public void setSearchBoxText(String position) {
		searchInput.sendKeys(position);
	}

	public void clickOnSearch() {
		searchButton.click();
	}

	public PositionResults resultsPosition(String position) {
		setSearchBoxText(position);
		clickOnSearch();
		selectPosition();
		return new PositionResults(driver);
	}

	public void selectPosition() {
		List<WebElement> positions = namesPosition;
		for (WebElement job : positions) {
			job.click();
		}

	}

}
