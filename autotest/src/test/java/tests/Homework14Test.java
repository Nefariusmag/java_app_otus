package tests;

import blazedemo.FlightsPage;
import blazedemo.SelectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Homework14Test {
    WebDriver driver;

    @BeforeClass
    public void beforetest(){

        driver = new ChromeDriver();

    }

    @Test(dataProvider = "xsstest")
    public void test1(String xssFrom, String xssTo) {

        driver.get("http://blazedemo.com/");

        SelectPage selectPage = new SelectPage(driver);
        selectPage.selectFrom(xssFrom);
        selectPage.selectTo(xssTo);
        selectPage.submit();

        FlightsPage fligtPage = new FlightsPage(driver);
        String from_to = "Flights from " + xssFrom + " to " + xssTo + ":";
        fligtPage.From_to(from_to);

    }

    @Test(dataProvider = "xssfalsetest")
    public void test2(String xssFrom, String xssTo) throws InterruptedException {

        driver.get("http://blazedemo.com/");

        SelectPage selectPage = new SelectPage(driver);
        selectPage.selectFrom(xssFrom);
        selectPage.selectTo(xssTo);
        selectPage.submit();

        FlightsPage fligtPage = new FlightsPage(driver);
        String from_to = "Flights from " + xssFrom + " to " + xssTo + ":";

        try {
            fligtPage.From_to(from_to);
            System.out.println("Ввели неправильное значение и прошло");
        } catch (AssertionError e) {
            System.out.println("Всё ок, лишнего не ввести");
        }


    }

    @DataProvider(name = "xsstest")
    public Object[][] xssDataProvider(){
        return new Object[][] {{"San Diego", "Berlin"}};
    }

    @DataProvider(name = "xssfalsetest")
    public Object[][] xssDataProvider2(){
        return new Object[][] {{"Moscow", "London"}};
    }


    @AfterClass
    public void aftertest(){

        driver.quit();

    }

}
