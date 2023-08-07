package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Quiz {
    public static void main(String[] args) {
        String path = "D:\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        driver.get("https://shop.demoqa.com/my-account/");

        driver.findElement(By.id("username")).sendKeys("puri");
        driver.findElement(By.id("password")).sendKeys("999Putri!");
        driver.findElement(By.name("login")).click();


        // Buat assert menggunakan if
        // Cek apakah ada elemen dengan class "woocommerce-error"

        if (driver.findElements(By.className("woocommerce-error")).isEmpty()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        driver.quit();
    }

}
