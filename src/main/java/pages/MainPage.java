package pages;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class MainPage {
   private SelenideElement inputProjectField = $(By.xpath("//div[@class='styles_projectsSearchItem__3p1ng'][2]//input[@type='text']"));
  //   This works, but I would try below path!  private SelenideElement sectionWithProjects = $(".styles_contentWrapper__1tkbn");
   private SelenideElement sectionWithProjects = $(By.xpath("//tbody[@class='MuiTableBody-root']"));
   private SelenideElement inputAccountField = $(By.xpath("//div[@class='styles_projectsSearchItem__3p1ng'][1]//input[@type='text']"));
   private SelenideElement firstProjectFromDashboard = $$(By.xpath("//th//a/h6")).get(0);
   private ElementsCollection boxesWithAccountNameAndProjectName = $$(By.xpath("//div[@class='styles_container__mut_C styles_accountProjectBlock__2lfW_']"));
   private SelenideElement nextPageBtn = $(By.xpath("//button[@aria-label='Go to next page']"));
   private SelenideElement withCaseStudyOnly = $(byText("With case studies only"));
   private ElementsCollection caseStudiesCollection = $$(By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body styles_caseStudiesColumn__J39-l']"));
   private SelenideElement onlyActiveProjects = $(byText("Only active projects"));
   private SelenideElement managedByMe = $(byText("Managed by me"));
   private ElementsCollection statusCollection = $$(By.xpath("//span[@class='MuiChip-label MuiChip-labelSmall']"));
   private SelenideElement inputTechnologyField = $(By.xpath("//div[@class='styles_projectsSearchItem__3p1ng'][5]//input[@type='text']"));
   private SelenideElement inputAreaField = $(By.xpath("//div[@class='styles_projectsSearchItem__3p1ng'][3]//input[@type='text']"));
   private ElementsCollection areasForEachProject = $$(By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body styles_areaColumn__27Y0s']"));
   private SelenideElement paginationBtn = $(By.xpath("//div[@role='button'][@aria-haspopup='listbox']"));
   private ElementsCollection listOfPaginationNumbers = $$(By.xpath("//li[@role='option']"));
   private SelenideElement clearBtn = $(byText("Clear"));
   private SelenideElement filters = $(By.xpath("//div[@class='styles_projectsListFilterContainer__kIa9Q']"));

   @Step("Check if it is a main page")
   public boolean isItMainPage(){
       return nextPageBtn.exists();
   }

   @Step("Input into project field project {0}")
    public MainPage inputProjectField(String projectName){
        inputProjectField.setValue(projectName);
        $(byText(projectName)).shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }

    @Step("Input into technology field technology {0}")
    public MainPage inputTechnologyField(String technology){
        inputTechnologyField.setValue(technology);
        $(byText(technology)).shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }

    @Step("Check if page contains project name {0}")
    public MainPage checkIfPageContainsProjectName(String projectName){
       firstProjectFromDashboard.shouldBe(visible, Duration.ofSeconds(6));
       if (firstProjectFromDashboard.has(text(projectName)))
           return this;
       else
           sectionWithProjects.shouldHave(text(projectName), Duration.ofSeconds(6));
       return this;
    }

    @Step("Input into account field account name {0}")
    public MainPage inputAccountField(String accountName){
        inputAccountField.setValue(accountName);
        $(byText(accountName)).shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }

    @Step("Input into area field area {0}")
    public MainPage inputAreaField(String area){
        inputAreaField.setValue(area);
        $(byText(area)).shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }

    @Step("Click on 1-st project that have account name")
    public MainPage clickOnAccountsProjectName(String name){
        firstProjectFromDashboard.shouldHave(text(name)).click();
        return this;
    }

    @Step("Check if 1-st project have account name {0}")
    public MainPage checkIfFirstProjectCorrespondFilter(String accountName){
        boxesWithAccountNameAndProjectName.get(0).shouldHave(text(accountName));
        return this;
    }

    @Step("Go to page {0}")
    public MainPage goToPage(int n) {
       // Thread.sleep(1000);
        String pageNumberXpath = "//button[normalize-space()='" + n + "']";
        SelenideElement pageNumberBtn = $(By.xpath(pageNumberXpath));
        pageNumberBtn.shouldBe(visible, Duration.ofSeconds(5)).click();
        pageNumberBtn.shouldHave(attribute("aria-current"), Duration.ofSeconds(5));
        return this;
    }

    @Step("Select 'With case study only' option")
    public MainPage withCaseStudyOnlyOptionSelect() {
        withCaseStudyOnly.click();
        filters.shouldHave(text("Only with case studies"), Duration.ofSeconds(5));
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
    public MainPage onlyActiveProjectsOptionSelect(){
        onlyActiveProjects.click();
        filters.shouldHave(text("Only active projects"), Duration.ofSeconds(5));
        return this;
    }

    @Step("Select 'Managed by me' option")
    public MainPage managedByMeOptionSelect() {
        managedByMe.click();
        filters.shouldHave(text("Managed by me"), Duration.ofSeconds(5));
        return this;
    }

    @Step("Check if statuses are active for each project")
    public MainPage checkIfStatusesAreActiveForProjects(){
       statusCollection.get(0).shouldBe(visible, Duration.ofSeconds(5));
        for(SelenideElement element: statusCollection){
            element.scrollIntoView(true);
            element.shouldHave(text("Active"));
        }
        return this;
    }

    @Step("Check if dashboard contains only projects with account name {0}")
    public MainPage checkIfDashboardContainsOnlyProjectsWithAccountName(String accountName){
        firstProjectFromDashboard.shouldHave(text(accountName), Duration.ofSeconds(5));
        for(SelenideElement element: boxesWithAccountNameAndProjectName){
            element.scrollIntoView(true);
            element.shouldHave(text(accountName));
        }
        return this;
    }

    @Step("Check if dashboard contains only projects with account selected names")
    public MainPage checkIfDashboardContainsProjectsWithAccountNames(List<String> accountNames){
       firstProjectFromDashboard.shouldBe(visible, Duration.ofSeconds(5));
        for(int i=0;i<accountNames.size(); i++){
            if(firstProjectFromDashboard.has(text(accountNames.get(i))))
                break;
        }
        int displayedProjectsAmount = accountNames.size();
        int N = 0;
        for(SelenideElement element: boxesWithAccountNameAndProjectName) {
            element.scrollIntoView(true);
            for(int i=0;i<accountNames.size(); i++){
                if( element.has(text(accountNames.get(i))) )
                    N++;
            }
        }

        if(N >= displayedProjectsAmount)
            return this;
        else
            Assert.assertTrue(false, "Dashboard doesn't have elements that are in the list");

        return this;


    }

    @Step("Check if area {0} is in each project")
    public MainPage checkIfAreaIsInEachProject(String area){
        for(SelenideElement element: areasForEachProject){
            element.scrollIntoView(true);
            element.shouldHave(text(area));
        }
        return this;
    }

    @Step("Check if statuses are active for each project")
    public MainPage checkIfManagedByMeProjectListIsEmpty(){
        sectionWithProjects.shouldBe(empty);
        return this;
    }

    @Step("Check if dashboard contains only projects with selected areas")
    public MainPage checkIfDashboardContainsProjectsWithAreas(List<String> areas) {

        int displayedProjectsAmount = areasForEachProject.size();
        int N = 0;
        for (SelenideElement element : areasForEachProject) {
            element.scrollIntoView(true);
            for (int i = 0; i < areas.size(); i++) {
                if (element.has(text(areas.get(i))))
                    N++;
            }
        }
        System.out.println(N);
        if (N >= displayedProjectsAmount)
            return this;
        else
            Assert.assertTrue(false, "Dashboard doesn't have elements that are in the list");

        return this;
    }

    @Step("Check if each project from the list contains area {0} and random project contains technology {1}")
    public MainPage checkIfEachProjectFromListContainsAreaAndRandomProjectContainsTechnology(String area, String technology, ProjectPage projectPage) throws InterruptedException {
        checkIfAreaIsInEachProject(area);
      //  clickOnAccountsProjectName();
        projectPage.checkIfBoxTechnologyContainsTechnology(technology);
        return this;
    }

    @Step("Check if projects from the list has selected technologies")
    public MainPage checkIfEachProjectsFromListHasSelectedTechnologies(List<String> technologies, ProjectPage projectPage){
            boolean found = false;

            firstProjectFromDashboard.click();
            SelenideElement boxWithTechnologies =  projectPage.getBoxWithTechnologies();
            boxWithTechnologies.shouldBe(visible);
            for(int i=0; i<technologies.size(); i++){
                if(boxWithTechnologies.has(text(technologies.get(i)))){
                    found = true;
                    break;
                }
            }
            if(found)
                return this;
            else
                Assert.assertTrue(false, "Technologies box doesn't have elements that are in the list");
            return this;
    }

    @Step("Check if amount of projects on page {0} is <= the number, displayed into the top-right corner")
    public MainPage checkAmountOfProjectsOnPage(int pageNumber, int expectedListSize){
        paginationBtn.click();
        String listSize = "" + expectedListSize;
        listOfPaginationNumbers.findBy(attribute("data-value", listSize)).click();
        goToPage(pageNumber);
        int size = 0;
        for(SelenideElement element: statusCollection){
            element.scrollIntoView(true);
            size++;
        }
        if(size <= expectedListSize)
            return this;
        else
            Assert.assertTrue(false, "Size of list of projects on dashboard is invalid");

        return this;
    }

    @Step("Check if it is main page")
    public MainPage checkIfItIsMainPage(){
        clearBtn.shouldBe(visible);
        return this;
    }

    public MainPage reloadPage(){
       refresh();
       return this;
    }


}
