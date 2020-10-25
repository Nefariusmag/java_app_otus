package listener;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot {

    public static void takeSrceenShot(WebDriver driver){

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs((OutputType.FILE));
        try {
            FileUtils.copyFile(scrFile, new File("target/screenshot/screenshot.png"));
        } catch (IOException e) {
        }

    }
}
