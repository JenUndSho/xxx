package projectPageTests;

import baseConfings.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GridLoginPage;
import pages.MainPage;
import pages.ProjectPage;

import static com.codeborne.selenide.Selenide.*;


public class ProjectPageTests extends BaseTest {


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to create new areas")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void UserIsAbleToCreateNewAreas() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";
        String area = "fool_1";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName(projectName);

        projectPage.clickOnPenIconButton()
                   .enterNewArea(area)
                   .checkIfNewAreaIsInAreasContainer(area);


    }


}
