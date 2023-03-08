package org.kushagra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click();
        Set<String> windows = driver.getWindowHandles();  // to get ids of windows and tabs opened [parentid,childid]
        // to access elements present in Set collection(windows)
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        //switch to child window
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        driver.findElement(By.cssSelector(".im-para.red")).getText();
        String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        // switching to parent window
        driver.switchTo().window(parentId); // switch back to parent window
        driver.findElement(By.id("username")).sendKeys(emailId); // this fails if we do not switch back to parent window
    }
}
