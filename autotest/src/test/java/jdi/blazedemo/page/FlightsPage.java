package jdi.blazedemo.page;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.epam.web.matcher.testng.Assert.assertEquals;

@JPage(url = "/reserve.php")
public class FlightsPage extends WebPage {

//    @FindBy(xpath = "//h3")
//    public WebElement find_from_to;

    By byNumber = By.xpath("//tr[1]/td[2]");
    public String find_number_text(){
        return getDriver().findElement(byNumber).getText();
    }
    By byAirline = By.xpath("//tr[1]/td[3]");
    public String find_airline_text(){
        return getDriver().findElement(byAirline).getText();
    }
    By byPrice = By.xpath("//tr[1]/td[3]");
    public String find_price_text(){
        return  getDriver().findElement(byPrice).getText();
    }

    By find_from_to =  By.xpath("//h3");
    @Step
    public FlightsPage From_to(String from_to) {
        assertEquals(from_to, getDriver().findElement(find_from_to).getText(), "Error!!");
        return this;
    }

    By byButton = By.cssSelector("input[type='submit']");
    @Step
    public FlightsPage submit() {

        getDriver().findElement(byButton).click();
        return this;

    }

}
