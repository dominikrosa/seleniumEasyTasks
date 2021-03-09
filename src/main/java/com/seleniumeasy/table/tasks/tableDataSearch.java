package com.seleniumeasy.table.tasks;

import com.seleniumeasy.helpers.baseSeleniumClass;
import com.seleniumeasy.helpers.seleniumHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class tableDataSearch extends baseSeleniumClass {

    @FindBy(xpath = "//a[@href='./table-search-filter-demo.html']")
    private WebElement tableDataSearchStart;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement textFieldFilter;

    @FindBy(xpath = "//table[@id='task-table']")
    private WebElement firstTable;

    @FindBy(xpath = "//button[@class='btn btn-default btn-xs btn-filter']")
    private WebElement turnOnFilters;

    private seleniumHelper helper;

    private WebDriver driver;

    public tableDataSearch(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new seleniumHelper(driver);
        this.driver = driver;
    }

    public tableDataSearch tableDataSearch() throws InterruptedException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()", tableDataSearchStart);

        Thread.sleep(1000);
        javascriptExecutor.executeScript("arguments[0].value='in progress';", textFieldFilter);
        textFieldFilter.sendKeys(Keys.ENTER);

        List<WebElement> notDisplayedRows = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr[@style='display: none;']"));
        int rowsDisplayed = 7 - notDisplayedRows.size();
        System.out.println("There are " + rowsDisplayed + " tasks in progress");

        List<WebElement> blockedFilter = driver.findElements(By.xpath("//div[@class='panel panel-primary filterable']//table[@class='table']//thead//th[not(@disabled)]"));
        System.out.println("There are " + blockedFilter.size() + " disabled tasks. Going to make them enabled");
        turnOnFilters.click();


        return this;
    }

}
