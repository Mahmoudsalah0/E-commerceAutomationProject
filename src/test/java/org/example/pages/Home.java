package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home {
    WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement NavigateToLoginPage()
    {
        return driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
    }

    public WebElement Currency()
    {
        return driver.findElement(By.id("customerCurrency"));
    }

    public WebElement EuroCurrency()
    {
        return driver.findElement(By.xpath("//option[@value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]"));
    }

    public WebElement ProductPrice()
    {
        return driver.findElement(By.cssSelector("span[class=\"price actual-price\"]"));
    }

    public WebElement SearchBar()
    {
        return driver.findElement(By.id("small-searchterms"));
    }

    public WebElement SearchBtn()
    {
        return driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }

    public WebElement Slider(String SliderNumber)
    {
        return driver.findElement(By.xpath("(//a[@href=\"http://demo.nopcommerce.com/\"])["+SliderNumber+"]"));
    }

    public WebElement Facebook()
    {
        return driver.findElement(By.xpath("//a[@href=\"http://www.facebook.com/nopCommerce\"]"));
    }

    public WebElement Twitter()
    {
        return driver.findElement(By.xpath("//a[@href=\"https://twitter.com/nopCommerce\"]"));
    }

    public WebElement RSS()
    {
        return driver.findElement(By.xpath("//a[@href=\"/news/rss/1\"]"));
    }

    public WebElement Youtube()
    {
        return driver.findElement(By.xpath("//a[@href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }

    public WebElement Wishlist()
    {
        return driver.findElement(By.cssSelector("div[class=\"header-links\"] [href=\"/wishlist\"]"));
    }

    public List<WebElement> AddToWish()
    {
        return driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
    }

    public WebElement WishlistSuccMsg()
    {
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

    public WebElement CloseBtn()
    {
        return driver.findElement(By.cssSelector("span[class=\"close\"]"));
    }

    public WebElement Computers()
    {
        return driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] [href=\"/computers\"]"));
    }

    public WebElement NoteBooks()
    {
        return driver.findElement(By.cssSelector("ul[class=\"top-menu notmobile\"] [href=\"/notebooks\"]"));
    }
}
