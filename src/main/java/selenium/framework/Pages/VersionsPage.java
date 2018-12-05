package selenium.framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VersionsPage  extends  AbstractPage{
    @FindBy(css = "#content > article > nav > ul > li > a")
    private WebElement addVersionButton;
    @FindBy(id="j_info_box")
    private WebElement infoBox;
    @FindBy(css="#wrapper > ul > li.item1 > a")
    private WebElement dashboardButton;
    @FindBy(css="#j_info_box > div")
    private WebElement infoBoxIcon;

    public VersionsPage(WebDriver driver) {
        super(driver);
    }


    public AddVersionPage goToAddVersionPage() {
        clickElement(addVersionButton);
        return new AddVersionPage(driver);
    }

    public boolean isInfoBoxDisplayed() {
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
