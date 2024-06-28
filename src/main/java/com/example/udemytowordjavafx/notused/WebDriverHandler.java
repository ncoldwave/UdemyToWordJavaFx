package com.example.udemytowordjavafx.notused;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverHandler {
    public WebDriverHandler() {
        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
//        System.out.println("Title: " + driver.getTitle());
        driver.get("https://www.udemy.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3400));

        System.out.println("Login into Udemy.com...");
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[6]/a/span"));

        // wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3321));

        System.out.println("Login button text: " + loginButton.getText());

        if (loginButton.getText().equals("Log in")) {
            loginButton.click();

//            // email
//            WebElement emailTextBox = driver.findElement(By.xpath("//*[@id=\"form-group--1\"]"));
//            emailTextBox.sendKeys("");
//
//            // password
//            WebElement passwordTextBox = driver.findElement(By.xpath("//*[@id=\"form-group--3\"]"));
//            passwordTextBox.sendKeys("");
//
//            // /html/body/div[1]/div[2]/div/main/div/div/div[2]/form/button/span
//            loginButton = driver.findElement(By.xpath("//*[@id=\"form-group--3\"]"));
//            loginButton.click();

            // wait
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3152));

        } else {
            System.out.println("Login button not found.");
        }


        System.out.println("Closing WebDriver...");

        // wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        driver.quit();
    }
}
