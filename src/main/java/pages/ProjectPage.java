package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;

public class ProjectPage {
    private SelenideElement penIcon = $(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root editable-project-info_editButton__2YZij']"));
    private SelenideElement inputAreaField = $$(By.xpath("//input[@placeholder='Select or enter']")).get(0);
    private SelenideElement inputTechnologyField = $$(By.xpath("//input[@placeholder='Select or enter']")).get(1);
    private SelenideElement areasContainer = $$(By.xpath("//div[@class='MuiFormControl-root MuiTextField-root MuiFormControl-fullWidth']")).get(0);
    private SelenideElement technologiesContainer = $$(By.xpath("//div[@class='MuiFormControl-root MuiTextField-root MuiFormControl-fullWidth']")).get(1);
    private SelenideElement createCaseStudyButton = $(byText("Create new case study"));
    private SelenideElement backToProjects = $(byText("back to projects"));
    private SelenideElement saveBtn = $(By.xpath("//button[@type='submit']"));
    private SelenideElement discardBtn = $(byText("Discard"));
    private SelenideElement boxWithAreas = $$(By.xpath("//div[@class='styles_list__-2IR5']")).get(0);
    private SelenideElement boxWithTechnologies = $$(By.xpath("//div[@class='styles_list__-2IR5']")).get(1);
    private SelenideElement namesAccountAndProject = $(By.xpath("//div[@class='styles_contentItem__397Q7']//div[@class='styles_content__W0Qho']"));
    private ElementsCollection labels = $$(By.xpath("//p[@class='MuiTypography-root styles_label__1Fc5e MuiTypography-body1']"));
    private SelenideElement areaQuestionMark = labels.get(0).sibling(0);
    private SelenideElement technologyQuestionMark = labels.get(1).sibling(0);
    private SelenideElement descriptionInputField = $(By.xpath("//textarea[@placeholder='Enter a brief description of the project']"));
    private SelenideElement boxDescription = $(byText("Description")).sibling(0);
    private SelenideElement siteIcon = $(byText("Projects"));
    private SelenideElement projectInfo = $(By.xpath("//div[@class='styles_noCaseStudiesWrapper__iFONg']"));
    private SelenideElement popUpFirstCaseStudyMenuBtn = $$(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall']")).get(0);
    private ElementsCollection allLiElements = $$(By.xpath("//li"));
    private SelenideElement previewCaseStudy = $(By.xpath("//div[@class='MuiPaper-root MuiDrawer-paper MuiDrawer-paperAnchorRight MuiPaper-elevation16']"));

    public SelenideElement getBoxWithTechnologies() {
        return boxWithTechnologies;
    }

    @Step("Click on pen icon button")
    public ProjectPage clickOnPenIconButton(){
        penIcon.click();
        return this;
    }

    @Step("Click on site-icon")
    public ProjectPage clickOnSiteIcon(){
        siteIcon.click();
        return this;
    }

    @Step("Enter new area ' {0} '")
    public ProjectPage enterNewArea(String area){
        inputAreaField.setValue(area).pressEnter().pressEscape();
        return this;
    }

    @Step("Enter new technology ' {0} '")
    public ProjectPage enterNewTechnology(String technology){
        inputTechnologyField.setValue(technology).pressEnter().pressEscape();
        return this;
    }

    @Step("Enter new area ' {0} ', but don't press Enter")
    public ProjectPage enterNewAreaAndDontPressEnter(String area){
        inputAreaField.setValue(area).pressEscape();
        return this;
    }

    @Step("Enter new technology ' {0} ', but don't press Enter")
    public ProjectPage enterNewTechnologyAndDontPressEnter(String technology){
        inputTechnologyField.setValue(technology).pressEscape();
        return this;
    }


    @Step("Check if new area ' {0} ' is in Areas Container")
    public ProjectPage checkIfNewAreaIsInAreasContainer(String area){
        areasContainer.shouldHave(text(area));
        return this;
    }

    @Step("Click on Create Case Study button")
    public ProjectPage clickOnCreateCaseStudyButton(){
        createCaseStudyButton.click();
        return this;
    }

    @Step("Back to projects page")
    public ProjectPage clickOnBackToProjectsBtn(){
        backToProjects.click();
        return this;
    }

    @Step("Save changes")
    public ProjectPage saveChanges(){
        saveBtn.click();
        return this;
    }

    @Step("Discard changes")
    public ProjectPage discardChanges(){
        discardBtn.click();
        return this;
    }

    @Step("Check if box with areas contains new area {0}")
    public ProjectPage checkIfBoxAreaContainsArea(String area){
        boxWithAreas.shouldHave(text(area));
        return this;
    }

    @Step("Check if box with technologies contains new technology {0}")
    public ProjectPage checkIfBoxTechnologyContainsTechnology(String technology){
        boxWithTechnologies.shouldHave(text(technology));
        return this;
    }

    @Step("Check if box with areas does not contain new area {0}")
    public ProjectPage checkIfBoxAreaDoesNotContainArea(String area){
        boxWithAreas.shouldNotHave(text(area));
        return this;
    }

    @Step("Check if box with technologies does not contain new technology {0}")
    public ProjectPage checkIfBoxTechnologyDoesNotContainTechnology(String technology){
        boxWithTechnologies.shouldNotHave(text(technology));
        return this;
    }

    @Step("Check if page contains account name {0}")
    public ProjectPage checkIfPageContainsAccountName(String accountName) throws InterruptedException {
        namesAccountAndProject.shouldHave(text(accountName));
        return this;
    }

    @Step("Delete area from areas container")
    public ProjectPage deleteAreaFromContainer(String area){
        areasContainer.click();
        checkIfNewAreaIsInAreasContainer(area);
        SelenideElement newAreaFromContainer = $(byText(area)).parent();
        SelenideElement deleteBtnForArea = newAreaFromContainer.find(byTagName("svg"));
        deleteBtnForArea.click();
        saveChanges();
        return this;
    }

    @Step("Delete area from areas container")
    public ProjectPage deleteTechnologyFromContainer(String technology) {
        technologiesContainer.click();
        SelenideElement newTechnologyFromContainer = $(byText(technology)).parent();
        SelenideElement deleteBtnForTechnology = newTechnologyFromContainer.find(byTagName("svg"));
        deleteBtnForTechnology.click();
        areasContainer.click();
        saveChanges();
        return this;
    }

    @Step("Check if new area ' {0} ' is not in Areas Container")
    public ProjectPage checkIfNewAreaIsNotInAreasContainer(String area){
        areasContainer.shouldNotHave(text(area));
        return this;
    }

    @Step("Check if new technology ' {0} ' is not in Technologies Container")
    public ProjectPage checkIfNewTechnologyIsNotInTechnologiesContainer(String technology){
        technologiesContainer.shouldNotHave(text(technology));
        return this;
    }

    @Step("Hover mouse on '?' near Areas label")
    public ProjectPage hoverOnQuestionMarkNearAreaLabel(){
        areaQuestionMark.shouldNotHave(attribute("aria-describedBy"));
        areaQuestionMark.hover();
        return this;
    }

    @Step("Check if areas hint appears")
    public ProjectPage checkIfAreaHintAppears(){
        areaQuestionMark.shouldHave(attribute("aria-describedBy"));
        return this;
    }

    @Step("Hover mouse on '?' near technologies label")
    public ProjectPage hoverOnQuestionMarkNearTechnologyLabel(){
        technologyQuestionMark.shouldNotHave(attribute("aria-describedBy"));
        technologyQuestionMark.hover();
        return this;
    }

    @Step("Check if technologies hint appears")
    public ProjectPage checkIfTechnologyHintAppears(){
        technologyQuestionMark.shouldHave(attribute("aria-describedBy"));
        return this;
    }

    @Step("Write description of the project: {0}")
    public ProjectPage inputDescription(String text){
        descriptionInputField.sendKeys(Keys.COMMAND, "A");
        descriptionInputField.sendKeys(Keys.BACK_SPACE);
        descriptionInputField.setValue(text);
        return this;
    }

    @Step("Check if description text exact as : {0}")
    public ProjectPage checkIfDescriptionExactAs(String text){
        boxDescription.shouldHave(exactText(text));
        return this;
    }

    @Step("Check if no case study message is on page")
    public ProjectPage checkIfNoCaseStudyMessageExist(){
        projectInfo.shouldHave(text("There are no case studies!"));
        return this;
    }

    @Step("Click on first case study's pop-up menu")
    public ProjectPage clickOnFirstCaseStudyPopUpMenu(){
        popUpFirstCaseStudyMenuBtn.click();
        return this;
    }

    @Step("Click on '{0}'")
    public ProjectPage clickInPopUpOn(String aim){
       allLiElements.findBy(text(aim)).click();
       return this;
    }

    @Step("Check if preview case study is opened")
    public ProjectPage checkIfPreviewCaseStudyIsOpened(){
        previewCaseStudy.shouldBe(visible);
        return this;
    }

    @Step("Download PDF case study from Project Page")
    public ProjectPage downloadPDFCaseStudy() throws FileNotFoundException {
        File reader =  allLiElements.findBy(text("Download")).$(byTagName("a")).download();
        return this;
    }
}
