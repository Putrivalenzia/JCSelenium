package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OrangeHRM {
    public static void main(String[] args) {
        String path = "D:\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Waiting Element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser,open url");

        //Login
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(@class, 'login-button')]"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        btnLogin.click();

        //Dashboard
        WebElement dashboard = driver.findElement(By.xpath("//h6[contains(@class, 'topbar-header-breadcrumb')]"));//menampung locator
        String txtDashboard = dashboard.getText();//menampung hasil dari get text from locator
        assertEquals(txtDashboard, "Dashboard");


        driver.quit();
        System.out.println("Quit Browser");


    }
    public static void assertEquals(String actual, String expected){
        if (actual.equalsIgnoreCase(expected)){
            System.out.println("Result testing pass");
        } else {
            System.out.println("Result testing failed");
        }
    }
    static void delay(long detik){
        try {
            Thread.sleep(detik * 1000);// delay
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
