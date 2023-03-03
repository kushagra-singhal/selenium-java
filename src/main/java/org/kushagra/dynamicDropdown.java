package org.kushagra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/kushas/Documents/drivers/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();      // to run test in maximize
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

//        //div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']  -- parent               child relationship
        //a[@value='MAA'])[2]         -- with indexes

        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
//        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        driver.findElement(By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-today")).click();




    }

}
