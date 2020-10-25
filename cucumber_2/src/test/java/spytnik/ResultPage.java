package spytnik;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage {

    @FindBy(xpath = "//*[contains(@class,'b-result-title')]/a")
    public WebElementFacade findResult;

    public void checkReult(String optionValue){
        Assert.assertEquals(optionValue, findResult.getText());
    }

}
