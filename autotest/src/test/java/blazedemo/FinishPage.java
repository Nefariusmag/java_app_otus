package blazedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FinishPage {

    private WebDriver driver;

    @FindBy(xpath = "//tr[1]/td[2]")
    private WebElement find_id;
    @FindBy(xpath = "//tr[2]/td[2]")
    private WebElement find_status;
    @FindBy(xpath = "//tr[3]/td[2]")
    private WebElement find_amont;
    @FindBy(xpath = "//tr[4]/td[2]")
    private WebElement find_cardnumber;

    public FinishPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void Find_id() {
        assertTrue(find_id.isDisplayed());
    }

    public void Find_status() {
        assertTrue(find_status.isDisplayed());
    }

    public void Find_amont() {
        String find_amont_text = find_amont.getText();
        assertEquals("USD", find_amont_text, "Error!!");
    }

    public void Find_cardnumber(String optionValue) {
        String find_cardnumber_text = find_cardnumber.getText();
        String sendcreditcardnumber_char = optionValue.substring(optionValue.length() - 4, optionValue.length());
        String find_cardnumber_char = find_cardnumber_text.substring(find_cardnumber_text.length() - 4, find_cardnumber_text.length());
        assertEquals(sendcreditcardnumber_char, find_cardnumber_char, "Error");
    }


}
