package org.kushagra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/kushas/Documents/drivers/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();      // to run test in maximize
        driver.get("https://google.com");
        driver.navigate().to("https://rahulshettyacademy.com");  // use to internally navigate when running tests
            driver.navigate().back();
        driver.navigate().forward();
    }
}
