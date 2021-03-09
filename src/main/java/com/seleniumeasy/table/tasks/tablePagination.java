package com.seleniumeasy.table.tasks;

import com.seleniumeasy.helpers.baseSeleniumClass;
import com.seleniumeasy.helpers.seleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class tablePagination extends baseSeleniumClass{

    @FindBy(xpath = "//a[@href='./table-pagination-demo.html']")
    private WebElement tableStart;

    @FindBy(xpath = "//a[@class='next_link']")
    private WebElement nextLinkPagination;

    @FindBy(xpath = "//a[@class='prev_link']")
    private WebElement prevLinkPagination;


    private seleniumHelper helper;

    private WebDriver driver;

    public tablePagination(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new seleniumHelper(driver);
        this.driver = driver;
    }

    public tablePagination tablePagination(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()",tableStart);

        List<WebElement> rows = driver.findElements(By.xpath("//section[@class='content']//table[@class='table table-hover']/tbody/tr"));
        System.out.println("Web says that there are 15 records when there are " + rows.size());

        nextLinkPagination.click();

        if (prevLinkPagination.isDisplayed()){
            System.out.println("User is able to go to previous page");
        } else {
            System.out.println("There is no Previous Page button");
        }

        return this;
    }

}
