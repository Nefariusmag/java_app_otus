package tests;

import blazedemo.FinishPage;
import blazedemo.FlightsPage;
import blazedemo.PrivatPage;
import blazedemo.SelectPage;
import listener.EventListener;
import listener.TestListener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static com.codeborne.selenide.WebDriverRunner.addListener;
import static listener.TakeScreenShot.takeSrceenShot;

@Listeners(TestListener.class)
public class Homework11Test {

    protected WebDriver driver;
    String url = "http://blazedemo.com/";

    @BeforeClass
    public void beforetest(){

        driver = WebDriverManager.getDriver("Chrome-traffic");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(url);

        LogEntries logEntries = driver.manage().logs().get(LogType.PERFORMANCE);
        for(LogEntry entry : logEntries) {
            System.out.println(entry.getLevel() + " " + entry.getMessage());
        }
    }

    @Test
    public void test() {

        SelectPage selectPage = new SelectPage(driver);
        selectPage.selectFrom("San Diego");
        selectPage.selectTo("Berlin");
        selectPage.submit();

        FlightsPage fligtPage = new FlightsPage(driver);
        String from_to = "Flights from San Diego to Berlin:";
        fligtPage.From_to(from_to);
//        System.out.println(fligtPage.find_number.getText());
//        System.out.print(fligtPage.getTEstTExt());
        String find_number_text = fligtPage.find_number.getText();
        String find_airline_text = fligtPage.find_airline.getText();
        String find_price_text = fligtPage.find_price.getText();
        fligtPage.submit();

        PrivatPage privatPage = new PrivatPage(driver);

        privatPage.EqualNumber(find_number_text);
        privatPage.EqualAirline(find_airline_text);
        privatPage.EqualPrice(find_price_text);
        privatPage.EqualCost();
        privatPage.inputname("Misha");
        privatPage.inputaddress("Mishstreat");
        privatPage.inputcity("Mishcity");
        privatPage.inputstate("Mishstate");
        privatPage.inputzipCode("1919");
        privatPage.inputcreditCardMonth("10");
        privatPage.inputcreditCardYear("2018");
        privatPage.inputcreditCardNumber("111122223333444455556666");
        privatPage.inputnameOnCard("Misha Mishkovich");
        privatPage.submit();

        FinishPage finishPage = new FinishPage(driver);
        finishPage.Find_id();
        finishPage.Find_status();
        finishPage.Find_amont();
        finishPage.Find_cardnumber("111122223333444455556666");

    }

    @AfterClass
    public void aftertest(){

        driver.quit();

    }
}
