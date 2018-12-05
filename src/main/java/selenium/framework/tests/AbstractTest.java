package selenium.framework.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import selenium.framework.Utils.BaseProperties;
import selenium.framework.Utils.FileUtils;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    protected static WebDriver driver;
    protected FileUtils fileUtils;

    @BeforeTest
    public void setUpTest() {
        fileUtils = new FileUtils();
        System.setProperty("webdriver.chrome.driver", fileUtils.getProjectPath() + "/" + BaseProperties.driverPath + BaseProperties.chromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(BaseProperties.baseUrl);
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
    }
}
