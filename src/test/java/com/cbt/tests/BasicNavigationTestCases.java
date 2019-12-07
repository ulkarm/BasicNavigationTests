package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasicNavigationTestCases {

    public static void main(String[] args) {

        TestCase1();
        TestCase2();
        TestCase3();
        TestCase4();
        TestCase5();
        TestCase6();
        TestCase7();
        TestCase8();

    }

    public static void TestCase1(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Ulkar Mahaddin");
        driver.findElement(By.name("email")).sendKeys("random@email.com");
        driver.findElement(By.name("wooden_spoon")).click();

        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = driver.findElement(By.name("signup_message")).getText();
        StringUtility.verifyEquals(expectedMessage,actualMessage);

        WebElement homeBtn = driver.findElement(By.id("wooden_spoon"));
        homeBtn.isDisplayed();

        driver.quit();

    }

    public static void TestCase2(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        List<WebElement> examples = driver.findElements(By.className("list-group-item"));
        int expected= 48;
        int actual = examples.size();

        if(expected==actual){
            System.out.println("Test passed");
        } else {
            System.out.println("Test Failed");
            System.out.println("expected number is: "+expected);
            System.out.println("actual number is: "+actual);
        }
        driver.quit();
    }

    public static void TestCase3(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.cssSelector("[onclick='button1()']")).click();

        String expectedMessage = "Clicked on button one!";
        String actualMessage = driver.findElement(By.cssSelector("[style='color:green']")).getText();
        StringUtility.verifyEquals(expectedMessage,actualMessage);
        driver.quit();
    }

    public static void TestCase4(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("123");

        String expectedMessage = "first name can only consist of alphabetical letters";
        String actualMessage = driver.findElement(By.xpath("//small[@class=contains(text(),'first name can only consist ')]")).getText();
        StringUtility.verifyEquals(expectedMessage,actualMessage);
        driver.quit();
    }

    public static void TestCase5(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[data-bv-field='lastname']")).sendKeys("123");

        String expectedMessage = "The last name can only consist of alphabetical letters and dash";
        String actualMessage = driver.findElement(By.xpath("//small[@class=contains(text(),'The last name can only consist ')]")).getText();
        StringUtility.verifyEquals(expectedMessage,actualMessage);
        driver.quit();
    }

    public static void TestCase6(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[placeholder='username']")).sendKeys("user");
        String expectedMessage = "The username must be more than 6 and less than 30 characters long";
        String actualMessage = driver.findElement(By.xpath("//small[@class=contains(text(), 'The username must')]")).getText();
        StringUtility.verifyEquals(expectedMessage,actualMessage);
        driver.quit();
    }

    public static void TestCase7(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[data-bv-field='email']")).sendKeys("testers@email");
        String expectedMessage1 = "email address is not a valid";
        String actualMessage1 = driver.findElement(By.xpath("//small[@class=contains(text(), 'email address is not')]")).getText();
        StringUtility.verifyEquals(expectedMessage1,actualMessage1);

        String expectedMessage2 = "Email format is not correct";
        String actualMessage2 = driver.findElement(By.xpath("//small[@class=contains(text(), 'Email format')]")).getText();
        StringUtility.verifyEquals(expectedMessage2, actualMessage2);

        driver.quit();

    }

    public static void TestCase8(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[data-bv-field='phone']")).sendKeys("5711234354");
        String expectedMessage = "Phone format is not correct";
        String actualMessage = driver.findElement(By.xpath("//small[@class=contains(text(), 'Phone format')]")).getText();
        StringUtility.verifyEquals(expectedMessage,actualMessage);

        driver.quit();
    }
}
