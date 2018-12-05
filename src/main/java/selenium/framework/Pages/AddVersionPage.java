package selenium.framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddVersionPage extends AbstractPage {
    @FindBy(id = "name")
    private WebElement nameField;
    @FindBy(id="description")
    private WebElement descField;
    @FindBy(id = "save")
    private WebElement saveButton;

    public AddVersionPage(WebDriver driver) {
        super(driver);
    }

    public AddVersionPage fillForm(String name, String desc) {
        fillField(nameField,name);
        fillField(descField,desc);
        return this;
    }

    public VersionsPage submitForm() {
        clickElement(saveButton);
        return new VersionsPage(driver);
    }
}
