package InputForms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;


public abstract class BaseSeleniumClass {
    protected WebDriver driver;

    @BeforeTest
public void setUp(){
    String driverPath = "C:\\Users\\domin\\IdeaProjects\\kurs-selenium\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
    System.setProperty("webdriver.chrome.driver", driverPath);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}
}
