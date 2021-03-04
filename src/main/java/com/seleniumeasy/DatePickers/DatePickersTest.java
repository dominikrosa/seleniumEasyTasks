package com.seleniumeasy.DatePickers;

import com.seleniumeasy.helpers.BaseSeleniumClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DatePickersTest extends BaseSeleniumClass {
    @Test
    public void testDatePickers(){
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/");
        driver.findElement(By.id("image-darkener"));
        WebElement popUp = driver.findElement(By.linkText("No, thanks!"));
        popUp.click();

    }
}
