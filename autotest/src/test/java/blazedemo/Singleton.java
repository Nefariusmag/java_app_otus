package blazedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utils.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Singleton {

    private String URL_what_you_need= "http://blazedemo.com/";

    @Test
    public void getSite() {

        WebDriverManager.getInstance().get(URL_what_you_need);

        WebElement findbutton = WebDriverManager.getInstance().findElement(By.cssSelector("input[type='submit']"));

        findbutton.click();

        WebElement findnewopen = WebDriverManager.getInstance().findElement(By.className("table"));

        assertTrue(findnewopen.isDisplayed());

    }

    @AfterClass
    public void aftertest() {

        WebDriverManager.getInstance().quit();

    }
}
