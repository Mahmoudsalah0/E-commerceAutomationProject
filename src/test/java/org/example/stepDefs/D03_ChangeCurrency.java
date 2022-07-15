package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Home;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D03_ChangeCurrency {

    Home home = new Home(Hooks.driver);

    @When("user select “Euro” from currency dropdown list")
    public void step1() {
        home.Currency().click();
        home.EuroCurrency().click();
    }

    @Then("All Dollar sign $ change to euro sign €")
    public void step2(){
        int Count = Hooks.driver.findElements(By.xpath("//option[@value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F\"]")).size();
        for (int x = 0; x < Count; x++){

            String text = home.ProductPrice().getText();

            Assert.assertTrue(text.contains("€"));
        }
    }
}
