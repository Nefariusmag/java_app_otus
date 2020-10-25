package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Homework1 {

    @Test
    public void test() {

        WebDriver driver = new ChromeDriver();

        driver.get("http://blazedemo.com/");

        WebElement findbutton = driver.findElement(By.cssSelector("input[type='submit']"));

        findbutton.click();

        WebElement findnewopen = driver.findElement(By.className("table"));

        assertTrue(findnewopen.isDisplayed());

        driver.quit();

    }
}
