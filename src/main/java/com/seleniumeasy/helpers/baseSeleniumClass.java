package com.seleniumeasy.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public abstract class baseSeleniumClass {
    protected WebDriver driver;

    @BeforeTest
public void setUp(){
    String driverPath = "C:\\Users\\domin\\IdeaProjects\\kurs-selenium\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", driverPath);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}
}
