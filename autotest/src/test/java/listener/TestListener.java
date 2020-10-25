package listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.WebDriverManager;


import java.io.PrintWriter;
import java.io.StringWriter;

import static listener.TakeScreenShot.takeSrceenShot;

public class TestListener implements ITestListener {

    private Logger logger = Logger.getLogger((TestListener.class));

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Поехали!");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Отлично, все готово");
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
