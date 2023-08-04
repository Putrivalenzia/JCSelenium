package com.juaracoding;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver.exe"); //ada 2 parameter
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println("Open Browser,open url");
        driver.findElement(By.name("q")).sendKeys("JuaraCoding");
        System.out.println("input search");
        driver.findElement(By.name("btnK")).click();
        System.out.println("click button search");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("quit browser");
    }
}