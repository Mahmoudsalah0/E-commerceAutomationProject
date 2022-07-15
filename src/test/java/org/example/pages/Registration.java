package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Registration {
    WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement RegisterBtn()
    {
        WebElement RegisterBtn = Hooks.driver.findElement(By.className("ico-register"));
        return RegisterBtn;
    }
    public WebElement GenderMale()
    {
        return driver.findElement(By.id("gender-male"));
    }

    public WebElement FirstName()
    {
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement LastName()
    {
        return driver.findElement(By.id("LastName"));
    }

    public WebElement BirthDay()
    {
        return driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement BirthMonth()
    {
        return driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement BirthYear()
    {
        return driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement EmailAddress()
    {
        return driver.findElement(By.id("Email"));
    }

    public WebElement CompanyName()
    {
        return driver.findElement(By.id("Company"));
    }

    public WebElement Pass()
    {
        return driver.findElement(By.id("Password"));
    }

    public WebElement ConfirmPass()
    {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement RegisterBt()
    {
        return driver.findElement(By.id("register-button"));
    }

    public WebElement SuccessMessage()
    {
        return driver.findElement(By.xpath("//div[@class=\"result\"]"));
    }
}
