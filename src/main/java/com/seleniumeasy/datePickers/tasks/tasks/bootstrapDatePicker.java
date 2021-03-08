package com.seleniumeasy.datePickers.tasks;


import com.seleniumeasy.helpers.seleniumHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class bootstrapDatePicker extends baseSeleniumClass {

    @FindBy(xpath = "//div[@class='col-md-3 sidenav']//ul[@id='treemenu']//a[@href='#'][contains(text(),'Date pickers')]")
    private WebElement start;

    @FindBy(xpath = "//a[@href='./bootstrap-date-picker-demo.html']")
    private WebElement bootstrapDatePickerStart;

    @FindBy(xpath = "//div[@class='input-group date']//span[@class='input-group-addon']")
    private WebElement dateExample;

    @FindBy(xpath = "//th[@colspan='7'][@class='today']")
    private WebElement bootstrapPickToday;

    @FindBy(xpath = "//div[@class='input-daterange input-group']//input[@placeholder='Start date']")
    private WebElement dateRangeStart;

    @FindBy(xpath = "//div[@class='input-daterange input-group']//input[@placeholder='End date']")
    private WebElement dateRangeEnd;

    @FindBy(xpath = "//div[class='input-daterange input-group']//span[@class='input-group-addon']")
    private WebElement space;



    private seleniumHelper helper;

    private WebDriver driver;

    public bootstrapDatePicker(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new seleniumHelper(driver);
        this.driver = driver;



    }

    public bootstrapDatePicker bootstrapDatePicker() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",bootstrapDatePickerStart);
        executor.executeScript("arguments[0].click();",dateExample);
        Thread.sleep(1000);
        executor.executeScript("arguments[0].click();",bootstrapPickToday);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateFormatted = dateFormat.format(date);
        System.out.println(dateFormatted);

        Calendar today = Calendar.getInstance();
        today.setTime(date);
        today.add(Calendar.MONTH, 1);
        today.add(Calendar.DATE, 7);

        Date endDate = today.getTime();

        String endDateFormatted = dateFormat.format(endDate);
        System.out.println(endDateFormatted);

        dateRangeStart.sendKeys(dateFormatted, Keys.ESCAPE);
        dateRangeEnd.clear();
        dateRangeEnd.sendKeys(endDateFormatted, Keys.ESCAPE);

        helper.takeScreenshot();





        return this;
    }
}
