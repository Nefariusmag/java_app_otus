package jdi;

import org.testng.annotations.Test;

import static jdi.blazedemo.JDIExsampleSite.navigationSite;

public class Homework9Test extends BaseTest {

    @Test
    public void test(){

        navigationSite.openSelectPage();
        navigationSite.openFlightspage();
        navigationSite.openPrivatePage();
        navigationSite.openFinishPage();

    }

}
