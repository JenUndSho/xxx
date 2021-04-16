package ccsPageTests;

import baseConfings.BaseTest;
import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.impl.Screenshot;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class CreatingCaseStudyPageTests extends BaseTest {

    final String projectName = "Advertisement Platforms";

    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("On the top of CCSp should be displayed project's and account's name")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void onTheTopOfCCSpShouldBeDisplayedProjectsAndAccountsName(){
      //  String projectName = "Advertisement Platforms";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName(projectName);

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.checkIfCCSpContainsProjectName(projectName);
    }


    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Story("Bug")
    @Description("User is able to write text that exceed allowable size, than get a warning and discard changes")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userCanWriteTextThatExceedAllowableSizeGetWarningAndDiscardChanges(){
        try {
        //    String projectName = "Advertisement Platforms";
            List<String> summaryText = Files.readAllLines(Paths.get("src/main/resources/exceededSummaryText.txt"));
            List<String> challengesText = Files.readAllLines(Paths.get("src/main/resources/exceededChallengesText.txt"));

            mainPage.inputProjectField(projectName)
                    .checkIfPageContainsProjectName(projectName)
                    .clickOnAccountsProjectName(projectName);

            projectPage.clickOnCreateCaseStudyButton();

            ccsPage.goToProblemStatement()
                    .inputTextIntoSummaryFieldFromFile(summaryText)
                    .inputTextIntoChallengeFieldFromFile(challengesText)
                    .inputTextIntoKeyChallengesField("this text doesn't have impact on test result");

            ccsPage.checkErrorsSummaryChallengesVisible()
                    .clickDiscardBtn()
                    .checkErrorsSummaryChallengesHidden();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Files can't be read");
        }
    }



    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Story("Bug")
    @Description("Results page is displayed validly with deleted text from Key figures section")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void resultsPageDisplayedValidlyWhenDeletedTextFromKeyFiguresSection(){
        try {
         //   String projectName = "Advertisement Platforms";
            List<String> achievedResultsText = Files.readAllLines(Paths.get("src/main/resources/validAchievedResultsText.txt"));

            mainPage.inputProjectField(projectName)
                    .checkIfPageContainsProjectName(projectName)
                    .clickOnAccountsProjectName(projectName);

            projectPage.clickOnCreateCaseStudyButton();

            ccsPage.goToAchievedResults()
                    .inputTextIntoKetFiguresField()
                    .inputTextIntoAchievedResultsField(achievedResultsText)
                    .deleteTextFromKeyFiguresField();

            ccsPage.checkIfKeyFiguresSectionWithoutTextIsHiddenInPreviewPDF();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("File can't be read");
        }
    }


    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("User is able to download case study from Creating Case Study page")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")
    @Test
    public void userAbleToDownloadCaseStudyFromCaseStudyPage() throws FileNotFoundException {
     //   String projectName = "Advertisement Platforms";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName(projectName);

        projectPage.clickOnCaseStudyPopUpMenu(0)
                .clickInPopUpOn("Edit");

        ccsPage.downloadPDFCaseStudy();
    }

    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("User is able to go back to the project page from CCSp")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userAbleToGoBackToProjectPageFromCCSpByClickingOnProjectName(){
     //   String projectName = "Advertisement Platforms";
        String accountName = "Apple";
        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName(projectName);

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.gotToProjectPageByClickingOnProjectName();

        projectPage.checkIfPageContainsAccountName(accountName);
    }


    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("User is able to go back to the project page from CCSp")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userAbleToGoBackToProjectPageFromCCSpByClickingOnCancelBtn(){
    //    String projectName = "Advertisement Platforms";
        String accountName = "Apple";
        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName(projectName);

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.gotToProjectPageByClickingOnCancelBtn();

        projectPage.checkIfPageContainsAccountName(accountName);
    }


    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("User is unable to save case study without entering it's name")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userUnableToSaveCaseStudyWithoutEnteringName(){
     //   String projectName = "Advertisement Platforms";
        String accountName = "Apple";
        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName(projectName);

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.checkIfSaveBtnIsDisabled();
    }


    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("User is able to save empty case study ")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userAbleToSaveEmptyCaseStudy(){
        String csName = "New Test Case Study";
        csNameToBeDeleted = csName;
     //   String projectName = "Advertisement Platforms";
        mainPage.inputProjectField(projectName)
                    .checkIfPageContainsProjectName(projectName)
                    .clickOnAccountsProjectName(projectName);

            projectPage.clickOnCreateCaseStudyButton();

            Configuration.assertionMode = AssertionMode.SOFT;
            ccsPage.inputCaseStudyName(csName)
                    .saveCaseStudy()
                    .gotToProjectPageByClickingOnCancelBtn();

           deleteCaseStudyViaAPI(getIdOfCaseStudyByCaseStudyName(csName));
            Configuration.assertionMode = AssertionMode.STRICT;

    }


    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("User is able to enter text in fields in 'Problem statement'")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userAbleToEnterTextInFieldsInProblemStatement(){
     //   String projectName = "Advertisement Platforms";
        String text = "I can write text here";


        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName(projectName);

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.goToProblemStatement()
                .inputTextIntoChallengeField(text)
                .inputTextIntoKeyChallengesField(text)
                .inputTextIntoSummaryField(text);
    }


    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("User is able to insert an image to the case study")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userAbleToInsertImageToCaseStudy(){
     //   String projectName = "Advertisement Platforms";
        String text = "I can write text here";
        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName(projectName);

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.goToProblemStatement()
                .inputTextIntoChallengeField(text)
                .uploadImageIntoChallengeField();

    }


    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("User is able to divide text in columns")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userAbleToDivideTextInColumns(){
    //    String projectName = "Advertisement Platforms";
        String text = "I can write text here I can write text here I can write text here I can write text here";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName(projectName);

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.goToProblemStatement()
                .inputTextIntoChallengeField(text)
                .divideTextIntoTwoColumnsInProblemStatement()
                .checkIfTheChallengesTextIsDividedInto(2);

        ccsPage.divideTextIntoThreeColumnsInProblemStatement()
                .checkIfTheChallengesTextIsDividedInto(3);

    }


    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("Verify that the case study is saved when the text in the fields doesn't exceed the allowable size.")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void verifyThatCaseStudySavedWhenTextInFieldsDoesntExceedAllowableSize() {
    //    String projectName = "Advertisement Platforms";
        String text = "I can write text here";
        String name = "den_ben";
        csNameToBeDeleted = name;
            mainPage.inputProjectField(projectName)
                    .checkIfPageContainsProjectName(projectName)
                    .clickOnAccountsProjectName(projectName);

            projectPage.clickOnCreateCaseStudyButton();

            ccsPage.inputCaseStudyName(name)
                    .goToProblemStatement()
                    .inputTextIntoChallengeField(text)
                    .inputTextIntoKeyChallengesField(text)
                    .inputTextIntoSummaryField(text);
            ccsPage.goToProposedSolution()
                    .inputTextIntoProposedSolutionField(text);
            ccsPage.goToAchievedResults()
                    .inputTextIntoAchievedResultsField(text)
                    .inputTextIntoKetFiguresField();
        Configuration.assertionMode = AssertionMode.SOFT;
            ccsPage.saveCaseStudy()
                    .checkIfCSSavedSuccessfully();

       deleteCaseStudyViaAPI(getIdOfCaseStudyByCaseStudyName(name));
        Configuration.assertionMode = AssertionMode.STRICT;

    }


}
