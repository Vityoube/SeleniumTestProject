package selenium.framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.framework.tests.AddEnvironmentTest;

public class EnvironmentPage extends AbstractPage {
    @FindBy(css = "#content > article > nav > ul > li > a")
    private WebElement addEnvironmentButton;
    @FindBy(id="j_info_box")
    private WebElement infoBox;

    public EnvironmentPage(WebDriver driver) {
        super(driver);
    }

    public AddEnvironmentPage goToAddEnvironmentPage(){
        clickElement(addEnvironmentButton);
        return new AddEnvironmentPage(driver);
    }

    public boolean isInfoBoxDisplayed(){
        return isElementDisplayed(infoBox);
    }
}
