package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtilities;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TNG_testCases1to5 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtilities.wait(2);
    }

    @Test (description = "verify that warning message is displayed")
    public void test1(){
        driver.findElement(By.cssSelector("[data-bv-field='birthday']")).sendKeys("wrong_dob");
        String expectedMessage = "The date of birth is not valid";
        String actualMessage = driver.findElement(By.cssSelector("[data-bv-validator='date']")).getText();
        //Assert.assertEquals(actualMessage,expectedMessage);
        StringUtility.verifyEquals(expectedMessage,actualMessage);
    }

    @Test (description = "verify that programming languages are displayed")
    public void test2(){
        List<WebElement> languages = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for(WebElement each: languages){
            each.isDisplayed();
        }
    }

    @Test (description = "verify that firstname warning message is displayed")
    public void test3(){
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("a");
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        String actualMessage = driver.findElement(By.xpath("//small[@class=contains(text(), 'first name must be ')]")).getText();
        StringUtility.verifyEquals(expectedMessage,actualMessage);
    }

    @Test (description = "verify that lastname warning message is displayed")
    public void test4(){
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("a");
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";
        String actualMessage = driver.findElement(By.xpath("//small[@class=contains(text(), 'The last name must')]")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test (description = "verify that sign up message is displayed")
    public void test5(){
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Angelina");
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Jolie");
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("angelinajolie");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("bradpitt");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("email@email.com");
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("571-111-0000");
        driver.findElement(By.cssSelector("[value='female']")).click();
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("12/31/2000");
        WebElement department =  driver.findElement(By.cssSelector("[name='department']"));
        Select select = new Select(department);
        select.selectByVisibleText("Mayor's Office");
        WebElement jobTitle =  driver.findElement(By.cssSelector("[name='job_title']"));
        Select select1 = new Select(jobTitle);
        select1.selectByVisibleText("Designer");
        driver.findElement(By.cssSelector("[value='java']")).click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement signUpButton = driver.findElement(By.id("wooden_spoon"));
        js.executeScript("arguments[0].click()",signUpButton);

        BrowserUtilities.wait(2);
        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = driver.findElement(By.xpath("//h4[@class='alert-heading']/following-sibling::p")).getText();
        StringUtility.verifyEquals(expectedMessage,actualMessage);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
