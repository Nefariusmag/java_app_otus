package testcucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class YandexSteps {

    private WebDriver driver;

    @Given("^I am on the Yandex Home page$")
    public void i_am_on_the_yandex_home_page(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.yandex.ru/");

    }

    @When("^I search \"(.*)\"$")
    public void i_search (String query){
        driver.findElement(By.cssSelector("input[class='input__control input__input']")).sendKeys(query);
        driver.findElement(By.cssSelector("button[class='button suggest2-form__button button_theme_websearch button_size_ws-head i-bem button_js_inited']")).click();

    }

    @Then("^I found \"(.*)\"$")
    public void i_found (String word){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String element = driver.findElement(By.cssSelector("span[class='textarea__wrap']")).getText();
        Assert.assertEquals(word, element);
        driver.close();
    }
}
