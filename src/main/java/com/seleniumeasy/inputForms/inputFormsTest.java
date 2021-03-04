package com.seleniumeasy.inputForms;

import com.seleniumeasy.inputForms.tasks.*;
import com.seleniumeasy.helpers.baseSeleniumClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class inputFormsTest extends baseSeleniumClass {
    @Test
    public void testInputForms() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/");
        driver.findElement(By.id("image-darkener"));
        WebElement popUp = driver.findElement(By.linkText("No, thanks!"));
        popUp.click();

        simpleFormDemo inputForms = new simpleFormDemo(driver);
        inputForms
                .firstTest()
                .secondTest()
                .inputMenu();

        checkboxDemo checkboxDemo = new checkboxDemo(driver);
        checkboxDemo.checkboxDemostart()
                .checkboxDemostart()
                .checkboxFirstEx()
                .checkboxSecondEx()
                .inputMenu();

        radioButtonsDemo radioButtonsDemo = new radioButtonsDemo(driver)
                .radioButtonsStart()
                .radioButtonsEx1()
                .radioButtonsEx2()
                .inputMenu();

        selectDropdownList selectDropdownList = new selectDropdownList(driver)
                .selectDropdownListStart()
                .dropdownListEx1()
                .dropdownListEx2()
                .inputMenu();

        inputFormSubmit inputFormSubmit = new inputFormSubmit(driver)
                .inputFormsSubmit()
                .inputMenu();

        ajaxFormSubmit ajaxFormSubmit = new ajaxFormSubmit(driver)

                .ajaxFormSubmit()
                .inputMenu();

       jquerySelectDropdown jquerySelectDropdown = new jquerySelectDropdown(driver)
               .jquerySelectDropdownEX();




    }
    }
