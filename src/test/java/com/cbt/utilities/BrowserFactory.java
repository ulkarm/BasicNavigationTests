package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class BrowserFactory {

    public static WebDriver getDriver(String browser) {

        // finding your operating system name
        String osName = System.getProperty("os.name");
        System.out.println(osName);

           // WebDriver driver = new SafariDriver();

        if (browser.equalsIgnoreCase("Safari")){
            WebDriver driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")){
            return null;
        }
        return null;
    }
}




