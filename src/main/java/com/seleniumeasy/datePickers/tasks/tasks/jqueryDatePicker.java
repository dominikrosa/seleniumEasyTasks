package com.seleniumeasy.datePickers.tasks;

import com.seleniumeasy.helpers.seleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class jqueryDatePicker extends baseSeleniumClass {

    @FindBy(xpath = "//div[@class='col-md-3 sidenav']//ul[@id='treemenu']//a[@href='#'][contains(text(),'Date pickers')]")
    private WebElement start;

    @FindBy(xpath = "//ul[@id='treemenu']//a[@href='./jquery-date-picker-demo.html']")
    private WebElement jqueryDatePickerStart;

    @FindBy(xpath = "//div[@class='panel-body']//input[@id='from']")
    private WebElement from;

    @FindBy(xpath = "//div[@class='ui-datepicker-title']//select[@data-handler='selectMonth']")
    private WebElement selectMonth;

    @FindBy(xpath = "//div[@class='panel-body']//input[@id='to']")
    private WebElement to;

    private seleniumHelper helper;

    private WebDriver driver;

    public jqueryDatePicker(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new seleniumHelper(driver);
        this.driver = driver;

    }

    public jqueryDatePicker jqueryDatePicker() {
        start.click();
        jqueryDatePickerStart.click();
        from.click();
        Select select = new Select(selectMonth);

        //from
        select.selectByVisibleText("Jun");
        WebElement dateWidget = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

        for (WebElement cell : columns) {
            if (cell.getText().equals("13")) {
                cell.findElement(By.linkText("13")).click();
                break;
            }
        }

        //to

        to.click();
        to.sendKeys("06/18/2021");

        return this;
    }
}
