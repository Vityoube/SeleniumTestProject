package selenium.framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends AbstractPage{
    @FindBy(css = "#head-top > div.top_right > div.header_logout > a > span")
    WebElement logoutButton;

    @FindBy(css = "#wrapper > ul > li:nth-child(4) > a")
    private WebElement environmentsButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutButtonDisplayed() {
        return isElementDisplayed(logoutButton);
    }

    public EnvironmentsPage goToEnvironmentsPage(){
        clickElement(environmentsButton);
        return new EnvironmentsPage(driver);

    }
}
