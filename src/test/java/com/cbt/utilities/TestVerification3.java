package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TestVerification3 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList( "https://wayfair.com/",
                "https://walmart.com", "https://westelm.com/");

        for (String url : urls) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(url);
            String title = driver.getTitle().toLowerCase().replace(" ", "");
            System.out.println(title);

            if (url.contains(title)){
                System.out.println("Test passed");
            } else {
                System.out.println("Test failed");
                System.out.println("url is: "+url);
                System.out.println("title is: "+title);
            }
            driver.close();
        }

    }
    }

