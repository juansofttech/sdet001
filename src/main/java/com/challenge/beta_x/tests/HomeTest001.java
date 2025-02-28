package com.challenge.beta_x.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.challenge.beta_x.pages.HomePage;

public class HomeTest001 extends BaseTest001 {

	@Test()
	public void validate2Box() {
		HomePage homePage = new HomePage(driver);
		assertEquals(homePage.getTitlBox(), "Busco candidatos");
		homePage.selectBox();
	}

}
