package ccsPageTests;

import baseConfings.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CreatingCaseStudyPageTests extends BaseTest {

    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("On the top of CCSp should be diplayed project's and account's name")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void OnTheTopOfCCSpShouldBeDisplayedProjectsAndAccountsName() throws InterruptedException {
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
    public void UserCanWriteTextThatExceedAllowableSizeGetWarningAndDiscardChanges() throws InterruptedException, IOException {
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
    public void ResultsPageDisplayedValidlyWhenDeletedTextFromKeyFiguresSection() throws InterruptedException, IOException {
        String projectName = "Advertisement Platforms";
        List<String> achievedResultsText = Files.readAllLines(Paths.get("/Users/eshovkovyi/IdeaProjects/CSMA/src/main/resources/validAchievedResultsText.txt"));

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.goToAchievedResults()
                .inputTextIntoKetFiguresField()
                .inputTextIntoAchievedResultsField(achievedResultsText)
                .deleteTextFromKetFiguresField();

        ccsPage.checkIfKeyFiguresSectionWithoutTextIsHiddenInPreviewPDF();

    }



}
