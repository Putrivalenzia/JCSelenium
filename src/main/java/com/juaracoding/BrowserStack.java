package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserStack {
    public static void main(String[] args) {
        String path = "D:\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/");
        // Waiting Element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser,open url");

        Actions actions = new Actions(driver);
//        WebElement btnGetStarted = driver.findElement(By.xpath("//*[@id=\"signupModalButton\"]"));
//        actions.moveToElement(btnGetStarted).click().perform();
//
//        WebElement btnMenuProduct = driver.findElement(By.xpath("//*[@id=\"product-nav\"]/ul/li[1]"));
//        actions.moveToElement(btnMenuProduct).perform();//mouse hover
//        System.out.println("Hover menu produk berhasil");

        //List pada Menu BrowserStack
        List<WebElement> listMenuBrowserStack = driver.findElements(By.xpath("//*[@id=\"product-nav\"]/ul/li"));
        for (WebElement menuText : listMenuBrowserStack) {
            System.out.println("Menu Text: " + menuText.getText());
        }

        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }
    public static void assertEquals(String actual, String expected) {
        if (actual.equalsIgnoreCase(expected)) {
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
