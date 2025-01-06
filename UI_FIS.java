package com.meta.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;   public class ebay {
    public static void main(String[] args) {
        invokeBrowser();
    }
    public static void invokeBrowser(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rajesh_meshram\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);           driver.findElement(By.id("gh-ac")).sendKeys("harry potter");
        WebElement categorydropdown = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categorydropdown);
        select.selectByVisibleText("Books");
        driver.findElement(By.id("gh-btn")).click();           driver.findElement(By.xpath("//li[@id='item36eccbd548']//span[@role='heading']")).click();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.getTitle().equals("Harry Potter And The Sorcerer's Stone 1st American Edition Printing J.K. Rowling | eBay");
        driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
        driver.getTitle().equals("eBay shopping cart");
        driver.findElement(By.xpath("//i[@id='gh-cart-n']")).isDisplayed();
        driver.findElement(By.xpath("//button[normalize-space()='Go to checkout']")).click();
        driver.quit();
    }   }
  
