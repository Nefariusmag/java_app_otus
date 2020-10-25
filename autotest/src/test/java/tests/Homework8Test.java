package tests;

import artlebedev.HomePage;
import artlebedev.InventoryPage;
import artlebedev.MatrixPage;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static artlebedev.HomePage.enterToHomePage;

public class Homework8Test {

    String searchWord = "Квант";

    @BeforeTest
    public void beforeTest() {
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void artlebedevGenerateIdeaTest() {

        HomePage homePage = enterToHomePage();
        homePage.goToInventoriyPage();

        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.goToMatrixIdeasPage();

        MatrixPage matrixPage = new MatrixPage();
        matrixPage.inputSearchWord(searchWord);
        matrixPage.generateIdea();
        matrixPage.searchFindElenet(searchWord);

    }

    @Test
    public void artlebedevGenerateIdea2Test() {

        enterToHomePage()
                .goToInventoriyPage()
                .goToMatrixIdeasPage()
                .inputSearchWord(searchWord)
                .generateIdea()
                .searchFindElenet(searchWord);

    }

}
