package org.kushagra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class staticDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/kushas/Documents/drivers/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //dropdown with select tag
//        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//        Select dropdown = new Select(staticDropdown);
//        dropdown.selectByIndex(3);
//        System.out.println(dropdown.getFirstSelectedOption().getText());
//        dropdown.selectByVisibleText("AED");
//        System.out.println(dropdown.getFirstSelectedOption().getText());
//        dropdown.selectByValue("INR");
//        System.out.println(dropdown.getFirstSelectedOption().getText());

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
//        driver.findElement(By.id("hrefIncAdt")).click(); // click here 4 times to increase no. of adults
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());  // before selecting

        int i =1;
//        while (i<5)
//        {
//            driver.findElement(By.id("hrefIncAdt")).click();
//            i++;
//        }
        for(i=1; i<5; i++)
        {
            driver.findElement(By.id("hrefIncAdt")).click();

        }

        driver.findElement(By.id("btnclosepaxoption")).click();     // done button
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); // after selecting

    }
}
