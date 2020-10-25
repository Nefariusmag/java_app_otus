package listener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.WebDriverManager;

import java.io.PrintWriter;
import java.io.StringWriter;

import static listener.TestScreenShot.takeSrceenShot;
import static utils.WebDriverManager.getDriver;

public class TestLog4jListener implements ITestListener {

    private Logger logger = Logger.getLogger(TestLog4jListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        BasicConfigurator.configure();
        logger.info("Поехали!");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

        takeSrceenShot(WebDriverManager.getInstance());

        logger.error("Пичаль!!! " + result.getTestClass() + " " + result.getTestName());

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Throwable cause = result.getThrowable();
        cause.printStackTrace(printWriter);
        logger.error(stringWriter.getBuffer().toString());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}
