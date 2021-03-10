package com.seleniumeasy.table;

import com.seleniumeasy.helpers.baseSeleniumClass;
import com.seleniumeasy.table.tasks.tableDataSearch;
import com.seleniumeasy.table.tasks.tableFilter;
import com.seleniumeasy.table.tasks.tablePagination;
import com.seleniumeasy.table.tasks.tableSortSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class tableTest extends baseSeleniumClass{

    @Test
    public void testTest() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/");
        driver.findElement(By.id("image-darkener"));
        WebElement popUp = driver.findElement(By.linkText("No, thanks!"));
        popUp.click();


        tablePagination paginatione = new tablePagination(driver);
        paginatione
                .tablePagination();

        tableDataSearch dataSearch = new tableDataSearch(driver);
        dataSearch
                .tableDataSearch();


        tableFilter filter = new tableFilter(driver);
        filter
                .tableFilter();


        tableSortSearch sortSearch = new tableSortSearch(driver);
        sortSearch.tableSortSearch();

    }
}
