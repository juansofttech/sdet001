package com.challenge.beta_x.tests.igtests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.challenge.beta_x.pages.ig.StartSessionPage;
import com.challenge.beta_x.tests.BaseTest001;

public class TestIgCredentials extends BaseTest001 {

    /**
     * Data provider for valid credentials.
     * 
     * @return Object[][] containing valid username, password, and email rescue.
     */
    @DataProvider(name = "validCredentials", parallel = true)
    public Object[][] dpValidCredentials() {
        return new Object[][] {
                new Object[] { "sandyPapo", "doic8dbIDCNDUNCSXNn", "sabastianrbt0002@gmail.com" }
        };
    }

    /**
     * Data provider for invalid credentials.
     * 
     * @return Object[][] containing invalid username, password, and email rescue.
     */
    @DataProvider(name = "invalidCredentials", parallel = true)
    public Object[][] dpInvalidCredentials() {
        return new Object[][] {
                new Object[] { "invalidUser", "invalidPass", "invalidEmail@gmail.com" }
        };
    }

    /**
     * Test case to verify successful login with valid credentials.
     * 
     * @param username     Valid username.
     * @param passwd       Valid password.
     * @param emailRescue  Valid email rescue.
     * @throws InterruptedException
     */
    @Test(dataProvider = "validCredentials", priority = 1)
    public void testSuccessfulLogin(String username, String passwd, String emailRescue) throws InterruptedException {
        StartSessionPage sessionPage = new StartSessionPage(driver);
        sessionPage.startSessionHomePage(username, passwd);
        sessionPage.recoveryAccount();
        sessionPage.setEmailRescue(emailRescue);
        sessionPage.clickRescueButton();
    }

    /**
     * Test case to verify unsuccessful login with invalid credentials.
     * 
     * @param username     Invalid username.
     * @param passwd       Invalid password.
     * @param emailRescue  Invalid email rescue.
     * @throws InterruptedException
     */
    @Test(dataProvider = "invalidCredentials", priority = 2)
    public void testUnsuccessfulLogin(String username, String passwd, String emailRescue) throws InterruptedException {
        StartSessionPage sessionPage = new StartSessionPage(driver);
        sessionPage.startSessionHomePage(username, passwd);
        // Verify error message or expected behavior for invalid credentials
    }

    /**
     * Test case to verify password recovery with valid email.
     * 
     * @param username     Valid username.
     * @param passwd       Valid password.
     * @param emailRescue  Valid email rescue.
     * @throws InterruptedException
     */
    @Test(dataProvider = "validCredentials", priority = 3)
    public void testPasswordRecovery(String username, String passwd, String emailRescue) throws InterruptedException {
        StartSessionPage sessionPage = new StartSessionPage(driver);
        sessionPage.startSessionHomePage(username, passwd);
        sessionPage.recoveryAccount();
        sessionPage.setEmailRescue(emailRescue);
        sessionPage.clickRescueButton();
        // Verify password recovery email sent or expected behavior
    }

    /**
     * Test case to verify password recovery with invalid email.
     * 
     * @param username     Valid username.
     * @param passwd       Valid password.
     * @param emailRescue  Invalid email rescue.
     * @throws InterruptedException
     */
    @Test(dataProvider = "invalidCredentials", priority = 4)
    public void testPasswordRecoveryInvalidEmail(String username, String passwd, String emailRescue) throws InterruptedException {
        StartSessionPage sessionPage = new StartSessionPage(driver);
        sessionPage.startSessionHomePage(username, passwd);
        sessionPage.recoveryAccount();
        sessionPage.setEmailRescue(emailRescue);
        sessionPage.clickRescueButton();
        // Verify error message or expected behavior for invalid email
    }
}