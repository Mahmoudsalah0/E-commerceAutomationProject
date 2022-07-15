package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Home;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D06_HomeSlider {
    Home home  = new Home(Hooks.driver);

    @When("user clicks on the first slider")
    public void step1()
    {
        Hooks.driver.findElement(By.cssSelector("a[rel=\"0\"]")).click();
        home.Slider("1").click();
    }

    @Then("the product for first slider is displayed")
    public void step2() throws InterruptedException
    {
        Thread.sleep(3000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020","First Slide URL");
    }

    @When("user clicks on the second slider")
    public void step2_1()
    {
        Hooks.driver.findElement(By.cssSelector("a[rel=\"1\"]")).click();
        home.Slider("2").click();
    }

    @Then("the product for second slider is displayed")
    public void step2_2() throws InterruptedException
    {
        Thread.sleep(3000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6","The Second Slide URL");
    }
}
