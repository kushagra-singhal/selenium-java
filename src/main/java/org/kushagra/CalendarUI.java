package org.kushagra;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUI {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companion/");
        driver.manage().window().maximize();
        //scroll the page
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,800)");
        //click on dateField
        Thread.sleep(3000);
        // April 23
        driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).click();

        WebElement month = driver.findElement(By.xpath("//div[@class='flatpickr-month']"));

        while (!month.getText().contains("June"))
        {
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(".flatpickr-next-month")).click();
        }
//        List<WebElement> dates = driver.findElements(By.className("flatpickr-days"));
        // Grab Common attributes, Put into List, iterate

        int count = driver.findElements(By.className("flatpickr-day")).size();
        for(int i =0; i<count; i++)
        {
            String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
            if (text.equalsIgnoreCase("23"))
            {
                driver.findElements(By.className("flatpickr-day")).get(i).click();
                System.out.println(text);
                break;
            }
        }
    }
}
