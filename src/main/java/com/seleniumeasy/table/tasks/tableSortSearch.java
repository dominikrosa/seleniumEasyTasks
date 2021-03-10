package com.seleniumeasy.table.tasks;

import com.seleniumeasy.helpers.baseSeleniumClass;
import com.seleniumeasy.helpers.seleniumHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class tableSortSearch extends baseSeleniumClass {

    @FindBy(xpath = "//a[@href='./table-sort-search-demo.html']")
    private WebElement tableSortSearchStart;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBar;

    @FindBy(xpath = "//table[@id='example']//tbody//tr")
    private WebElement elements;

    private seleniumHelper helper;

    private WebDriver driver;

    public tableSortSearch(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new seleniumHelper(driver);
        this.driver = driver;
    }

    public tableSortSearch tableSortSearch() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", tableSortSearchStart);
        searchBar.click();
        executor.executeScript("arguments[0].value='san';", searchBar);
        Thread.sleep(1000);
        searchBar.sendKeys(Keys.ENTER);
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']//tbody//tr"));
        System.out.println("There are " + rows.size() + " positions with 'san' displayed");
        return this;
    }
}
