package com.seleniumeasy.inputForms.tasks;

import com.seleniumeasy.helpers.baseSeleniumClass;
import com.seleniumeasy.helpers.seleniumHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkboxDemo extends baseSeleniumClass {





    @FindBy(xpath = "//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")
    private WebElement inputFormsMenu;

    @FindBy(xpath = "//li[@style='display: list-item;']//a[@href='./basic-checkbox-demo.html']")
    private WebElement checkboxDemo;

    @FindBy(xpath = "//div[@class='checkbox']//input[@type='checkbox'][@id='isAgeSelected']")
    private WebElement checkboxFirstExample;

    @FindBy(xpath = "//div[@id='txtAge']")
    private WebElement ageSelected;

    @FindBy(xpath = "//input[@type='button'][@id='check1']")
    private WebElement checkboxAll;

    private seleniumHelper helper;

    private WebDriver driver;

    public checkboxDemo(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.helper = new seleniumHelper(driver);
        this.driver = driver;
    }

    public checkboxDemo checkboxDemostart(){
        checkboxDemo.click();
        return this;
    }

    public checkboxDemo checkboxFirstEx(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", checkboxFirstExample);
        System.out.println("3. " + ageSelected.getText() + " - First checkbox passed");
        return this;
    }

    public checkboxDemo checkboxSecondEx(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", checkboxAll);
        System.out.println("4. " + checkboxAll.getAttribute("value") + " - All checkboxes are selected");

        return this;
    }

    public checkboxDemo inputMenu(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", inputFormsMenu);
        return this;
    }


}
