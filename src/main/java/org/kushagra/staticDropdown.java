package org.kushagra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class staticDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/kushas/Documents/drivers/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //checkbox
        //System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());  // to know if checkbox is selected -- returns true
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        // count the number of checkboxes
        driver.findElement(By.cssSelector("input[type='checkbox']"));   // find 1st checkbox

        //System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());  //finds all checkboxes


        // round trip
        //System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());    //to see if round trip is enable or not - if false click
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
            System.out.println("It's Enabled");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }





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
        //System.out.println(driver.findElement(By.id("divpaxinfo")).getText());  // before selecting

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
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        //System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); // after selecting

    }
}
