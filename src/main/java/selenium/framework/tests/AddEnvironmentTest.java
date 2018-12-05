package selenium.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.framework.Pages.AddEnvironmentPage;
import selenium.framework.Pages.DashboardPage;
import selenium.framework.Pages.EnvironmentPage;

public class AddEnvironmentTest extends AbstractTest {

    @Test
    public void successAddEnvironmentTest() {
        // wejscie do srodowiska
        DashboardPage dashboardPage = new DashboardPage(driver);
        EnvironmentPage environmentPage = dashboardPage.goToEnvironmentPage();

        // wejscie do dodania srodowiska
        AddEnvironmentPage addEnvironmentPage = environmentPage.goToAddEnvironmentPage();



        //uzupelnienie formularza
        // wyslanie formularza
        environmentPage = addEnvironmentPage.fillAddEnvironmentForm("nazwa", "opis").submitAddEnvironmentForm();
        // sprawdzenie czy udalo sie dodac
        Assert.assertTrue(environmentPage.isInfoBoxDisplayed());

    }

}
