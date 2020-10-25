package jdi.blazedemo.page;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.epam.jdi.uitests.web.settings.WebSettings.getDriver;
import static com.epam.web.matcher.testng.Assert.assertEquals;

@JPage(url = "/purchase.php")
public class PrivatePage extends WebPage {

    @FindBy(xpath = "//p[2]")
    public WebElement find_number_2;
    @FindBy(xpath = "//p[1]")
    public WebElement find_airline_2;
    @FindBy(xpath = "//p[3]")
    public WebElement find_price_2;
    @FindBy(xpath = "//p[4]")
    public WebElement find_cost_2;
    @FindBy(xpath = "//em")
    public WebElement find_totalcost;

    @FindBy(css = "input[name='inputName']")
    public WebElement find_inputname;
    @FindBy(css = "input[name='address']")
    public WebElement find_inputaddress;
    @FindBy(css = "input[name='city']")
    public WebElement find_inputcity;
    @FindBy(css = "input[name='state']")
    public WebElement find_inputstate;
    @FindBy(css = "input[name='zipCode']")
    public WebElement find_inputzipCode;
    @FindBy(css = "input[name='creditCardNumber']")
    public WebElement find_inputcreditCardNumber;
    @FindBy(css = "input[name='creditCardMonth']")
    public WebElement find_inputcreditCardMonth;
    @FindBy(css = "input[name='creditCardYear']")
    public WebElement find_inputcreditCardYear;
    @FindBy(css = "input[name='nameOnCard']")
    public WebElement find_inputnameOnCard;
    @FindBy(css = "input[type='submit']")
    public WebElement find_button_3;

    By byName = By.cssSelector("input[name='inputName']");
    @Step
    public PrivatePage inputname(String sendName) {
//        find_inputname.sendKeys(sendName);
        getDriver().findElement(byName).sendKeys(sendName);
        return this;
    }



    public void inputaddress(String sendaddress) {
        find_inputaddress.sendKeys(sendaddress);
    }
    public void inputcity(String sendcity) {
        find_inputcity.sendKeys(sendcity);
    }
    public void inputstate(String sendstate)  {
        find_inputstate.sendKeys(sendstate);
    }
    public void inputzipCode(String sendzipCode) {
        find_inputzipCode.sendKeys(sendzipCode);
    }
    public void inputcreditCardNumber(String sendcreditcardnumber) {
        find_inputcreditCardNumber.sendKeys(sendcreditcardnumber);
    }
    public void inputcreditCardMonth(String sendcreditcadrmonth) {
        find_inputcreditCardMonth.sendKeys(sendcreditcadrmonth);
    }
    public void inputcreditCardYear(String sendcreditcardyear) {
        find_inputcreditCardYear.sendKeys(sendcreditcardyear);
    }
    public void inputnameOnCard(String sendnumbeoncard) {
        find_inputnameOnCard.sendKeys(sendnumbeoncard);
    }
    public void submit() {
        find_button_3.click();
    }


}
