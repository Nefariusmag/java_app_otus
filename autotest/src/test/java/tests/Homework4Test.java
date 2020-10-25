package tests;

import blazedemo.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homework4Test {

    WebDriver driver;

    @BeforeClass
    public void beforetest() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get("http://blazedemo.com/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.equalsSize(loginPage.getSizeAfter());
        loginPage.equalsColor(loginPage.getColorAfter());
    }

    @AfterClass
    public void aftertest() {
        driver.quit();
    }
}
