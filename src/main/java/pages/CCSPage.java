package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public class CCSPage {
    private SelenideElement goProjectPageButton = $(By.xpath("//div[@class='styles_backButton__1V0qz']"));
    private SelenideElement summarySectionFieldWithNoText = $$(By.xpath("//div[@class='ql-editor ql-blank']")).get(0);
    private SelenideElement challengeSectionField = $(By.xpath("//div[@id='problem']//div[@class='ql-editor ql-blank']"));
    private ElementsCollection listOfErrors = $$(By.xpath("//p[@class='MuiTypography-root MuiTypography-caption MuiTypography-colorError']"));
    private SelenideElement discardBtn = $(byText("Discard"));
    private SelenideElement keyChallengesSectionField = $(By.xpath("//div[@id='challenges']//div[@class='ql-editor ql-blank']"));
    private SelenideElement achievedResultsTab = $(byText("Achieved result"));
    private SelenideElement achievedResultsSectionWithNoText = $(By.xpath("//div[@id='result']//div[@class='ql-editor ql-blank']"));
    private SelenideElement achievedResultsSectionWithText = $(By.xpath("//div[@id='result']//div[@class='ql-editor']"));
    private SelenideElement keyFiguresSectionWithNoText = $(By.xpath("//div[@id='keyFigures']//div[@class='ql-editor ql-blank']"));
    private SelenideElement keyFiguresSectionWithText = $(By.xpath("//div[@id='keyFigures']//div[@class='ql-editor']"));
    private SelenideElement keyFiguresSectionInPreviewPDF = $(By.xpath("//div[@class='styles_keyFigures__description__35X1K']"));

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

    @Step("Write some text into key figures filed")
    public CCSPage inputTextIntoKetFiguresField(){
        keyFiguresSectionWithNoText.setValue("Tom and Jerry are friends");
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

    @Step("Delete text from key figures filed")
    public CCSPage deleteTextFromKetFiguresField(){
        keyFiguresSectionWithText.setValue("");
        return this;
    }

    @Step("Check if key figures section with no text is not displayed in preview PDF")
    public CCSPage checkIfKeyFiguresSectionWithoutTextIsHiddenInPreviewPDF(){
        keyFiguresSectionInPreviewPDF.shouldNotBe(visible);
        return this;
    }
}
