package com.juaracoding;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQA {
    public static void main(String[] args) {

        String path = "D:\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        System.out.println("Open Browser,open url");

        String titlePage = driver.findElement(By.className("main-header")).getText();//scraping
        System.out.println(titlePage);
        driver.getTitle();

        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("info@juaracoding.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("submit")).click();

        //buat assert menggunakan if
        if (titlePage.equalsIgnoreCase("text box")){
            System.out.println("Result testing pass");
        } else {
            System.out.println("Result testing fail");
        }

        delay();
        driver.close();
        System.out.println("quit browser");
    }
    public static void delay (){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}