package jdi.blazedemo;


import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import jdi.blazedemo.page.FinishPage;
import jdi.blazedemo.page.FlightsPage;
import jdi.blazedemo.page.PrivatePage;
import jdi.blazedemo.page.SelectPage;

@JSite(value = "http://blazedemo.com/")
public class JDIExsampleSite extends WebSite {
    @JPage
    public static SelectPage selectPage;

    @JPage
    public static FlightsPage flightsPage;

    @JPage
    public static PrivatePage privatePage;

    @JPage
    public static FinishPage finishPage;

    @JPage
    public static NavigationSite navigationSite;
}
