package com.seleniumeasy.inputForms.tasks;

import com.github.javafaker.Faker;
import com.seleniumeasy.helpers.baseSeleniumClass;
import com.seleniumeasy.helpers.seleniumHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class inputFormSubmit extends baseSeleniumClass {

    @FindBy(xpath = "//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")
    private WebElement inputFormsMenu;

    @FindBy(xpath = "//li[@style='display: list-item;'] //a[@href='./input-form-demo.html']")
    private WebElement inputFromSubmitStart;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='E-Mail Address']")
    private WebElement emailAddress;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='(845)555-1212']" )
    private WebElement phoneNumber;

    @FindBy(xpath ="//div[@class='input-group']//input[@placeholder='Address']" )
    private WebElement address;

    @FindBy(xpath ="//div[@class='input-group']//input[@placeholder='city']" )
    private WebElement city;

    @FindBy(xpath = "//div[@class='input-group']//select[@name='state']")
    private WebElement state;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='Zip Code']")
    private WebElement zipCode;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='Website or domain name']")
    private WebElement websiteDomain;

    @FindBy(xpath ="//div[@class='col-md-4']//input[@value='yes']")
    private WebElement hostingRadio;

    @FindBy(xpath ="//div[@class='col-md-4 inputGroupContainer']//textarea[@placeholder='Project Description']")
    private WebElement projectDescription;

    @FindBy(xpath = "//div[@class='col-md-4']//button[@type='submit']")
    private WebElement submitButton;

    private seleniumHelper helper;

    private WebDriver driver;

    public inputFormSubmit(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new seleniumHelper(driver);
        this.driver = driver;
    }

    public inputFormSubmit inputMenu() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", inputFormsMenu);
        return this;
    }

    Faker faker = new Faker();
    String setFirstName = faker.name().firstName();
    String setLastName = faker.name().lastName();
    String setEmailAddress = faker.bothify("????##@gmail.com");
    String setPhoneNumber = faker.phoneNumber().phoneNumber();
    String setAddress = faker.address().fullAddress();
    String setCity = faker.address().city();
    String setZipCode = faker.address().zipCode();
    String setDomain = faker.bothify("???????.com");
    String setDescription = faker.rickAndMorty().character();


    public inputFormSubmit inputFormsSubmit(){
        inputFromSubmitStart.click();
        System.out.println("7. Input Forms Submit:");
        firstName.sendKeys(setFirstName);
        lastName.sendKeys(setLastName);
        emailAddress.sendKeys(setEmailAddress);
        phoneNumber.sendKeys(setPhoneNumber);
        address.sendKeys(setAddress);
        city.sendKeys(setCity);
        Select select = new Select(state);
        select.selectByVisibleText("Georgia");
        zipCode.sendKeys(setZipCode);
        websiteDomain.sendKeys(setDomain);
        hostingRadio.click();
        projectDescription.sendKeys(setDescription);
        helper.takeScreenshot();
        System.out.println("Screenshot has been taken and put into 'resources' - test passed");
        submitButton.click();


        return this;
    }
}
