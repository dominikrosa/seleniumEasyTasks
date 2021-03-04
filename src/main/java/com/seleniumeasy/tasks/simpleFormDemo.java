package com.seleniumeasy.tasks;

import com.seleniumeasy.helpers.BaseSeleniumClass;
import com.seleniumeasy.helpers.SeleniumHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class simpleFormDemo extends BaseSeleniumClass {


    @FindBy(id = "btn_basic_example")
    private WebElement start;

    @FindBy(xpath = "//div[@class='tab-content']//a[@href='./basic-first-form-demo.html']")
    private WebElement simpleFormDemo;

    @FindBy(id = "user-message")
    private WebElement enterMessage;

    @FindBy(xpath = "//form[@id='get-input']//button[@type='button']")
    private WebElement sendMessage;

    @FindBy(xpath = "//div[@id='user-message']//span[@id='display']")
    private WebElement checkMessage;

    @FindBy(xpath = "//input[@id='sum1']")
    private WebElement a;

    @FindBy(xpath = "//input[@id='sum2']")
    private WebElement b;

    @FindBy(xpath = "//button[@onclick='return total()']")
    private WebElement checkResult;

    @FindBy(xpath = "//span[@id='displayvalue']")
    private WebElement displayedResult;

    @FindBy(xpath = "//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")
    private WebElement inputFormsMenu;


    private SeleniumHelper helper;

    private WebDriver driver;

    public simpleFormDemo(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
        start.click();

    }

    public simpleFormDemo firstTest() {
        simpleFormDemo.click();

        enterMessage.sendKeys("That's the message");
        sendMessage.click();
        Assert.assertEquals("That's the message", checkMessage.getText());
        System.out.println("1. First test from Simple Form passed");

        return this;
    }

    public simpleFormDemo secondTest() {
        a.sendKeys("2");
        b.sendKeys("4");
        checkResult.click();
        String expectedResult = "6";
        Assert.assertEquals(expectedResult, displayedResult.getText());
        System.out.println("2. Second test from Simple Form passed");
        return this;

    }

    public simpleFormDemo inputMenu(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", inputFormsMenu);
        return this;
    }
















}



