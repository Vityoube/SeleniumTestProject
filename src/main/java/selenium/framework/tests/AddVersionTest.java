package selenium.framework.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import selenium.framework.Pages.AddVersionPage;
import selenium.framework.Pages.DashboardPage;
import selenium.framework.Pages.VersionsPage;

import java.util.Date;

public class AddVersionTest extends AbstractTest{

    @Test
    public void addVersionTestSuccess(){
        // Przekierowanie do strony wersji
        DashboardPage dashboardPage=new DashboardPage(driver);
        VersionsPage versionsPage = dashboardPage.goToVersionsPage();
        //Przekierowanie do strony dodania wersji
        AddVersionPage addVersionPage=versionsPage.goToAddVersionPage();
        // Wypełnienie i submitowanie formularza
        versionsPage=addVersionPage.fillForm("wersja_wersja_"+new Date().getTime(),"Ble-ble-ble").submitForm();
        // sprawdzenie Message Boxu o pomyślnym dodaniu wersji
        Assert.assertTrue(versionsPage.isInfoBoxDisplayed());
        Assert.assertTrue(versionsPage.isInfoBoxStatusSuccess());
    }

    @AfterClass
    public void tearDownVersions() {
        VersionsPage versionsPage = new VersionsPage(driver);
        versionsPage.goToDashboardPage();
    }
}
