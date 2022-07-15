package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Home;
import org.example.pages.Search;
import org.testng.asserts.SoftAssert;

public class D04_Search {
    Search search = new Search(Hooks.driver);
    Home home = new Home(Hooks.driver);


    @Given("user click on search bar")
    public void step1()
    {
        home.SearchBar().click();
    }

    @When("user search for product like \"(.*)\"$")
    public void step2(String SearchWord)
    {
        home.SearchBar().sendKeys(SearchWord);
    }

    @And("user click on the search Button")
    public void step3()
    {
        home.SearchBtn().click();
    }

    @Then("user could search successfully and go to search result")
    public void step4()
    {
        // First Assertion (url contains nopCommerce demo store. Search) - (search shows relevant results)
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=Samsung"), "Search URL");

        // Second Assertion (Count number of search results)
        int size = search.ProductList();
        soft.assertTrue(size > 0,"Search Result");

        // Assert All
        soft.assertAll();
    }

    @Then("user could search successfully with SKU")
    public void step1_4()
    {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=M8_HTC_5L"), "Search result URL");
        // Second Assertion
        int size = search.ProductList();
        soft.assertTrue(size > 0,"Search Result");
        // Assert All
        soft.assertAll();
    }

    @Then("user could not search")
    public void step2_3()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(search.NoProductsFound().isDisplayed(), "No products");
    }
}
