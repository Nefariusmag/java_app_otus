package blazedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class FlightsPage {

    private WebDriver driver;

    @FindBy(xpath = "//h3")
    private WebElement find_from_to;
    @FindBy(xpath = "//tr[1]/td[2]")
    public WebElement find_number;
    @FindBy(xpath = "//tr[1]/td[3]")
    public WebElement find_airline;
    @FindBy(xpath = "//tr[1]/td[6]")
    public WebElement find_price;
    @FindBy(css = "input[type='submit']")
    private WebElement find_button_2;

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public String getTEstTExt() {
//       return find_number.getText();
//    }


    public void From_to(String optionValue) {
        String find_from_to_text = find_from_to.getText();
        assertEquals(optionValue, find_from_to_text, "Error!!");
    }

    public void submit(){
        find_button_2.click();
    }

}
