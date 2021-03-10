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

public class tableFilter extends baseSeleniumClass{

@FindBy(xpath = "//a[@href='./table-records-filter-demo.html']")
private WebElement tableFilterStart;

@FindBy(xpath = "//div[@class='pull-right']//button[@data-target='pagado']")
private WebElement green;

@FindBy(xpath = "//button[@data-target='pendiente']")
private WebElement orange;

@FindBy(xpath = "//button[@data-target='cancelado']")
private WebElement red;

@FindBy(xpath = "//button[@data-target='all']")
private WebElement all;







    private seleniumHelper helper;

    private WebDriver driver;

    public tableFilter(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new seleniumHelper(driver);
        this.driver = driver;
    }

    public tableFilter tableFilter() throws InterruptedException {
        System.out.println("3. Table Filter");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", tableFilterStart);
        Actions actions = new Actions(driver);


        List<WebElement> notChosenElements = driver.findElements(By.xpath("//table[@class='table table-filter']//tbody/tr[@style='display: none;']"));
        System.out.println("There are " + notChosenElements.size() + " not displayed elements");

        Thread.sleep(300);
        actions.doubleClick(green).build().perform();
        Thread.sleep(300);
        List<WebElement> notChosenElementsGreen = driver.findElements(By.xpath("//table[@class='table table-filter']//tbody/tr[@style='display: none;']"));
        Thread.sleep(300);
        int greenElements = 5 - notChosenElementsGreen.size();
        System.out.println("There is/are " + greenElements + " green element(s).");

        Thread.sleep(300);
        actions.doubleClick(orange).build().perform();
        Thread.sleep(300);
        List<WebElement> notChosenElementsOrange = driver.findElements(By.xpath("//table[@class='table table-filter']//tbody/tr[@style='display: none;']"));
        Thread.sleep(300);
        int orangeElements = 5 - notChosenElementsOrange.size();
        System.out.println("There is/are " + orangeElements + " orange element(s).");

        Thread.sleep(300);
        actions.doubleClick(red).build().perform();
        Thread.sleep(300);
        List<WebElement> notChosenElementsRed = driver.findElements(By.xpath("//table[@class='table table-filter']//tbody/tr[@style='display: none;']"));
        Thread.sleep(300);
        int redElements = 5 - notChosenElementsRed.size();
        System.out.println("There is/are " + redElements + " red element(s).");

        Thread.sleep(300);
        actions.doubleClick(all).build().perform();
        Thread.sleep(300);
        List<WebElement> notChosenElementsAll = driver.findElements(By.xpath("//table[@class='table table-filter']//tbody/tr[@style='display: none;']"));
        Thread.sleep(300);
        int allElements = 5 - notChosenElementsAll.size();
        System.out.println("There is/are " + allElements + " all elements.");


        return this;
    }
}
