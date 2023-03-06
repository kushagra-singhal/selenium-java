package org.kushagra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaAlerts {
    public static void main(String[] args) {
        String text = "Kushagra";
        System.setProperty("webdriver.chrome.driver", "/home/kushas/Documents/drivers/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());  //switch context from browser to any alert present on webpage
        //popups on screen are not html elements
        driver.switchTo().alert().accept();    //  accepts the alert; OK|Cancel
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println((driver.switchTo().alert().getText()));

        driver.switchTo().alert().dismiss();    // to click on cancel for the alert; OK|Cancel
    }
}
