package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver = null;

    @Before
    public static void OpenBrowser(){
        // Define Bridge
        WebDriverManager.chromedriver().setup();

        //Create Object from chrome driver
        driver = new ChromeDriver();

        // Maximize screen
        driver.manage().window().maximize();

        // Implicit Waits
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Navigate to the website
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @After
    public static void QuiteBrowser() throws InterruptedException {

        Thread.sleep(3000);

        //Driver Quite
        driver.quit();
    }
}
