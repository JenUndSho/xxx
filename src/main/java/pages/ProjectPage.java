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

public class ProjectPage {
    private SelenideElement penIcon = $(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root editable-project-info_editButton__2YZij']"));
    private SelenideElement inputAreaField = $$(By.xpath("//input[@placeholder='Select or enter']")).get(0);
    private SelenideElement inputTechnologyField = $$(By.xpath("//input[@placeholder='Select or enter']")).get(1);
    private SelenideElement areasContainer = $$(By.xpath("//div[@class='MuiFormControl-root MuiTextField-root MuiFormControl-fullWidth']")).get(0);
    private SelenideElement technologiesContainer = $$(By.xpath("//div[@class='MuiFormControl-root MuiTextField-root MuiFormControl-fullWidth']")).get(1);
    private SelenideElement createCaseStudyButton = $(byText("Create new case study"));
    private SelenideElement backToProjects = $(byText("back to projects"));
    private SelenideElement saveBtn = $(By.xpath("//button[@type='submit']"));
    private SelenideElement boxWithAreas = $$(By.xpath("//div[@class='styles_list__-2IR5']")).get(0);
    private SelenideElement boxWithTechnologies = $$(By.xpath("//div[@class='styles_list__-2IR5']")).get(1);
    private SelenideElement namesAccountAndProject = $(By.xpath("//div[@class='styles_contentItem__397Q7']//div[@class='styles_content__W0Qho']"));
    private ElementsCollection labels = $$(By.xpath("//p[@class='MuiTypography-root styles_label__1Fc5e MuiTypography-body1']"));
    private SelenideElement areaQuestionMark = labels.get(0).sibling(0);

    public SelenideElement getBoxWithTechnologies() {
        return boxWithTechnologies;
    }

    @Step("Click on pen icon button")
    public ProjectPage clickOnPenIconButton(){
        penIcon.click();
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
        areaQuestionMark.hover();
        return this;
    }

    @Step("Check if areas hint appears")
    public ProjectPage checkIfAreaHintAppears(){
        areaQuestionMark.shouldHave(attribute("aria-describedBy"));
        return this;
    }
}
