package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
        driver.findElement(By.linkText("TOKYO TALKIES")).click();

        // Memilih ukuran (size) dari dropdown
        WebElement sizeDropdownElement = driver.findElement(By.id("color")); // id sesuai dengan id dropdown size
        Select sizeDropdown = new Select(sizeDropdownElement);
        sizeDropdown.selectByVisibleText("Red");

        // Memilih warna (color) dari dropdown
        WebElement colorDropdownElement = driver.findElement(By.id("size")); //  id sesuai dengan id dropdown color
        Select colorDropdown = new Select(colorDropdownElement);
        colorDropdown.selectByVisibleText("M");

        // Klik tombol "Add to cart"
        driver.findElement(By.className("single_add_to_cart_button")).click();

        // Klik cart
        driver.findElement(By.className("icon_bag_alt")).click();

        // Buat assert menggunakan if
        // Cek apakah ada elemen dengan class "cart-empty"
        if (driver.findElements(By.className("cart-empty")).isEmpty()) {
            System.out.println("Add to Cart Berhasil");
        } else {
            System.out.println("Add to Cart Gagal");
        }

        driver.quit();


    }

}
