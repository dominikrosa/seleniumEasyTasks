package com.seleniumeasy.datePickers;

import com.seleniumeasy.datePickers.tasks.bootstrapDatePicker;
import com.seleniumeasy.datePickers.tasks.jqueryDatePicker;
import com.seleniumeasy.helpers.baseSeleniumClass;
import com.seleniumeasy.table.tasks.tableSortSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class datePickerTest extends baseSeleniumClass {
    @Test
    public void testDatePickers() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/");
        driver.findElement(By.id("image-darkener"));
        WebElement popUp = driver.findElement(By.linkText("No, thanks!"));
        popUp.click();

        bootstrapDatePicker datePickers = new bootstrapDatePicker(driver);
        datePickers
                .bootstrapDatePicker();

        jqueryDatePicker datePicker = new jqueryDatePicker(driver);
        datePicker
                .jqueryDatePicker();





    }
}
