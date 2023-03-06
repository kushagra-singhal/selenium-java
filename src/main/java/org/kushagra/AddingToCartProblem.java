package org.kushagra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AddingToCartProblem {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/kushas/Documents/drivers/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Pumpkin"};    // string array
        int j = 0;

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i =0; i<products.size(); i++)
        {
            // Brocolli - 1 Kg  -> split - 1 kg
            // Brocolli,  1 kg

           String[] veggies = products.get(i).getText().split("-");
           String formattedVeggieName = veggies[0].trim();


           // format it to get actual vegetable name

           //check whether name you extracted is present in arrayList or not
            // convert array into arrayList for easy search
            //
            List itemsNeededList = Arrays.asList(itemsNeeded);  // string array to arrayList


           if(itemsNeededList.contains(formattedVeggieName))
           {
               j++;
               driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
               if(j==itemsNeeded.length){
                   break;
               }

           }
        }

    }

}
