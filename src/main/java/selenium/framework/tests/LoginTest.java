package selenium.framework.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import selenium.framework.Pages.DashboardPage;
import selenium.framework.Pages.LoginPage;
import selenium.framework.Utils.BaseProperties;
import selenium.framework.Utils.FileUtils;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    FileUtils fileUtils;

    @BeforeClass
    public void setUpClass() {
        fileUtils = new FileUtils();
        System.setProperty("webdriver.chrome.driver", fileUtils.getProjectPath()+"/" + BaseProperties.driverPath + BaseProperties.chromeDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(BaseProperties.baseUrl);
    }

    @Test
    public void successLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage =
                loginPage
                        .fillLoginForm(BaseProperties.baseAdminEmail, BaseProperties.baseAdminPassword)
                        .submitLoginForm();

        Assert.assertTrue(dashboardPage.isLogoutButtonDisplayed());
    }

    @AfterClass
    public void tearDownClass() {
        driver.quit();
    }

}
