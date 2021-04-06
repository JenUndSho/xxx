package ccsPageTests;

import baseConfings.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CreatingCaseStudyPageTests extends BaseTest {

    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("On the top of CCSp should be displayed project's and account's name")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void onTheTopOfCCSpShouldBeDisplayedProjectsAndAccountsName() throws InterruptedException {
        String projectName = "Advertisement Platforms";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.checkIfCCSpContainsProjectName(projectName);
    }

    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Story("Bug")
    @Description("User is able to write text that exceed allowable size, than get a warning and discard changes")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void userCanWriteTextThatExceedAllowableSizeGetWarningAndDiscardChanges() throws InterruptedException, IOException {
        String projectName = "Advertisement Platforms";
        List<String> summaryText = Files.readAllLines(Paths.get("/Users/eshovkovyi/IdeaProjects/CSMA/src/main/resources/exceededSummaryText.txt"));
        List<String> challengesText = Files.readAllLines(Paths.get("/Users/eshovkovyi/IdeaProjects/CSMA/src/main/resources/exceededChallengesText.txt"));

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.inputTextIntoSummaryFieldFromFile(summaryText)
               .inputTextIntoChallengeFieldFromFile(challengesText)
               .inputTextIntoKeyChallengesField("this text doesn't have impact on test result");

        ccsPage.checkErrorsSummaryChallengesVisible()
                .clickDiscardBtn()
                .checkErrorsSummaryChallengesHidden();
    }

    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Story("Bug")
    @Description("Results page is displayed validly with deleted text from Key figures section")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void resultsPageDisplayedValidlyWhenDeletedTextFromKeyFiguresSection() throws InterruptedException, IOException {
        String projectName = "Advertisement Platforms";
        List<String> achievedResultsText = Files.readAllLines(Paths.get("/Users/eshovkovyi/IdeaProjects/CSMA/src/main/resources/validAchievedResultsText.txt"));

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.goToAchievedResults()
                .inputTextIntoKetFiguresField()
                .inputTextIntoAchievedResultsField(achievedResultsText)
                .deleteTextFromKeyFiguresField();

        ccsPage.checkIfKeyFiguresSectionWithoutTextIsHiddenInPreviewPDF();
    }


    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("User is able to download case study from Creating Case Study page")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")

    @Test
    public void userAbleToDownloadCaseStudyFromCaseStudyPage() throws InterruptedException, FileNotFoundException {
        String projectName = "Advertisement Platforms";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnFirstCaseStudyPopUpMenu()
                .clickInPopUpOn("Edit");

        ccsPage.downloadPDFCaseStudy();
    }

    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("User is able to go back to the project page from CCSp")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void userAbleToGoBackToProjectPageFromCCSpByClickingOnProjectName() throws InterruptedException {
        String projectName = "Advertisement Platforms";
        String accountName = "Apple";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.gotToProjectPageByClickingOnProjectName();

        projectPage.checkIfPageContainsAccountName(accountName);
    }


    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("User is able to go back to the project page from CCSp")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void userAbleToGoBackToProjectPageFromCCSpByClickingOnCancelBtn() throws InterruptedException {
        String projectName = "Advertisement Platforms";
        String accountName = "Apple";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.gotToProjectPageByClickingOnCancelBtn();

        projectPage.checkIfPageContainsAccountName(accountName);
    }




}
