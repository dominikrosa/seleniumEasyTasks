package InputForms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InputFormsTest extends BaseSeleniumClass{
    @Test
    public void TestOne() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/");
        driver.findElement(By.id("image-darkener"));
        WebElement popUp = driver.findElement(By.linkText("No, thanks!"));
        popUp.click();

        InputForms inputForms = new InputForms(driver);
        inputForms
                .firstTest()
                .secondTest()
                .inputMenu()
                .checkboxDemostart()
                .checkboxFirstEx()
                .checkboxSecondEx()
                .inputMenu()
                .radioButtonsStart()
                .radioButtonsEx1()
                .radioButtonsEx2()
                .inputMenu()
                .selectDropdownListStart()
                .dropdownListEx1()
                .dropdownListEx2()
                .inputMenu()
                .inputFormsSubmit()
                .inputMenu()
                .ajaxFormSubmit()
                .inputMenu()
                .jquerySelectDropdown();




    }
    }
