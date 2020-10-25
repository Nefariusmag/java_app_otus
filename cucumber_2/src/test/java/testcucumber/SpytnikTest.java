package testcucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import spytnik.HomePage;
import spytnik.ResultPage;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class SputnikTest {

    HomePage homePage;
    ResultPage resultPage;

    @Given("^user on the spytnik home page$")
    public void user_on_spytnik_home_page (){
        homePage.open();
    }

    @When("^user input \"(.*)\"$")
    public void user_input (String searchText) {
        homePage.inputTextForSearch(searchText);
    }

    @And("^user click search$")
    public void user_click_search (){
        homePage.clickSearchButton();
    }

    @Then("^user found \"(.*)\"$")
    public void user_found (String findText) throws InterruptedException {
        Thread.sleep(1000);
        resultPage.checkReult(findText);

    }

}
