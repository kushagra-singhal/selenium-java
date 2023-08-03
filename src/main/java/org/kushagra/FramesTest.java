package org.kushagra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(ops);
//        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        System.out.println(driver.findElements(By.tagName("iframe")).size()); // to get the number of frames present
        driver.switchTo().frame(0); // switch to frames using index
        //driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));  // now the control comes inside the frame
        //driver.findElement(By.id("draggable")).click();  // this fails if we do not switch to frame in above step
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source, target).build().perform();
        driver.switchTo().defaultContent();   // imp step - to come out of frame content
    }
}
