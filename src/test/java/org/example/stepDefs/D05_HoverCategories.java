package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Category;
import org.example.pages.Home;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D05_HoverCategories {

    Home home = new Home(Hooks.driver);
    Category category = new Category(Hooks.driver);
    String SubCategory;

    @When("user hover category and select subcategory")
    public void step1() throws InterruptedException
    {
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(home.Computers()).perform();
        action.moveToElement(home.Computers()).perform();
        SubCategory = home.NoteBooks().getText().toLowerCase();
        Thread.sleep(3000);
    }

    @And("user click on subcategory")
    public void step2()
    {

        home.NoteBooks().click();
    }

    @Then("user go to relative product page")
    public void step3()
    {
        Assert.assertEquals(category.categoryList().getText().toLowerCase(), SubCategory, "subcategory");
    }
}
