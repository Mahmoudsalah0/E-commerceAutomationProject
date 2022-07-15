package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Home;
import org.example.pages.Wishlist;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D08_Wishlist {
    Home home = new Home(Hooks.driver);
    Wishlist wishlist = new Wishlist(Hooks.driver);
    int Number;

    @When("user add item to wishlist")
    public void Step02()
    {
        home.AddToWish().get(2).click();
    }

    @Then("wishlist notification success is visible")
    public void Step03()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(home.WishlistSuccMsg().isDisplayed(), "Success Message");

        String actual = home.WishlistSuccMsg().getCssValue("background-color");
        String expected = "rgba(75, 176, 122, 1)";
        soft.assertEquals(actual, expected, "Message color");
    }

    @And("user get the number of wishlist items after adding items")
    public void step04()
    {
        String text = home.Wishlist().getText();
        text = text.replaceAll("[^0-9]", "");
        Number = Integer.parseInt(text);
    }

    @Then("the number of wishlist increased")
    public void step1_4()
    {
        Assert.assertTrue(Number > 0, "count of wishlist items");
    }

    @And("user go to wishlist page")
    public void step3_4() throws InterruptedException
    {
        home.CloseBtn().click();
        Thread.sleep(1000);
        home.Wishlist().click();
    }

    @Then("the number of items greater than zero in wishlist page")
    public void step5()
    {

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/wishlist"), "wishlist URL");

        int size = wishlist.WishlistItems();
        soft.assertTrue(size > 0, "wishlist items");

        soft.assertAll();
    }
}
