package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Search {
    WebDriver driver;

    public Search(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public int ProductList()
    {
        int size = driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size();
        return size;
    }

    public WebElement NoProductsFound()
    {
        return driver.findElement(By.cssSelector("div[class=\"no-result\"]"));
    }
}
