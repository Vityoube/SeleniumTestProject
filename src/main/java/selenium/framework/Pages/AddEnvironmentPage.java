package selenium.framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEnvironmentPage extends AbstractPage {
    @FindBy(id="name")
    private WebElement nameField;
    @FindBy(id="description")
    private WebElement descriptionField;
    @FindBy(id="save")
    private WebElement saveButton;
    @FindBy(css="#j_info_box > div")
    private WebElement infoBoxIcon;

    public AddEnvironmentPage(WebDriver driver) {
        super(driver);
    }

    public  AddEnvironmentPage fillAddEnvironmentForm(String name, String description){
        // wypelnienie nazwy
        fillField(nameField,name);
        //wypelnienie opisu
        fillField(descriptionField,description);
        return this;
    }

    public EnvironmentsPage submitAddEnvironmentForm(){
        clickElement(saveButton);
        return new EnvironmentsPage(driver);
    }
    public boolean isInfoBoxStatusSuccess(){
        return isAttributeValueMatch(infoBoxIcon,"class","icon_info");
    }
}
