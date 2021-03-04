package com.seleniumeasy.tasks;

import com.github.javafaker.Faker;
import com.seleniumeasy.helpers.BaseSeleniumClass;
import com.seleniumeasy.helpers.SeleniumHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ajaxFormSubmit extends BaseSeleniumClass {

    @FindBy(xpath = "//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")
    private WebElement inputFormsMenu;

    @FindBy(xpath = "//li[@style='display: list-item;']//a[@href='./ajax-form-submit-demo.html']")
    private WebElement ajaxFormSubmitStart;

    @FindBy(xpath = "//div[@class='form-group']//input[@id='title'][@name='title']")
    private WebElement ajaxFormSubmitName;

    @FindBy(xpath = "//div[@class='form-group']//textarea[@name='description'][@id='description']")
    private WebElement ajaxFormSubmitComment;

    @FindBy(xpath = "//div[@id='submit-control']//input[@type='button'][@value='submit']")
    private WebElement ajaxFormSubmitSubmit;

    @FindBy(xpath = "//form[@id='frm'][@method='post']//div[@id='submit-control']")
    private WebElement ajaxFormSubmitCheck;

    private SeleniumHelper helper;

    private WebDriver driver;

    public ajaxFormSubmit(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }

    public ajaxFormSubmit inputMenu() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", inputFormsMenu);
        return this;
    }

    public ajaxFormSubmit ajaxFormSubmit() throws InterruptedException {
        Faker faker = new Faker();
        String setName = faker.name().fullName();
        String setComment = faker.bothify("?????????");

        ajaxFormSubmitStart.click();
        Thread.sleep(1000);
        ajaxFormSubmitName.sendKeys(setName);
        Thread.sleep(1000);
        ajaxFormSubmitComment.sendKeys(setComment);
        ajaxFormSubmitSubmit.click();
        Thread.sleep(1000);
        System.out.println("8. " + ajaxFormSubmitCheck.getText() + " - ajax submit passed");
        return this;
    }

}
