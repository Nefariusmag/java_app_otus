package artlebedev;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class InventoryPage {

    public MatrixPage goToMatrixIdeasPage(){
        $x("//a[@class=\"item item-matrix\"]").click();
        return page(MatrixPage.class);
    }

}
