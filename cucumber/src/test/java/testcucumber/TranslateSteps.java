package testcucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TranslateSteps {

    private WebDriver driver;

    @Given("^I am on the Home page$")
    public void i_am_on_the_home_page(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.yandex.ru/");

    }

    @When("^I go to service translate and send sms to number \"(.*)\"$")
    public void i_go_to_service_translate_and_send_sms_to_number (String query){

        driver.findElement(By.cssSelector("a[data-id='translate']")).click();
        driver.findElement(By.cssSelector("input[id='smsPhoneInput']")).sendKeys(query);
        driver.findElement(By.cssSelector("span[class='sms-send-button-text']")).click();

    }

    @Then("^I found message \"(.*)\"$")
    public void I_found_message (String word){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String element = driver.findElement(By.cssSelector("span[class='sms-success-text']")).getText();
        Assert.assertEquals(word, element);
        driver.close();
    }
}
