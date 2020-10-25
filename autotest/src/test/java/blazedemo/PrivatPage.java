package blazedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;


public class PrivatPage {

    private WebDriver driver;

    @FindBy(xpath = "//p[2]")
    private WebElement find_number_2;
    @FindBy(xpath = "//p[1]")
    private WebElement find_airline_2;
    @FindBy(xpath = "//p[3]")
    private WebElement find_price_2;
    @FindBy(xpath = "//p[4]")
    private WebElement find_cost_2;
    @FindBy(xpath = "//em")
    private WebElement find_totalcost;
    @FindBy(css = "input[name='inputName']")
    private WebElement find_inputname;
    @FindBy(css = "input[name='address']")
    private WebElement find_inputaddress;
    @FindBy(css = "input[name='city']")
    private WebElement find_inputcity;
    @FindBy(css = "input[name='state']")
    private WebElement find_inputstate;
    @FindBy(css = "input[name='zipCode']")
    private WebElement find_inputzipCode;
    @FindBy(css = "input[name='creditCardNumber']")
    private WebElement find_inputcreditCardNumber;
    @FindBy(css = "input[name='creditCardMonth']")
    private WebElement find_inputcreditCardMonth;
    @FindBy(css = "input[name='creditCardYear']")
    private WebElement find_inputcreditCardYear;
    @FindBy(css = "input[name='nameOnCard']")
    private WebElement find_inputnameOnCard;
    @FindBy(css = "input[type='submit']")
    private WebElement find_button_3;

    public PrivatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void EqualNumber(String optionValue){
        String find_number_2_text = find_number_2.getText();
        String find_number_2_text_split = find_number_2_text.split(": ")[1];
        assertEquals(optionValue, find_number_2_text_split, "Error!!" );
    }
    public void EqualAirline(String optionValue){
        String find_airline_2_text = find_airline_2.getText();
        String find_airline_2_text_split = find_airline_2_text.split(": ")[1];
        assertEquals(optionValue, find_airline_2_text_split, "Error!!" );
    }
    public void EqualPrice(String optionValue){
        String find_price_2_text = find_price_2.getText();
        String find_price_2_text_split = find_price_2_text.split(": ")[1];
        assertEquals(optionValue, "$" + find_price_2_text_split, "Error!!" );
    }
    public void EqualCost(){
        String find_price_2_text = find_price_2.getText();
        String find_price_2_text_split = find_price_2_text.split(": ")[1];
        Float find_cost_1_float = Float.parseFloat(find_price_2_text_split);
        String find_cost_2_text = find_cost_2.getText();
        String find_cost_2_text_split = find_cost_2_text.split(": ")[1];
        Float find_cost_2_float = Float.parseFloat(find_cost_2_text_split);
        Float totalcost_summ_float = find_cost_1_float + find_cost_2_float;
        String find_totalcost_text = find_totalcost.getText();
        Float find_totalcost_float = Float.parseFloat(find_totalcost_text);
        assertEquals(totalcost_summ_float, find_totalcost_float, "Error!!");
    }

    public void inputname(String optionValue) {
        find_inputname.sendKeys(optionValue);
    }

    public void inputaddress(String optionValue) {
        find_inputaddress.sendKeys(optionValue);
    }

    public void inputcity(String optionValue) {
        find_inputcity.sendKeys(optionValue);
    }

    public void inputstate(String optionValue) {
        find_inputstate.sendKeys(optionValue);
    }

    public void inputzipCode(String optionValue) {
        find_inputzipCode.sendKeys(optionValue);
    }

    public void inputcreditCardNumber(String optionValue) {
        find_inputcreditCardNumber.sendKeys(optionValue);
    }

    public void inputcreditCardMonth(String optionValue) {
        find_inputcreditCardMonth.sendKeys(optionValue);
    }

    public void inputcreditCardYear(String optionValue) {
        find_inputcreditCardYear.sendKeys(optionValue);
    }

    public void inputnameOnCard(String optionValue) {
        find_inputnameOnCard.sendKeys(optionValue);
    }

    public void submit() {
        find_button_3.click();
    }

}
