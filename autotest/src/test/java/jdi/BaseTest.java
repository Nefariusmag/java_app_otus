package jdi;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import jdi.blazedemo.JDIExsampleSite;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends TestNGBase {

    @BeforeSuite(alwaysRun = true)
    public static void setUp(){
        WebSite.init(JDIExsampleSite.class);
    }

}
