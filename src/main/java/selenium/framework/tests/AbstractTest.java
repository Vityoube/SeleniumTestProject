package selenium.framework.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import selenium.framework.Utils.BaseProperties;
import selenium.framework.Utils.CustomFileUtils;
import selenium.framework.Utils.CustomScreenshot;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    protected static WebDriver driver;
    protected static CustomFileUtils customFileUtils;
    protected static CustomScreenshot customScreenshot;

    @BeforeTest
    @Parameters({"deleteScreenshots"})
    public void setUpTest(String deleteScreenshots) {
        customFileUtils = new CustomFileUtils();
        customScreenshot=new CustomScreenshot();
        System.setProperty("webdriver.chrome.driver", customFileUtils.getProjectPath() + "/" + BaseProperties.driverPath + BaseProperties.chromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(BaseProperties.baseUrl);
        if("true".equals(deleteScreenshots))
            customFileUtils.deleteProjectDirectory(BaseProperties.screenshotPath);
    }

    @AfterMethod
    @Parameters({"makeScreenshot"})
    public void tearDownMethod(ITestResult result, String makeScreenshot){
        if (makeScreenshot.equalsIgnoreCase("onFailure")){
            if(result.getStatus()==ITestResult.FAILURE){
                customScreenshot.makeScreenshot(driver,new Date().getTime()+"_"+result.getMethod().getMethodName()
                        +"_"+BaseProperties.statusName[result.getStatus()-1]
                );
            }
        } else {
                customScreenshot.makeScreenshot(driver,new Date().getTime()+"_"+result.getMethod().getMethodName()
                        +"_"+BaseProperties.statusName[result.getStatus()-1]);
        }


    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
    }
}
