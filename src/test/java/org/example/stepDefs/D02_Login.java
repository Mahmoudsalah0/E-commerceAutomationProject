package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Home;
import org.example.pages.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

public class D02_Login {

    Login login = new Login(Hooks.driver);
    Home home = new Home(Hooks.driver);

    @When("user navigate to login page")
    public void step1()
    {
        home.NavigateToLoginPage().click();
    }

    @And("user login with \"(.*)\" and \"(.*)\"$")
    public void step2(String email, String password) throws InterruptedException
    {
        login.LoginSteps(email, password);
        Thread.sleep(2000);
    }

    @Then("user press on login button")
    public void step3()
    {
        login.passwordL().sendKeys(Keys.ENTER);
    }

    @And("user login to the system successfully")
    public void step4()
    {
        //  Assertion (getCurrentUrl and verify it equals https://demo.nopcommerce.com/ )
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/","URL login");

        //  Assertion (“My account” tab isDisplayed)
        Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed();
        soft.assertTrue(login.myAccount().isDisplayed(), "My Account");

        // Assert All
        soft.assertAll();
    }
    @And("user could not login to the system")
    public void step5()
    {
        //  Assertion (error message contains "Login was unsuccessful.")
        SoftAssert soft = new SoftAssert();
        login.wrongMsg().isDisplayed();
        String actual = login.wrongMsg().getText();
        soft.assertEquals(actual,"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect","Wrong Message");

        //  Assertion (the color of this message is red  "#e4434b" )
        actual = login.wrongMsg().getCssValue("color");
        String expected = "rgba(228, 67, 75, 1)";
        soft.assertEquals(actual, expected, "color");

        // Assert All
        soft.assertAll();
    }
}

