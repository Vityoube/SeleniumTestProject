package selenium.framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.framework.tests.AddEnvironmentTest;

public class EnvironmentsPage extends AbstractPage {
    @FindBy(css = "#content > article > nav > ul > li > a")
    private WebElement addEnvironmentButton;
    @FindBy(id="j_info_box")
    private WebElement infoBox;
    @FindBy(css="#wrapper > ul > li.item1 > a")
    private WebElement dashboardButton;
    @FindBy(css="#j_info_box > div")
    private WebElement infoBoxIcon;

    public EnvironmentsPage(WebDriver driver) {
        super(driver);
    }

    public AddEnvironmentPage goToAddEnvironmentPage(){
        clickElement(addEnvironmentButton);
        return new AddEnvironmentPage(driver);
    }

    public boolean isInfoBoxDisplayed(){
        return isElementDisplayed(infoBox);
    }

    public DashboardPage goToDashboardPage() {
        clickElement(dashboardButton);
        return new DashboardPage(driver);
    }
    public boolean isInfoBoxStatusSuccess(){
        return isAttributeValueMatch(infoBoxIcon,"class","icon_info");
    }
}
