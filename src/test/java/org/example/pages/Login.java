package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement emailE()
    {
        return driver.findElement(By.id("Email"));
    }

    public WebElement passwordL()
    {
        return driver.findElement(By.id("Password"));
    }

    public void LoginSteps(String email ,String password)
    {
        emailE().clear();
        passwordL().clear();
        emailE().sendKeys( email );
        passwordL().sendKeys( password );
    }

    public WebElement myAccount()
    {
        return driver.findElement(By.cssSelector("a[class=\"ico-account\"]"));
    }

    public WebElement wrongMsg()
    {
        return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }
}
