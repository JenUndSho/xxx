package projectPageTests;

import baseConfings.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;


public class ProjectPageTests extends BaseTest {

/*
    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to create new areas")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userIsAbleToCreateNewAreas() throws InterruptedException {
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
    public void userIsAbleToCreateManyAreasEachTimePressingSaveBtnAfterEditing() throws InterruptedException {
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


 */
    /*

    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Story("Bug")
    @Description("User is able to create many technologies each time pressing 'Save button' after editing")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userIsAbleToCreateManyTechnologiesEachTimePressingSaveBtnAfterEditing() throws InterruptedException {
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
    public void userIsAbleToCreateNewTechnologies() throws InterruptedException {
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
    public void userIsNotAbleToCreateNewTechnologiesWithoutPressingEnter() throws InterruptedException{
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
    public void userIsNotAbleToCreateNewAreasWithoutPressingEnter() throws InterruptedException{
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
    public void userIsAbleToCreateManyNewAreas() throws InterruptedException {
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
    public void userIsAbleToCreateManyNewTechnologies() throws InterruptedException {
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
    public void userIsAbleToAddAreasFromDropDownList() throws InterruptedException {
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


     */

    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to add technologies from drop-down list")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userIsAbleToAddTechnologiesFromDropDownList() throws InterruptedException {
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
    public void userIsAbleToGetHintAboutAreas() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.hoverOnQuestionMarkNearAreaLabel()
                .checkIfAreaHintAppears();
    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User should get a hint about technologies when hover " +
            "mouse over the '?' icon near 'Technologies' caption")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userIsAbleToGetHintAboutTechnologies() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.hoverOnQuestionMarkNearTechnologyLabel()
                .checkIfTechnologyHintAppears();
    }

    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User should get a hint about inputting area when hover mouse " +
            "over the '?' icon near 'Areas' caption after clicking on 'Pen'-icon")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userIsAbleToGetHintAboutAreasInEditingMode() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                .hoverOnQuestionMarkNearAreaLabel()
                .checkIfAreaHintAppears();
    }

    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User should get a hint about technologies when hover mouse " +
            "over the '?' icon near 'Technologies' caption caption after clicking on 'Pen'-icon")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userIsAbleToGetHintAboutTechnologiesInEditingMode() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                .hoverOnQuestionMarkNearTechnologyLabel()
                .checkIfTechnologyHintAppears();
    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to write down description to the project")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userIsAbleToWriteDescriptionToProject() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";
        String description = "This message doesn't have any conscience, just message, just letters!";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
                .inputDescription(description)
                .saveChanges()
                .checkIfDescriptionExactAs(description);

    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to cancel all changes by clicking the 'Discard' button")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userAbleToCancelAllChangesByClickingDiscardBtn() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";
     //   String area1 = "PMO";
     //   String area2 = "Mobile";
        String technology1 = "AWS";
        String technology2 = "React";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnPenIconButton()
              //  .enterNewArea(area1)
            //    .enterNewArea(area2)
                .enterNewTechnology(technology1)
                .enterNewTechnology(technology2)
                .discardChanges();

        projectPage
               // .checkIfBoxAreaDoesNotContainArea(area1)
            //    .checkIfBoxAreaDoesNotContainArea(area2)
                .checkIfBoxTechnologyDoesNotContainTechnology(technology1)
                .checkIfBoxTechnologyDoesNotContainTechnology(technology2);

    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to go to the main page by clicking onto the site-icon")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userIsAbleToGoToMainPageByClickingOnSiteIcon() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";


        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnSiteIcon();
        mainPage.checkIfItIsMainPage();
    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("If there are no case studies relating to the project, relevant text should be displayed")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void noCaseStudyTextShouldBeDisplayed() throws InterruptedException {
        String accountName = "SVB";
        String projectName = "Clojure";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.checkIfNoCaseStudyMessageExist();
    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to create new case study")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userAbleToCreateNewCaseStudy() throws InterruptedException {
        String accountName = "Tradestone";
        String projectName = "PreSale";

        mainPage.inputAccountField(accountName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnCreateCaseStudyButton();
        ccsPage.checkIfCCSpContainsProjectName(projectName);
    }

    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to edit case study")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userAbleToEditCaseStudy() throws InterruptedException {
        String projectName = "Advertisement Platforms";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnCaseStudyPopUpMenu(0)
                .clickInPopUpOn("Edit");
        ccsPage.checkIfCCSpContainsProjectName(projectName);

    }


    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to open preview case study")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userAbleToOpenPreviewCaseStudy() throws InterruptedException {
        String projectName = "Advertisement Platforms";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnCaseStudyPopUpMenu(0)
                .clickInPopUpOn("Preview")
                .checkIfPreviewCaseStudyIsOpened();
    }

    @Epic("Test CSMA site")
    @Feature("Project Page")
    @Description("User is able to download case study from Project page")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userAbleToDownloadCaseStudyFromProjectPage() throws InterruptedException, FileNotFoundException {
        String projectName = "Advertisement Platforms";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnCaseStudyPopUpMenu(0)
                .downloadPDFCaseStudy();

    }


}
