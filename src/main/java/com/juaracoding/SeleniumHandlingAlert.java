package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class SeleniumHandlingAlert {
    public static void main(String[] args) {

        String path = "D:\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        // Waiting Element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser,open url");

        // Handling Alert

        WebElement clickAlertButton = driver.findElement(By.id("alertButton"));
        clickAlertButton.click();
        driver.switchTo().alert().accept();
        System.out.println("Alert Clicked");

        // Alert with delay
        WebElement clickTimerAlertButton = driver.findElement(By.id("timerAlertButton"));
        clickTimerAlertButton.click();
        delay(5);
        driver.switchTo().alert().accept();
        System.out.println("Timer Alert Clicked");

        // Alert with input
        WebElement clickPromtButton = driver.findElement(By.id("promtButton"));
        js.executeScript("window.scrollBy(0,500)");
        clickPromtButton.click();
        driver.switchTo().alert().sendKeys("Putri");
        delay(5);
        driver.switchTo().alert().accept();
        System.out.println("Promt Alert Clicked");

        // Alert with confirm option
        js.executeScript("window.scrollBy(0,500)");
        WebElement clickConfirmButton = driver.findElement(By.id("confirmButton"));
        clickConfirmButton.click();
        driver.switchTo().alert().accept();
        System.out.println("Ok Confirmation Clicked");
//        driver.switchTo().alert().dismiss();
//        System.out.println("Cancel confirmation Clicked");


        driver.close();


    }
    public static void delay (long detik){
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
