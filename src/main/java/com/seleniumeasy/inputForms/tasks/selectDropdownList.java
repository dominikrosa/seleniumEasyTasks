package com.seleniumeasy.inputForms.tasks;

import com.seleniumeasy.helpers.baseSeleniumClass;
import com.seleniumeasy.helpers.seleniumHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class selectDropdownList extends baseSeleniumClass {

    @FindBy(xpath = "//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")
    private WebElement inputFormsMenu;

    @FindBy(xpath = "//li[@style='display: list-item;']//a[@href='./basic-select-dropdown-demo.html']" )
    private WebElement selectDropdownList;

    @FindBy(xpath = "//select[@class='form-control'][@id='select-demo']")
    private WebElement dropDown;

    @FindBy(xpath = "//p[@class='selected-value']")
    private WebElement daySelected;

    @FindBy(xpath = "//select[@size='10'][@name='States'][@id='multi-select']")
    private WebElement multiSelect;

    @FindBy(xpath = "//button[@type='button'][@value='Print First']")
    private WebElement selectFirst;

    @FindBy(xpath = "//option[@value='Texas']")
    private WebElement selectNewYork;

    @FindBy(xpath = "//button[@type='button'][@value='Print All']")
    private WebElement selectAll;

    @FindBy(xpath = "//p[@class='getall-selected']")
    private WebElement multiSelectResult;

    private seleniumHelper helper;

    private WebDriver driver;

    public selectDropdownList(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new seleniumHelper(driver);
        this.driver = driver;
    }

    public selectDropdownList inputMenu() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", inputFormsMenu);
        return this;
    }

    public selectDropdownList selectDropdownListStart(){
        selectDropdownList.click();
        return this;
    }

    public selectDropdownList dropdownListEx1(){
        Select select = new Select(dropDown);
        select.selectByIndex(2);
        System.out.println("7. " + daySelected.getText() + " - Dropdown List first test passed");
        return this;
    }

    public selectDropdownList dropdownListEx2(){
        Select select = new Select(multiSelect);
        select.selectByIndex(1);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(selectNewYork)
                .keyUp(Keys.LEFT_CONTROL).build().perform();
        selectFirst.click();
        System.out.println("8. " + multiSelectResult.getText());
        selectAll.click();
        System.out.println(multiSelectResult.getText() + " - Dropdown List second test passed");
        return this;
    }
}
