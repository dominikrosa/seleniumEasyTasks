package InputForms;

import com.github.javafaker.Faker;
import helpers.SeleniumHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.List;
import java.util.Locale;


public class InputForms extends BaseSeleniumClass {


    @FindBy(id = "btn_basic_example")
    private WebElement start;

    @FindBy(xpath = "//div[@class='tab-content']//a[@href='./basic-first-form-demo.html']")
    private WebElement simpleFormDemo;

    @FindBy(id = "user-message")
    private WebElement enterMessage;

    @FindBy(xpath = "//form[@id='get-input']//button[@type='button']")
    private WebElement sendMessage;

    @FindBy(xpath = "//div[@id='user-message']//span[@id='display']")
    private WebElement checkMessage;

    @FindBy(xpath = "//input[@id='sum1']")
    private WebElement a;

    @FindBy(xpath = "//input[@id='sum2']")
    private WebElement b;

    @FindBy(xpath = "//button[@onclick='return total()']")
    private WebElement checkResult;

    @FindBy(xpath = "//span[@id='displayvalue']")
    private WebElement displayedResult;

    @FindBy(xpath = "//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")
    private WebElement inputFormsMenu;

    @FindBy(xpath = "//li[@style='display: list-item;']//a[@href='./basic-checkbox-demo.html']")
    private WebElement checkboxDemo;

    @FindBy(xpath = "//div[@class='checkbox']//input[@type='checkbox'][@id='isAgeSelected']")
    private WebElement checkboxFirstExample;

    @FindBy(xpath = "//div[@id='txtAge']")
    private WebElement ageSelected;

    @FindBy(xpath = "//input[@type='button'][@id='check1']")
    private WebElement checkboxAll;

    @FindBy(xpath = "//li[@style='display: list-item;']//a[@href='./basic-radiobutton-demo.html']")
    private WebElement radioButtonsDemo;

    @FindBy(xpath = "//input[@value='Male']")
    private WebElement pickMale;

    @FindBy(xpath = "//button[@id='buttoncheck']")
    private WebElement getCheckedValue;

    @FindBy(xpath = "//p[@class='radiobutton']")
    private WebElement isMalePicked;

    @FindBy(xpath = "//div[@class='panel panel-default']//input[@value='Male'][@name='gender']")
    private WebElement chooseSex;

    @FindBy(xpath = "//div[@class='panel panel-default']//input[@value='5 - 15'][@name='ageGroup']")
    private WebElement chooseAgeGroup;

    @FindBy(xpath = "//div[@class='panel panel-default']//button[@type='button'][@onclick='getValues();']")
    private WebElement getValues;

    @FindBy(xpath = "//p[@class='groupradiobutton']")
    private WebElement chosenOptions;


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

    @FindBy(xpath = "//li[@style='display: list-item;'] //a[@href='./input-form-demo.html']")
    private WebElement inputFromSubmitStart;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='First Name']")
    private WebElement firstName;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='E-Mail Address']")
    private WebElement emailAddress;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='(845)555-1212']" )
    private WebElement phoneNumber;

    @FindBy(xpath ="//div[@class='input-group']//input[@placeholder='Address']" )
    private WebElement address;

    @FindBy(xpath ="//div[@class='input-group']//input[@placeholder='city']" )
    private WebElement city;

    @FindBy(xpath = "//div[@class='input-group']//select[@name='state']")
    private WebElement state;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='Zip Code']")
    private WebElement zipCode;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='Website or domain name']")
    private WebElement websiteDomain;

    @FindBy(xpath ="//div[@class='col-md-4']//input[@value='yes']")
    private WebElement hostingRadio;

    @FindBy(xpath ="//div[@class='col-md-4 inputGroupContainer']//textarea[@placeholder='Project Description']")
    private WebElement projectDescription;

    @FindBy(xpath = "//div[@class='col-md-4']//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//li[@style='display: list-item;']//a[@href='./ajax-form-submit-demo.html']")
    private WebElement ajaxFormSubmitStart;

    @FindBy(xpath = "//div[@class='form-group']//input[@id='title'][@name='title']")
    private WebElement ajaxFormSubmitName;

    @FindBy(xpath = "//div[@class='form-group']//textarea[@name='description'][@id='description']")
    private WebElement ajaxFormSubmitComment;

    @FindBy(xpath = "//div[@id='submit-control']//input[@type='button'][@value='submit']")
    private WebElement ajaxFormSubmitSubmit;

    @FindBy(xpath = "//form[@id='frm'][@method='post']//div[@id='submit-control']")
    private WebElement ajaxFormSubmitCheck;

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



    private SeleniumHelper helper;

    private WebDriver driver;

    public InputForms(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
        start.click();

    }

    public InputForms firstTest() {
        simpleFormDemo.click();

        enterMessage.sendKeys("That's the message");
        sendMessage.click();
        Assert.assertEquals("That's the message", checkMessage.getText());
        System.out.println("1. First test from Simple Form passed");

        return this;
    }

    public InputForms secondTest() {
        a.sendKeys("2");
        b.sendKeys("4");
        checkResult.click();
        String expectedResult = "6";
        Assert.assertEquals(expectedResult, displayedResult.getText());
        System.out.println("2. Second test from Simple Form passed");
        return this;

    }

    public InputForms inputMenu(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", inputFormsMenu);
        return this;
    }

    public InputForms checkboxDemostart(){
        checkboxDemo.click();
        return this;
    }

    public InputForms checkboxFirstEx(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", checkboxFirstExample);
        System.out.println("3. " + ageSelected.getText() + " - First checkbox passed");
        return this;
    }

    public InputForms checkboxSecondEx(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", checkboxAll);
        System.out.println("4. " + checkboxAll.getAttribute("value") + " - All checkboxes are selected");

        return this;
    }

    public InputForms radioButtonsStart(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", radioButtonsDemo);
        return this;
    }

    public InputForms radioButtonsEx1(){
        pickMale.click();
        getCheckedValue.click();
        System.out.println("5. " + isMalePicked.getText() + " - Radio Button first test passed");
        return this;
    }

    public InputForms radioButtonsEx2(){
        chooseSex.click();
        chooseAgeGroup.click();
        getValues.click();
        System.out.println("6. " + chosenOptions.getText() + " - Radio Button second test passed");
        return this;
    }

    public InputForms selectDropdownListStart(){
        selectDropdownList.click();
        return this;
    }

    public InputForms dropdownListEx1(){
       Select select = new Select(dropDown);
       select.selectByIndex(2);
        System.out.println("7. " + daySelected.getText() + " - Dropdown List first test passed");
        return this;
    }

    public InputForms dropdownListEx2(){
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

    Faker faker = new Faker();
    String setFirstName = faker.name().firstName();
    String setLastName = faker.name().lastName();
    String setEmailAddress = faker.bothify("????##@gmail.com");
    String setPhoneNumber = faker.phoneNumber().phoneNumber();
    String setAddress = faker.address().fullAddress();
    String setCity = faker.address().city();
    String setZipCode = faker.address().zipCode();
    String setDomain = faker.bothify("???????.com");
    String setDescription = faker.rickAndMorty().character();


    public InputForms inputFormsSubmit(){
        inputFromSubmitStart.click();
        System.out.println("7. Input Forms Submit:");
        firstName.sendKeys(setFirstName);
        lastName.sendKeys(setLastName);
        emailAddress.sendKeys(setEmailAddress);
        phoneNumber.sendKeys(setPhoneNumber);
        address.sendKeys(setAddress);
        city.sendKeys(setCity);
        Select select = new Select(state);
        select.selectByVisibleText("Georgia");
        zipCode.sendKeys(setZipCode);
        websiteDomain.sendKeys(setDomain);
        hostingRadio.click();
        projectDescription.sendKeys(setDescription);
        helper.takeScreenshot();
        System.out.println("Screenshot has been taken and put into 'resources' - test passed");
        submitButton.click();


        return this;
    }

    public InputForms ajaxFormSubmit() throws InterruptedException {
        Faker faker = new Faker();
        String setName = faker.name().fullName();
        String setComment = faker.bothify("?????????");

        ajaxFormSubmitStart.click();
Thread.sleep(1000);
        ajaxFormSubmitName.sendKeys(setName);
Thread.sleep(1000);
        ajaxFormSubmitComment.sendKeys(setComment);
        ajaxFormSubmitSubmit.click();
        Thread.sleep(1000);
        System.out.println("8. " + ajaxFormSubmitCheck.getText() + " - ajax submit passed");
        return this;
    }

    public InputForms jquerySelectDropdown(){
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



