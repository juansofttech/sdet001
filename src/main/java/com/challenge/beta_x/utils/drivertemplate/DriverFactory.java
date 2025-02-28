package com.challenge.beta_x.utils.drivertemplate;

import static com.challenge.beta_x.utils.drivertemplate.DriverType.CHROME;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    /**
     * Gets the WebDriver instance based on the specified browser type.
     * 
     * @return WebDriver instance.
     */
    public static WebDriver getBrowser() {
        WebDriver driver = null;
        String browserName = System.getProperty("browser", CHROME.toString()).toUpperCase();
        DriverType driverType = DriverType.valueOf(browserName);

        // Set up the WebDriver based on the specified browser type
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        // Configure implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }

    /**
     * Configures Chrome-specific options.
     * 
     * @return ChromeOptions instance with predefined settings.
     */
    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        
        // Disable notifications and password manager
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");

        return options;
    }
}