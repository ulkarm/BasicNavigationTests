package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    public static void main(String[] args) {
        List<String> urls = Arrays.asList( "https://luluandgeorgia.com","https://wayfair.com/",
                "https://walmart.com", "https://westelm.com/");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        for (String url : urls) {
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
        }

            driver.close();
        }
    }
