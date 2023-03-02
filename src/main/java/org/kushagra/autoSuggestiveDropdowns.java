package org.kushagra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class autoSuggestiveDropdowns {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/kushas/Documents/drivers/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);


       List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));  // note findelemets here

        for(WebElement option :options)  //options is list of web elements, option is one option from the list, WebElement is the return type of option
        {
           if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }


    }
}
