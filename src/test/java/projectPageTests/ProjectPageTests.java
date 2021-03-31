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

    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Story("Bug")
    @Description("User is able to create many areas each time pressing 'Save button' after editing")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    /**
     * Change new Areas in code! or manually delete on site just created.
     */

    @Test
    public void UserIsAbleToCreateManyAreasEachTimePressingSaveBtnAfterEditing() throws InterruptedException {
        String accountName = "Tradestone";
        String newArea1 = "e-area1";
        String newArea2 = "e-area2";

        mainPage.inputAccountField(accountName)
                .clickOnAccountsProjectName(accountName);

        projectPage.clickOnPenIconButton()
                   .enterNewArea(newArea1)
                   .saveChanges();
        projectPage.clickOnPenIconButton()
                   .enterNewArea(newArea2)
                   .saveChanges();

        projectPage.checkIfBoxAreaContainsArea(newArea1)
                   .checkIfBoxAreaContainsArea(newArea2);


    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Story("Bug")
    @Description("User is able to create many technologies each time pressing 'Save button' after editing")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    /**
     * Change new Technologies in code! or manually delete on site just created.
     */

    @Test
    public void UserIsAbleToCreateManyTechnologiesEachTimePressingSaveBtnAfterEditing(){
        String accountName = "Tradestone";
        String newTechnology1 = "e-technology1";
        String newTechnology2 = "e-technology2";

        mainPage.inputAccountField(accountName)
                .clickOnAccountsProjectName(accountName);

        projectPage.clickOnPenIconButton()
                .enterNewTechnology(newTechnology1)
                .saveChanges();
        projectPage.clickOnPenIconButton()
                .enterNewTechnology(newTechnology2)
                .saveChanges();

        projectPage.checkIfBoxTechnologyContainsTechnology(newTechnology1)
                   .checkIfBoxTechnologyContainsTechnology(newTechnology2);


    }


}
