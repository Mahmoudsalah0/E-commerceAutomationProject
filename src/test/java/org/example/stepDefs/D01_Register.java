package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Registration;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_Register {

    Registration reg = new Registration(Hooks.driver);

    @Given("user navigate to register page")
    public void step1()
    {
        reg.RegisterBtn().click();
    }

    @And("user choose the gender")
    public void step2(){
        reg.GenderMale().click();
    }

    @When("user enter mandatory register data")
    public void step3(){
        reg.FirstName().sendKeys("Mahmoud");

        reg.LastName().sendKeys("Salah");

        Select select = new Select(reg.BirthDay());
        select.selectByIndex(2);

        select = new Select(reg.BirthMonth());
        select.selectByVisibleText("January");

        select = new Select(reg.BirthYear());
        select.selectByValue("1990");


        reg.EmailAddress().sendKeys("salahmento@gmail.com");

        reg.CompanyName().sendKeys("ArabFinance");

        reg.Pass().sendKeys("Aa123456");
        reg.ConfirmPass().sendKeys("Aa123456");
    }

    @Then("user click on register button")
    public void step4(){
        reg.RegisterBt().click();
    }

    @And("user could register successfully")
    public void SuccessfullyRegister() throws InterruptedException {

        // First Assertion (Success message is displayed “Your registration completed”)
        Thread.sleep(3000);
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(reg.SuccessMessage().isDisplayed(), "Success Message");

        // Second Assertion (the color of this message is green rgba(76, 177, 124, 1)
        String actual = reg.SuccessMessage().getCssValue("color");
        String expected = "rgba(76, 177, 124, 1)";
        soft.assertEquals(actual, expected, "Color is right");

        // Assert All
        soft.assertAll();
    }
}
