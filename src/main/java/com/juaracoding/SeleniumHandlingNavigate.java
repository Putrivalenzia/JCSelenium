package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumHandlingNavigate {
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
        String titleHeader = driver.getTitle();//scraping
        System.out.println(titleHeader);

        //Login
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        WebElement btnLogin = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        btnLogin.click();
        System.out.println("Login Success!");

        //Logout
        WebElement dropDown = driver.findElement(By.className("oxd-userdropdown-tab"));
        dropDown.click();
        WebElement logout = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a"));
        logout.click();
        delay(5);
        //Navigate back
        driver.navigate().back();
        delay(5);
        driver.quit();
        System.out.println("Quit Browser");

    }
    static void delay(long detik){
        try {
            Thread.sleep(detik * 1000);// delay
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
