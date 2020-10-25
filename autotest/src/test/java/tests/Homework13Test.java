package tests;

import automationpractice.HomePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WebDriverManager;

public class Homework13Test {

    WebDriver driver;

    @BeforeClass
    public void beforetest() {

        driver = WebDriverManager.getDriver("Chrome-remote");
        driver.manage().window().setSize(new Dimension(1920, 1080));

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

    @Test
    public void test2() {

        HomePage homePage = new HomePage(driver);
        homePage.getMouseMoveToButton();
        homePage.waitMenu(homePage.findTShirts);
        homePage.clickOnTShirts(homePage.findTShirts);
        homePage.checkTShirtsPage(homePage.findTShirtsPage);
        homePage.getMouseMoveToButton();
        homePage.waitMenu(homePage.findTShirts);
        homePage.clickOnTShirts(homePage.findTShirts);
        homePage.checkTShirtsPage(homePage.findTShirtsPage);
        homePage.getMouseMoveToButton();
        homePage.waitMenu(homePage.findTShirts);
        homePage.clickOnTShirts(homePage.findTShirts);
        homePage.checkTShirtsPage(homePage.findTShirtsPage);
        homePage.getMouseMoveToButton();
        homePage.waitMenu(homePage.findTShirts);
        homePage.clickOnTShirts(homePage.findTShirts);
        homePage.checkTShirtsPage(homePage.findTShirtsPage);
        homePage.getMouseMoveToButton();
        homePage.waitMenu(homePage.findTShirts);
        homePage.clickOnTShirts(homePage.findTShirts);
        homePage.checkTShirtsPage(homePage.findTShirtsPage);
        homePage.getMouseMoveToButton();
        homePage.waitMenu(homePage.findTShirts);
        homePage.clickOnTShirts(homePage.findTShirts);
        homePage.checkTShirtsPage(homePage.findTShirtsPage);
        homePage.getMouseMoveToButton();
        homePage.waitMenu(homePage.findTShirts);
        homePage.clickOnTShirts(homePage.findTShirts);
        homePage.checkTShirtsPage(homePage.findTShirtsPage);
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
