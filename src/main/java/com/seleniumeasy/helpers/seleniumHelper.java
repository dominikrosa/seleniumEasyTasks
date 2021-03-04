package com.seleniumeasy.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public class seleniumHelper {
    private WebDriver driver;

    public seleniumHelper(WebDriver driver){
        this.driver = driver;
    }
    public void waitForElementToBeDisplayed(By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForElementToBeDisplayed(WebElement element){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForListSize(List<WebElement> elementList){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(driver1 ->
                elementList.size()>0);

    }

    public void takeScreenshot(){
        TakesScreenshot screenshoter = (TakesScreenshot) driver;
        File screenshot = screenshoter.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), Paths.get("src/main/resources/test" + LocalTime.now().getNano() + ".png"));
        } catch (IOException e) {
            System.out.println("Nie znaleziono pliku");;
        }
    }
}
