package org.kushagra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
       ChromeOptions ops = new ChromeOptions();
       ops.addArguments("--remote-allow-origins=*");
       ChromeDriver driver = new ChromeDriver(ops);
//       System.setProperty("webdriver.chrome.driver", "/home/kushas/Documents/drivers/chromedriver_linux64/chromedriver");
//        WebDriver driver = new ChromeDriver();
        //use implicit wait - 5 seconds time out
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // globally applicable adding timeout so that tests won't fail

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("kushagra");
        driver.findElement(By.name("inputPassword")).sendKeys("hello@123");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); //this fails due to time issues. browser takes some time to load but selenium doesn't
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000); // pausing the script for one second so that the transition has enough time to load

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@s.in");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("John@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567890");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        driver.findElement(By.className("go-to-login-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("kushagra");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //button[contains(@class,'submit')]

    }
}
