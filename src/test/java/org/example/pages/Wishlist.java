package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Wishlist {
    WebDriver driver;

    public Wishlist(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int WishlistItems()
    {
        int Size = driver.findElements(By.cssSelector("div[class=\"wishlist-content\"]")).size();
        return Size;
    }
}
