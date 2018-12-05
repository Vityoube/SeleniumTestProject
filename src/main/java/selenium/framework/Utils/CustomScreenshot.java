package selenium.framework.Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CustomScreenshot {
    CustomFileUtils customFileUtils;

    public CustomScreenshot() {
        this.customFileUtils = new CustomFileUtils();
    }

    public void makeScreenshot(WebDriver driver,String fileName){
        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile,
                    new File(customFileUtils.getProjectPath()+"/"+BaseProperties.screenshotPath+fileName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
