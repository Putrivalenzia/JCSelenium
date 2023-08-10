package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumHandlingFrame {
    public static void main(String[] args) {
        String path = "D:\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");
        // Waiting Element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser,open url");

        //Handling Select
        WebElement frameOne = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameOne);
        WebElement samplePage = driver.findElement(By.id("sampleHeading"));
        String textSamplePage = samplePage.getText();
        System.out.println(textSamplePage);
        driver.switchTo().defaultContent();

        //Handling Select
        js.executeScript("window.scrollBy(0,250)");
        WebElement frameTwo = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(frameTwo);
        WebElement samplePageTwo = driver.findElement(By.id("sampleHeading"));
        String textSamplePageTwo = samplePageTwo.getText();
        System.out.println(textSamplePageTwo);

        driver.close();
    }
}
