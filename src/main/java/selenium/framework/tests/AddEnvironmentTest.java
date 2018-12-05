package selenium.framework.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import selenium.framework.Pages.AddEnvironmentPage;
import selenium.framework.Pages.DashboardPage;
import selenium.framework.Pages.EnvironmentsPage;

import java.util.Date;

public class AddEnvironmentTest extends AbstractTest {

    @Test
    public void successAddEnvironmentTest() {
        // wejscie do srodowiska
        DashboardPage dashboardPage = new DashboardPage(driver);
        EnvironmentsPage environmentsPage = dashboardPage.goToEnvironmentsPage();

        // wejscie do dodania srodowiska
        AddEnvironmentPage addEnvironmentPage = environmentsPage.goToAddEnvironmentPage();


        //uzupelnienie formularza
        // wyslanie formularza
        environmentsPage = addEnvironmentPage.fillAddEnvironmentForm("Environment_" + new Date().getTime(),
                "opis").submitAddEnvironmentForm();
        // sprawdzenie czy udalo sie dodac
        Assert.assertTrue(environmentsPage.isInfoBoxDisplayed());
        Assert.assertTrue(environmentsPage.isInfoBoxStatusSuccess());

    }

    @AfterClass
    public void tearDownEnvironments() {
        EnvironmentsPage environmentsPage = new EnvironmentsPage(driver);
        environmentsPage.goToDashboardPage();
    }

}
