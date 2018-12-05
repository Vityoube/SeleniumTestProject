package selenium.framework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends AbstractPage{
    @FindBy(css = "#head-top > div.top_right > div.header_logout > a > span")
    WebElement logoutButton;

    @FindBy(css = "#wrapper > ul > li:nth-child(4) > a")
    private WebElement environmentButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutButtonDisplayed() {
        return isElementDisplayed(logoutButton);
    }

    public  EnvironmentPage goToEnvironmentPage(){
        clickElement(environmentButton);
        return new EnvironmentPage(driver);

    }
}
