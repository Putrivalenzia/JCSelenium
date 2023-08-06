package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddToCart {
    public static void main(String[] args) {
        String path = "D:\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        driver.get("https://shop.demoqa.com/my-account/");

        driver.findElement(By.id("username")).sendKeys("putri");
        driver.findElement(By.id("password")).sendKeys("999Putri!");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.className("custom-logo")).click();
        WebElement element = driver.findElement(By.cssSelector("a[href='https://shop.demoqa.com/product/pink-drop-shoulder-oversized-t-shirt/']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();

        // Memilih ukuran (size) dari dropdown
        WebElement sizeDropdownElement = driver.findElement(By.id("pa_size")); // id sesuai dengan id dropdown size
        Select sizeDropdown = new Select(sizeDropdownElement);
        sizeDropdown.selectByVisibleText("Large");

        // Memilih warna (color) dari dropdown
        WebElement colorDropdownElement = driver.findElement(By.id("pa_color")); //  id sesuai dengan id dropdown color
        Select colorDropdown = new Select(colorDropdownElement);
        colorDropdown.selectByVisibleText("Beige");

        // Klik tombol "Add to cart"
        driver.findElement(By.className("single_add_to_cart_button button alt wp-element-button")).click();




    }

}
