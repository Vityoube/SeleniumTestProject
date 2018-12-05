package selenium.framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    protected  void fillField(WebElement element,String value){
        element.clear();
        element.sendKeys(value);
    }

    protected  void clickElement(WebElement element){
        element.click();
    }

    protected  boolean isElementDisplayed(WebElement element){
        return  element.isDisplayed();
    }
}
