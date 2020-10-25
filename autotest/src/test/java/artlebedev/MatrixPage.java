package artlebedev;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class MatrixPage {

    public MatrixPage inputSearchWord(String optionValue){
        $x("//input[@name=\"Word\"]").setValue(optionValue);
        return this;
    }

    public MatrixPage generateIdea(){
        $x("//button[@type=\"submit\"]").click();
        return this;
    }

    public MatrixPage searchFindElenet(String optionValue){
        $x("//div[@class=\"als-columns text-double-margin\"]").should(text(optionValue));
        return this;
    }

}
