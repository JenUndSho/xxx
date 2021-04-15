package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class CCSPage {
    private SelenideElement goProjectPageButton = $(By.xpath("//div[@class='styles_backButton__1V0qz']"));
    private SelenideElement summarySectionFieldWithNoText = $$(By.xpath("//div[@class='ql-editor ql-blank']")).get(0);
    private SelenideElement challengeSectionField = $(By.xpath("//div[@id='problem']//div[@class='ql-editor ql-blank']"));
    private SelenideElement challengeSectionFieldWithText = $(By.xpath("//div[@id='problem']//div[@class='ql-editor']"));
    private ElementsCollection listOfErrors = $$(By.xpath("//p[@class='MuiTypography-root MuiTypography-caption MuiTypography-colorError']"));
    private SelenideElement discardBtn = $(byText("Discard"));
    private SelenideElement keyChallengesSectionField = $(By.xpath("//div[@id='challenges']//div[@class='ql-editor ql-blank']"));
    private SelenideElement achievedResultsTab = $(byText("Achieved result"));
    private SelenideElement problemStatementTab = $(byText("Problem statement"));
    private SelenideElement proposedSolutionTab = $(byText("Proposed solution"));
    private SelenideElement proposedSolutionField = $(By.xpath("//div[@id='solution']//div[@class='ql-editor ql-blank']"));
    private SelenideElement achievedResultsSectionWithNoText = $(By.xpath("//div[@id='result']//div[@class='ql-editor ql-blank']"));
    private SelenideElement achievedResultsSectionWithText = $(By.xpath("//div[@id='result']//div[@class='ql-editor']"));
    private SelenideElement keyFiguresSectionWithNoText = $(By.xpath("//div[@id='keyFigures']//div[@class='ql-editor ql-blank']"));
    private SelenideElement keyFiguresSectionWithText = $(By.xpath("//div[@id='keyFigures']//div[@class='ql-editor']"));
    private SelenideElement keyFiguresSectionInPreviewPDF = $(By.xpath("//div[@class='styles_keyFigures__description__35X1K']"));
    private SelenideElement downloadPDFCaseStudyBtn = $(By.xpath("//a[@title='Download case study']"));
    private SelenideElement cancelBtn = $(byText("Cancel"));
    private SelenideElement saveBtn = $(byText("Save"));
    private SelenideElement inputNameField = $(By.xpath("//input[@name='name']"));
    private SelenideElement theChallengeText = $(By.xpath("//div[@id='problem']//p"));
    private SelenideElement divideBtnTwoColumnsInProblemStatement = $$(By.xpath("//button[@value='2']")).get(1);
    private SelenideElement divideBtnThreeColumnsInProblemStatement = $$(By.xpath("//button[@value='3']")).get(1);
    private SelenideElement successfullySaveCSMsg = $(byText("Case study saved successfully"));

    @Step("Check if CCSp contains project name {0}")
    public CCSPage checkIfCCSpContainsProjectName(String projectName){
        goProjectPageButton.shouldHave(text(projectName));
        return this;
    }

    @Step("Write some text in summary field")
    public CCSPage inputTextIntoSummaryField(String text){
        summarySectionFieldWithNoText.click();
        summarySectionFieldWithNoText.setValue(text);
        return this;
    }

    @Step("Write some text in the challenge field")
    public CCSPage inputTextIntoChallengeField(String text){
        challengeSectionField.click();
        challengeSectionField.setValue(text);
        return this;
    }


    @Step("Write some text in the challenge field")
    public CCSPage inputTextIntoKeyChallengesField(String text){
        keyChallengesSectionField.click();
        keyChallengesSectionField.setValue(text);
        return this;
    }


    @Step("Write some text in the challenge field from file")
    public CCSPage inputTextIntoChallengeFieldFromFile(List<String> text){
        challengeSectionField.click();
        StringBuilder challengeFieldText = new StringBuilder();
        for(String str: text)
            challengeFieldText.append(str);
        challengeSectionField.setValue(challengeFieldText.toString());
        return this;
    }

    @Step("Write some text in summary field from file")
    public CCSPage inputTextIntoSummaryFieldFromFile(List<String> text){
        summarySectionFieldWithNoText.click();
        StringBuilder summaryFieldText = new StringBuilder();
        for(String str: text)
            summaryFieldText.append(str);
        summarySectionFieldWithNoText.setValue(summaryFieldText.toString());
        return this;
    }


    @Step("Check if errors in summary and the challenges section are visible")
    public CCSPage checkErrorsSummaryChallengesVisible(){
        listOfErrors.shouldHave(CollectionCondition.texts("Summary - Height", "The challenge - Height"));
        return this;
    }

    @Step("Check if there are no errors in summary and the challenges section ")
    public CCSPage checkErrorsSummaryChallengesHidden(){
        listOfErrors.shouldBe(CollectionCondition.empty);
        return this;
    }

    @Step("Click Discard button")
    public CCSPage clickDiscardBtn(){
        discardBtn.click();
        return this;
    }

    @Step("Go to achieved results")
    public CCSPage goToAchievedResults(){
        achievedResultsTab.scrollIntoView(true);
        achievedResultsTab.click();
        return this;
    }

    @Step("Go to problem statement")
    public CCSPage goToProblemStatement(){
        problemStatementTab.scrollIntoView(true);
        problemStatementTab.click();
        return this;
    }

    @Step("Go to proposed solution")
    public CCSPage goToProposedSolution(){
        proposedSolutionTab.scrollIntoView(true);
        proposedSolutionTab.click();
        return this;
    }

    @Step("Write some text into key figures filed")
    public CCSPage inputTextIntoKetFiguresField(){
        keyFiguresSectionWithNoText.setValue("Tom and Jerry are friends");
        return this;
    }

    @Step("Write some text into proposed solution filed")
    public CCSPage inputTextIntoProposedSolutionField(String text){
        proposedSolutionField.click();
        proposedSolutionField.setValue(text);
        return this;
    }

    @Step("Write some text into achieved results filed")
    public CCSPage inputTextIntoAchievedResultsField(List<String> text){
        StringBuilder achievedResultsFieldText = new StringBuilder();
        for(String str: text)
            achievedResultsFieldText.append(str);
        achievedResultsSectionWithNoText.setValue(achievedResultsFieldText.toString());
        return this;
    }

    @Step("Write some text into achieved results filed")
    public CCSPage inputTextIntoAchievedResultsField(String text){
        achievedResultsSectionWithNoText.click();
        achievedResultsSectionWithNoText.setValue(text);
        return this;
    }

    @Step("Delete text from key figures filed")
    public CCSPage deleteTextFromKeyFiguresField(){
        keyFiguresSectionWithText.setValue("");
        return this;
    }

    @Step("Check if key figures section with no text is not displayed in preview PDF")
    public CCSPage checkIfKeyFiguresSectionWithoutTextIsHiddenInPreviewPDF(){
        keyFiguresSectionInPreviewPDF.shouldNotBe(visible);
        return this;
    }

    @Step("Download PDF case study from Creating Case Study Page")
    public CCSPage downloadPDFCaseStudy() {
        try {
            File reader =  downloadPDFCaseStudyBtn.download();
            return this;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Assert.fail("File cannot be downloaded");
        }
        return this;
    }

    @Step("Go to Project Page")
    public CCSPage gotToProjectPageByClickingOnProjectName(){
        goProjectPageButton.click();
        return this;
    }

    @Step("Go to Project Page")
    public CCSPage gotToProjectPageByClickingOnCancelBtn(){
        cancelBtn.click();
        return this;
    }

    @Step("Check if Save button is disabled")
    public CCSPage checkIfSaveBtnIsDisabled(){
        saveBtn.shouldBe(enabled);
        return this;
    }

    @Step("Input name ' {0} '")
    public CCSPage inputCaseStudyName(String name){
        inputNameField.sendKeys(Keys.COMMAND, "A");
        inputNameField.sendKeys(Keys.DELETE);
        inputNameField.setValue(name);
        return this;
    }

    @Step("Save case study")
    public CCSPage saveCaseStudy(){
        saveBtn.scrollIntoView(true);
        saveBtn.click();
        return this;
    }

    @Step("Upload image from laptop into challenge field")
    public CCSPage uploadImageIntoChallengeField(){
        File img = new File("src/main/resources/screenshot.png");
        $$(By.xpath("//input[@type='text']")).get(1).uploadFile(img);
       // challengeSectionField.uploadFile(img);
        return this;
    }

    @Step("Divide text into 2 columns")
    public CCSPage divideTextIntoTwoColumnsInProblemStatement(){
        divideBtnTwoColumnsInProblemStatement.click();
        return this;
    }

    @Step("Divide text into 3 columns")
    public CCSPage divideTextIntoThreeColumnsInProblemStatement(){
        divideBtnThreeColumnsInProblemStatement.click();
        return this;
    }

    @Step("Check if the challenges text is divided into {0} columns")
    public CCSPage checkIfTheChallengesTextIsDividedInto(int n){
        String expectedAttribute = "column-count: " + n + ";";
        theChallengeText.shouldHave(attribute("style", expectedAttribute));
        return this;
    }

    @Step("Check if case study saved successfully message appears")
    public CCSPage checkIfCSSavedSuccessfully(){
        successfullySaveCSMsg.shouldBe(visible);
        return this;
    }



}
