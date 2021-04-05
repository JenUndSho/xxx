package projectPageTests;

import baseConfings.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;


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
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                   .enterNewArea(area)
                   .saveChanges()
                   .checkIfBoxAreaContainsArea(area);

        deleteArea(area);
    }

    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Story("Bug")
    @Description("User is able to create many areas each time pressing 'Save button' after editing")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void UserIsAbleToCreateManyAreasEachTimePressingSaveBtnAfterEditing() throws InterruptedException {
        String accountName = "Tradestone";
        String newArea1 = "e-area01";
        String newArea2 = "e-area02";

        mainPage.inputAccountField(accountName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                   .enterNewArea(newArea1)
                   .saveChanges();

        projectPage.clickOnPenIconButton()
                   .enterNewArea(newArea2)
                   .saveChanges();

        projectPage.checkIfBoxAreaContainsArea(newArea1)
                   .checkIfBoxAreaContainsArea(newArea2);

        deleteArea(newArea1);
        deleteArea(newArea2);
    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Story("Bug")
    @Description("User is able to create many technologies each time pressing 'Save button' after editing")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void UserIsAbleToCreateManyTechnologiesEachTimePressingSaveBtnAfterEditing() throws InterruptedException {
        String accountName = "Tradestone";
        String newTechnology1 = "e-technology01";
        String newTechnology2 = "e-technology02";

        mainPage.inputAccountField(accountName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                .enterNewTechnology(newTechnology1)
                .saveChanges();
        projectPage.clickOnPenIconButton()
                .enterNewTechnology(newTechnology2)
                .saveChanges();

        projectPage.checkIfBoxTechnologyContainsTechnology(newTechnology1)
                   .checkIfBoxTechnologyContainsTechnology(newTechnology2);

        deleteTechnology(newTechnology1);
        deleteTechnology(newTechnology2);
    }

    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to create new technologies")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void UserIsAbleToCreateNewTechnologies() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";
        String technology = "TestTechnology!";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                   .enterNewTechnology(technology)
                   .saveChanges()
                   .checkIfBoxTechnologyContainsTechnology(technology);

        deleteTechnology(technology);
    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User can't create new technologies without pressing Enter")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void UserIsNotAbleToCreateNewTechnologiesWithoutPressingEnter() throws InterruptedException{
        String accountName = "Tradestone";
        String projectName = "PreSale";
        String technology = "TestTechnology_v1!";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                   .enterNewTechnologyAndDontPressEnter(technology)
                   .checkIfNewTechnologyIsNotInTechnologiesContainer(technology);

    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User can't create new area without pressing Enter")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void UserIsNotAbleToCreateNewAreasWithoutPressingEnter() throws InterruptedException{
        String accountName = "Tradestone";
        String projectName = "PreSale";
        String area = "TestArea_v1!";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                .enterNewAreaAndDontPressEnter(area)
                .checkIfNewAreaIsNotInAreasContainer(area);

    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to create many new areas")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void UserIsAbleToCreateManyNewAreas() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";
        String area1 = "TestArea1";
        String area2 = "TestArea2";
        String area3 = "TestArea3";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                .enterNewArea(area1)
                .enterNewArea(area2)
                .enterNewArea(area3)
                .saveChanges()
                .checkIfBoxAreaContainsArea(area1)
                .checkIfBoxAreaContainsArea(area2)
                .checkIfBoxAreaContainsArea(area3);

        deleteArea(area1);
        deleteArea(area2);
        deleteArea(area3);
    }

    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to create many new technologies")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void UserIsAbleToCreateManyNewTechnologies() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";
        String technology1 = "TestTechnology1";
        String technology2 = "TestTechnology2";
        String technology3 = "TestTechnology3";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                .enterNewTechnology(technology1)
                .enterNewTechnology(technology2)
                .enterNewTechnology(technology3)
                .saveChanges()
                .checkIfBoxTechnologyContainsTechnology(technology1)
                .checkIfBoxTechnologyContainsTechnology(technology2)
                .checkIfBoxTechnologyContainsTechnology(technology3);

        deleteTechnology(technology1);
        deleteTechnology(technology2);
        deleteTechnology(technology3);
    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to add areas from drop-down list")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void UserIsAbleToAddAreasFromDropDownList() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";
        String area = "Protection";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                .enterNewArea(area)
                .saveChanges()
                .checkIfBoxAreaContainsArea(area);

        deleteArea(area);
    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to add technologies from drop-down list")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void UserIsAbleToAddTechnologiesFromDropDownList() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";
        String technology = "Angular";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                .enterNewTechnology(technology)
                .saveChanges()
                .checkIfBoxTechnologyContainsTechnology(technology);

        deleteTechnology(technology);
    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User should get a hint about areas when hover mouse over the '?' icon near 'Areas' caption")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void UserIsAbleToGetHintAboutAreas() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.hoverOnQuestionMarkNearAreaLabel()
                .checkIfAreaHintAppears();
    }
}
