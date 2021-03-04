package com.seleniumeasy.inputForms.tasks;

import com.seleniumeasy.helpers.baseSeleniumClass;
import com.seleniumeasy.helpers.seleniumHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class radioButtonsDemo extends baseSeleniumClass {

    @FindBy(xpath = "//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")
    private WebElement inputFormsMenu;

    @FindBy(xpath = "//li[@style='display: list-item;']//a[@href='./basic-radiobutton-demo.html']")
    private WebElement radioButtonsDemo;

    @FindBy(xpath = "//input[@value='Male']")
    private WebElement pickMale;

    @FindBy(xpath = "//button[@id='buttoncheck']")
    private WebElement getCheckedValue;

    @FindBy(xpath = "//p[@class='radiobutton']")
    private WebElement isMalePicked;

    @FindBy(xpath = "//div[@class='panel panel-default']//input[@value='Male'][@name='gender']")
    private WebElement chooseSex;

    @FindBy(xpath = "//div[@class='panel panel-default']//input[@value='5 - 15'][@name='ageGroup']")
    private WebElement chooseAgeGroup;

    @FindBy(xpath = "//div[@class='panel panel-default']//button[@type='button'][@onclick='getValues();']")
    private WebElement getValues;

    @FindBy(xpath = "//p[@class='groupradiobutton']")
    private WebElement chosenOptions;

    private seleniumHelper helper;

    private WebDriver driver;

    public radioButtonsDemo(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new seleniumHelper(driver);
        this.driver = driver;
    }

    public radioButtonsDemo inputMenu() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", inputFormsMenu);
        return this;
    }

    public radioButtonsDemo radioButtonsStart(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", radioButtonsDemo);
        return this;
    }

    public radioButtonsDemo radioButtonsEx1(){
        pickMale.click();
        getCheckedValue.click();
        System.out.println("5. " + isMalePicked.getText() + " - Radio Button first test passed");
        return this;
    }

    public radioButtonsDemo radioButtonsEx2(){
        chooseSex.click();
        chooseAgeGroup.click();
        getValues.click();
        System.out.println("6. " + chosenOptions.getText() + " - Radio Button second test passed");
        return this;
    }


}
