package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Homework16Test {

    private static String API_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    private static String API_KEY = "trnsl.1.1.20180802T114243Z.2aa657b233e6dcec.19d24bb2d7270b55be48730fca35c37f9f794e1f";
    private static String lang_lang = "en-ru";
    private static String text = "Shalom";
    private String textUniRest;

//    private static String textUniRest;

    @BeforeTest
    public void getValueFromRest() throws UnirestException {

        String jsonUniRest = Unirest.get(API_URL).queryString("key", API_KEY)
                .queryString("lang", lang_lang)
                .queryString("text", text)
                .asString()
                .getBody();

        textUniRest = JsonPath.read(jsonUniRest, "$.text[0]");

    }

    @Test
    public void validationValueFromUI(){

        Configuration.browser = "chrome";
        System.setProperty("selenide.browser", "chrome");
        open("https://translate.yandex.ru/");
        $("div[id='fakeArea']").setValue(text);
        $("pre[id='translation']").should(Condition.text(textUniRest));

    }


}
