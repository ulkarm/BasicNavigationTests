package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.cbt.utilities.StringUtility.verifyEquals;

public class NavigationTests {
    public static void main(String[] args) {
        testChrome();
        //testFirefox();
        testSafari();

    }

    public static void testChrome(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        String googleTitle  = driver.getTitle();
        driver.get("https://etsy.com");
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        verifyEquals(googleTitle, driver.getTitle());
        driver.navigate().forward();
        verifyEquals(etsyTitle,driver.getTitle());

        driver.close();

    }

    public static void testFirefox(){
        WebDriver driver = BrowserFactory.getDriver("Firefox");
        driver.get("http://google.com");
        String googleTitle  = driver.getTitle();
        driver.get("https://etsy.com");
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        verifyEquals(googleTitle, driver.getTitle());
        driver.navigate().forward();
        verifyEquals(etsyTitle,driver.getTitle());

        driver.close();
    }

    public static void testSafari(){
        WebDriver driver = new SafariDriver();
        driver.get("http://google.com");
        String googleTitle  = driver.getTitle();
        driver.get("https://etsy.com");
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        verifyEquals(googleTitle, driver.getTitle());
        driver.navigate().forward();
        verifyEquals(etsyTitle,driver.getTitle());

        driver.close();
    }


}