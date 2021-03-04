package com.seleniumeasy.inputForms.tasks;

import com.seleniumeasy.helpers.baseSeleniumClass;
import com.seleniumeasy.helpers.seleniumHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class jquerySelectDropdown extends baseSeleniumClass {

    @FindBy(xpath = "//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")
    private WebElement inputFormsMenu;

    @FindBy(xpath = "//li[@style='display: list-item;']//a[@href='./jquery-dropdown-search-demo.html']")
    private WebElement jquerySelectDropdownStart;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement jquerySelectDropdownDown;

    @FindBy(xpath = "//span[@class='selection']//span[@class='select2-selection__rendered']")
    private WebElement jquerySelectDropdownSelected;

    @FindBy(xpath = "//li[@class='select2-search select2-search--inline']//input[@class='select2-search__field'][@type='search']")
    private WebElement jqueryMultiSelectDown;

    @FindBy(xpath = "//select[@class='js-example-disabled-results select2-hidden-accessible']")
    private WebElement jqueryMultiSelectDisabled;

    @FindBy(xpath = "//span[@class='select2-selection__rendered'][@title='Puerto Rico']")
    private WebElement jqueryMultiSelectDisabledResult;

    @FindBy(xpath = "//select[@name='files'][@id='files']")
    private WebElement jqueryMultiSelectFile;

    private seleniumHelper helper;

    private WebDriver driver;

    public jquerySelectDropdown(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new seleniumHelper(driver);
        this.driver = driver;
    }

    public jquerySelectDropdown inputMenu() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", inputFormsMenu);
        return this;
    }

    public jquerySelectDropdown jquerySelectDropdownEX(){
        jquerySelectDropdownStart.click();

        Select select = new Select(jquerySelectDropdownDown);
        select.selectByVisibleText("Japan");
        Assert.assertEquals("Japan", jquerySelectDropdownSelected.getText());

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", jqueryMultiSelectDown);
        jqueryMultiSelectDown.sendKeys("Alaska", Keys.ENTER, "Hawaii", Keys.ENTER);


        Select select1 = new Select(jqueryMultiSelectDisabled);
        select1.selectByIndex(3);
        String result = jqueryMultiSelectDisabledResult.getText();
        Assert.assertEquals("Puerto Rico", result);

        jqueryMultiSelectFile.click();
        jqueryMultiSelectFile.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        helper.takeScreenshot();
        System.out.println("9. Screenshot has been taken and put into 'resources' - Single Select test passed");
        return this;
    }


}
