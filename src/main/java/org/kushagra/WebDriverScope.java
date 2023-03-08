package org.kushagra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WebDriverScope {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

        // count of links on the page.
        System.out.println(driver.findElements(By.tagName("a")).size());

        // count of links in footer - limiting webDriver Scope
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // created footer web element
        System.out.println(footerDriver.findElements(By.tagName("a")).size()); // using footer driver

        // count links in first column of Footer
        WebElement columnDriver = footerDriver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        // click on each link in the column and check if the pages are opening
        for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++)
        {
            String clickOnLinkTabs = Keys.chord(Keys.CONTROL, Keys.ENTER);   // this combination lets us click on any tab links so that they open in another tab

            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTabs);  // here sendkeys is used for keyboard events
            Thread.sleep(5000L);
        }// opens all the tabs

        // to get the title of each child window opened
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while (it.hasNext())    // if there is any window present
        {
            driver.switchTo().window(it.next());    // moves to next index
            System.out.println(driver.getTitle());
        }
        }
    }


















