package org.kushagra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Seleniumintroduction {
    public static void main(String[] args) {
        //Invoking Browser
        // chrome - chromeDriver --> methods
        //ChromeDriver driver = new ChromeDriver(); this code might not work on other browsers
        // webDriver methods
        // chromedriver.exe -> ChromeBrowser
        //webdriver.chrome.driver->  key to set property



        //Selenium Manager replaces the setProperty from Selenium V4.6, now no use of setting key-value
//        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "/home/kushas/Documents/drivers/chromedriver_linux64/chromedriver");
//        WebDriver driver = new ChromeDriver();  // here chrome driver is implementing WebDriver interface

        //firefox launch
        // gecko driver - webdriver.gecko.driver

//        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver","/home/kushas/Documents/drivers/geckodriver-v0.32.2-linux64/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://amazon.in");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
//        driver.close();     // only the original window gets close
        driver.quit();      // closes all associated windows opened by Selenium
    }
}
