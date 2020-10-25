package jdi.blazedemo.page;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.web.matcher.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

@JPage(url = "/confirmation.php")
public class FinishPage extends WebPage {

    @FindBy(xpath = "//tr[1]/td[2]")
    public WebElement find_id;
    @FindBy(xpath = "//tr[2]/td[2]")
    public WebElement find_status;
    @FindBy(xpath = "//tr[3]/td[2]")
    public WebElement find_amont;
    @FindBy(xpath = "//tr[4]/td[2]")
    public WebElement find_cardnumber;

    public void Find_id() {
        assertTrue(find_id.isDisplayed());
    }
    public void Find_status() {
        assertTrue(find_status.isDisplayed());
    }
    public void Find_amont() {
        String find_amont_text = find_amont.getText();
        assertEquals("Error!", "USD", find_amont_text);
    }
    public void Find_cardnumber(String sendcreditcardnumber) {
        String find_cardnumber_text = find_cardnumber.getText();
        String sendcreditcardnumber_char = sendcreditcardnumber.substring(sendcreditcardnumber.length() - 4, sendcreditcardnumber.length());
        String find_cardnumber_char = find_cardnumber_text.substring(find_cardnumber_text.length() - 4, find_cardnumber_text.length());
        assertEquals("Error", sendcreditcardnumber_char, find_cardnumber_char);
    }

}
