package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;


public class Homework15Test {

    private static String API_URL = "https://dictionary.yandex.net/api/v1/dicservice.json/";
    private static String API_KEY = "dict.1.1.20180725T172621Z.918e4c8c029f1077.661a23216306127b70aec3ad9b41c3e7fa710b76";
    private static String lang_lang = "en-ru";
    private static String text = "Shalom";

    @Test
    public void getLangsTest(){
        given().
        when().
                get(API_URL + "getLangs?key=" + API_KEY).
        then().
                statusCode(200).
                body("$", hasItem(lang_lang));
    }

    @Test
    public void lookupTest(){
//        Можете не писать given() и when() если у вас простой запрос GET без Headers. Тогда ваши тесты будут начинаться с метода get().
        given().
        when().
                get(API_URL + "lookup?key=" + API_KEY + "&lang= " + lang_lang + "&text=" + text).
        then().
                statusCode(200).
                body("def.tr.text[0][0]", equalTo("Шалом"));
    }
}
