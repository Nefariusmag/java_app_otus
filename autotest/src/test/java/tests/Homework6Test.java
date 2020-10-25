package tests;

import automationpractice.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WebDriverManager;

public class Homework6Test {

    WebDriver driver;

    @BeforeClass
    public void beforetest() {

        driver = WebDriverManager.getDriver("Chrome-remote");

    }

    @Test
    public void test() {

        driver.get("http://automationpractice.com/index.php");
        HomePage homePage = new HomePage(driver);
        homePage.getMouseMoveToButton();
        homePage.waitMenu(homePage.findTShirts);
        homePage.clickOnTShirts(homePage.findTShirts);
        homePage.checkTShirtsPage(homePage.findTShirtsPage);

    }

    @AfterClass
    public void aftertest() {

        driver.quit();

    }
}
