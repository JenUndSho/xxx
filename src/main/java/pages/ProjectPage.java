package pages;

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
    private SelenideElement createCaseStudyButton = $(byText("Create new case study"));
    private SelenideElement backToProjects = $(byText("back to projects"));
    private SelenideElement saveBtn = $(By.xpath("//button[@type='submit']"));
    private SelenideElement boxWithAreas = $$(By.xpath("//div[@class='styles_list__-2IR5']")).get(0);
    private SelenideElement boxWithTechnologies = $$(By.xpath("//div[@class='styles_list__-2IR5']")).get(1);

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
}
