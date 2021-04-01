package pages;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;


public class MainPage {
   private SelenideElement inputProjectField = $(By.xpath("//div[@class='styles_projectsSearchItem__3p1ng'][2]//input[@type='text']"));
   private SelenideElement sectionWithProjects = $(".styles_contentWrapper__1tkbn");
   private SelenideElement inputAccountField = $(By.xpath("//div[@class='styles_projectsSearchItem__3p1ng'][1]//input[@type='text']"));
   private SelenideElement firstProjectFromDashboard = $$(By.xpath("//a/h6")).get(0);
   private ElementsCollection boxesWithAccountNameAndProjectName = $$(By.xpath("//div[@class='styles_container__mut_C styles_accountProjectBlock__2lfW_']"));
   private SelenideElement nextPageBtn = $(By.xpath("//button[@aria-label='Go to next page']"));
   private SelenideElement withCaseStudyOnly = $(byText("With case studies only"));
   private ElementsCollection caseStudiesCollection = $$(By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body styles_caseStudiesColumn__J39-l']"));
   private SelenideElement onlyActiveProjects = $(byText("Only active projects"));
   private ElementsCollection statusCollection = $$(By.xpath("//span[@class='MuiChip-label MuiChip-labelSmall']"));
   private SelenideElement inputTechnologyField = $(By.xpath("//div[@class='styles_projectsSearchItem__3p1ng'][4]//input[@type='text']"));

    @Step("Input into project field project {0}")
    public MainPage inputProjectField(String projectName){
        inputProjectField.setValue(projectName);
        $(byText(projectName)).click();
        return this;
    }

    @Step("Check if page contains project name {0}")
    public MainPage checkIfPageContainsProjectName(String projectName){
        sectionWithProjects.shouldHave(text(projectName));
        return this;
    }

    @Step("Input into account field account name {0}")
    public MainPage inputAccountField(String accountName){
        inputAccountField.setValue(accountName);
        $(byText(accountName)).click();
        return this;
    }

    @Step("Click on 1-st project that have account name")
    public MainPage clickOnAccountsProjectName(){
        firstProjectFromDashboard.shouldBe(visible).click();
        return this;
    }

    @Step("Check if 1-st project have account name {0}")
    public MainPage checkIfFirstProjectCorrespondFilter(String accountName){
        boxesWithAccountNameAndProjectName.get(0).shouldHave(text(accountName));
        return this;
    }

    @Step("Go to page {0}")
    public MainPage goToPage(int n) throws InterruptedException {
        Thread.sleep(1000);
        String pageNumberXpath = "//button[normalize-space()='" + n + "']";
        SelenideElement pageNumberBtn = $(By.xpath(pageNumberXpath));
        pageNumberBtn.click();
        return this;
    }

    @Step("Select 'With case study only' option")
    public MainPage withCaseStudyOnlyOptionSelect() throws InterruptedException {
        withCaseStudyOnly.click();
        Thread.sleep(3000);
        return this;
    }

    @Step("Check if case studies are not empty for each project")
    public MainPage checkIfCaseStudiesNotEmptyForProjects(){
        for(SelenideElement element: caseStudiesCollection){
            element.scrollIntoView(true);
            element.shouldNotBe(empty);
        }
        return this;
    }

    @Step("Select 'Only active projects' option")
    public MainPage onlyActiveProjectsOptionSelect() throws InterruptedException {
        onlyActiveProjects.click();
        Thread.sleep(3000);
        return this;
    }

    @Step("Check if statuses are active for each project")
    public MainPage checkIfStatusesAreActiveForProjects(){
        for(SelenideElement element: statusCollection){
            element.scrollIntoView(true);
            element.shouldHave(text("Active"));
        }
        return this;
    }

    @Step("Check if dashboard contains only projects with account name {0}")
    public MainPage checkIfDashboardContainsOnlyProjectsWithAccountName(String accountName) throws InterruptedException {
        Thread.sleep(1000);
        for(SelenideElement element: boxesWithAccountNameAndProjectName){
            element.scrollIntoView(true);
            element.shouldHave(text(accountName));
        }
        return this;
    }

    @Step("Check if dashboard contains only projects with account selected names")
    public MainPage checkIfDashboardContainsProjectsWithAccountNames(List<String> accountNames) throws InterruptedException {
        Thread.sleep(1000);
        int N = 0;
        for(SelenideElement element: boxesWithAccountNameAndProjectName) {
            element.scrollIntoView(true);
            for(int i=0;i<accountNames.size(); i++){
                if( element.has(text(accountNames.get(i))) )
                    N++;
            }
        }

        if(N == 20)
            return this;
        else
            Assert.assertTrue(false, "Dashboard has elements that are not in the list");

        return this;


    }

    @Step("Input into technology field technology {0}")
    public MainPage inputTechnologyField(String technology){
        inputTechnologyField.setValue(technology);
        $(byText(technology)).click();
        return this;
    }


}
