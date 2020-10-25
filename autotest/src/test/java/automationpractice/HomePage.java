package automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverManager;

import static org.testng.Assert.assertTrue;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "(//a[@class='sf-with-ul'])[1]")
    public WebElement findButton;

    @FindBy(css = "a[title=\"T-shirts\"]")
    public WebElement findTShirts;

    @FindBy(css = "span[class=cat-name]")
    public WebElement findTShirtsPage;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void getMouseMoveToButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(findButton).build().perform();
    }

    public void waitMenu(WebElement optionValue){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(optionValue));
    }

    public void clickOnTShirts(WebElement optionValue){
        optionValue.click();
    }

    public void checkTShirtsPage(WebElement optionValue){
        assertTrue(optionValue.isDisplayed());

    }

}
