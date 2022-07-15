package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Home;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_FollowUS {
    Home home = new Home(Hooks.driver);

    @When("user open Facebook link")
    public void step01()
    {
        home.Facebook().click();
    }

    @Then("is opened in new tab \"(.*)\"$")
    public void step02(String Link) throws InterruptedException
    {
        Thread.sleep(3000);
        ArrayList<String> Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));

        switch (Link)
        {

            case "facebook-Link":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.facebook.com/nopCommerce", "Facebook link");
                break;

            case "twitter-Link":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://twitter.com/nopCommerce", "Twitter link");
                break;

            case "rss-Link":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/new-online-store-is-open", "RSS link");
                break;

            case "youtube-Link":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.youtube.com/user/nopCommerce", "Youtube link");
                break;
        }
        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
    }

    @When("user open Twitter link")
    public void user_opens_twitter()
    {
        home.Twitter().click();
    }

    @When("user open RSS link")
    public void user_opens_rss()
    {
        home.RSS().click();
    }

    @When("user open Youtube link")
    public void user_opens_youtube()
    {
        home.Youtube().click();
    }
}