package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.Assert;
import utils.BaseTest;

public class LoginToEshop extends BaseTest  {

    @Test(description = "Test login page loading")
    public void login() throws InterruptedException {
        driver.get("https://automationexercise.com/login");

        // Verify page title
        String actualTitle = driver.getTitle();
        System.out.println("Page title: " + actualTitle);
        Assert.assertTrue(actualTitle.contains("Login"), "Title does not match!");

        // Verify current URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/login");

        WebElement inputLoginEmail = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        inputLoginEmail.sendKeys("nafi@gmail.com");
        WebElement inputLoginPassword = driver.findElement(By.cssSelector("input[data-qa='login-password']"));
        inputLoginPassword.sendKeys("Nafi@123");
        WebElement loginButton = driver.findElement(By.cssSelector("button[data-qa='login-button']"));
        loginButton.click();
    }

    @Test(description = "Test login page with invalid email")
    public void invalidLogin() throws InterruptedException {
        driver.get("https://automationexercise.com/login");

        WebElement inputLoginEmail = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
                     inputLoginEmail.sendKeys("kk@gmail.com");
        WebElement inputLoginPassword = driver.findElement(By.cssSelector("input[data-qa='login-password']"));
                        inputLoginPassword.sendKeys("Nafi@123");
        WebElement loginButton = driver.findElement(By.cssSelector("button[data-qa='login-button']"));
        loginButton.click();

        Thread.sleep(3000); // Wait for 3 seconds to see the result

        WebElement error_msg = driver.findElement(By.xpath( "//p[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(error_msg.isDisplayed(), "Error message is not displayed!");
}}