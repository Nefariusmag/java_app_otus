package spytnik;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.sputnik.ru/")
public class HomePage extends PageObject {

    @FindBy(css = "input[id='js-search-input']")
    private WebElementFacade searchInput;

    @FindBy(css = "button[type='submit']")
    private WebElementFacade searchButton;

    public void inputTextForSearch(String optionValue){
        searchInput.type(optionValue);
    }

    public void clickSearchButton(){
        searchButton.click();
//        $("button[type=\"submit\"]").click();
    }

}
