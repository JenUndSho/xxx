package mainPageTests;

import baseConfings.BaseTest;
import io.qameta.allure.*;
import org.junit.experimental.theories.Theories;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GridLoginPage;
import pages.MainPage;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class MainPageTests extends BaseTest{

    @Epic("Test CSMA site")
    @Feature("Main Page")
    @Description("User is able to search projects by project name")
    @Severity(SeverityLevel.NORMAL)
  //  @Story("")
    @Test
    public void userIsAbleToSearchProjectsByProjectName(){
        String projectName = "2 Degrees";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName);
    }


    @Epic("Test CSMA site")
    @Feature("Main Page")
    @Story("Bug")
    @Description("User finds project(s) using filter, then clicks on this project. " +
            "When user press \"<- back to the projects\" button, the page with the same " +
            "filters and projects should open")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")
    @Test
    public void resultsCorrespondFiltersAfterVisitingProjectPage(){
        String accountName = "Jump Ramp Games";
        String project = "Backend replatforming";

        mainPage.inputAccountField(accountName)
                .clickOnAccountsProjectName(project);
        projectPage.clickOnBackToProjectsBtn();
      //  Thread.sleep(3000);
        mainPage.checkIfFirstProjectCorrespondFilter(accountName);

       // mainPage.checkIfFirstProjectCorrespondFilter("Raymond James");   -> this works.
    }


    @Epic("Test CSMA site")
    @Feature("Main Page")
    @Story("Bug")
    @Description("User is able to get the list of projects choosing an existing \"Account Name\"")
    @Severity(SeverityLevel.NORMAL)
    //  @Story("")
    @Test
    public void userIsAbleToGetTheListOfProjectsChoosingExistingAccountName(){
        String accountName = "Macys";

        mainPage.goToPage(5)
                .goToPage(6)
                .checkIfFirstProjectCorrespondFilter(accountName);

        mainPage.goToPage(1)
                .inputAccountField(accountName);
       // Thread.sleep(1000);
        mainPage.checkIfFirstProjectCorrespondFilter(accountName);

    }

    @Epic("Test CSMA site")
    @Feature("Main Page")
   // @Story("")
    @Description("User is able to filter projects by 'With case studies only'")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userAbleToFilterProjectsByWithCaseStudiesOnly() {
            mainPage.withCaseStudyOnlyOptionSelect()
                    .checkIfCaseStudiesNotEmptyForProjects();
    }


    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to filter projects by 'Only active projects'")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userIsAbleToFilterProjectsByOnlyActiveProjects(){
        mainPage.onlyActiveProjectsOptionSelect()
                .checkIfStatusesAreActiveForProjects();
    }


    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to filter projects by account name")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userIsAbleToFilterProjectsByAccountName(){
        String accountName = "Coleman";

        mainPage.inputAccountField(accountName)
                .checkIfDashboardContainsOnlyProjectsWithAccountName(accountName);
    }


    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to filter projects by technologies")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userIsAbleToFilterProjectsByTechnologies() {
        String technology = "Azure";
        String project = "106 BOM - Trade Corrections CO2";

        mainPage.inputTechnologyField(technology)
                .clickOnAccountsProjectName(project);
        projectPage.checkIfBoxTechnologyContainsTechnology(technology);

    }

    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to get the list of projects not by one account")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userIsAbleToGetListOfProjectsNotByOneAccount(){
        String accountName1 = "Apple";
        String accountName2 = "AEO";
        String accountName3 = "Coleman";
        List<String> accounts = Arrays.asList(accountName1, accountName2, accountName3);

        mainPage.inputAccountField(accountName1)
                .inputAccountField(accountName2)
                .inputAccountField(accountName3)
                .goToPage(4)
                .checkIfDashboardContainsProjectsWithAccountNames(accounts);
    }

/*
    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to filter projects by area")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void userIsAbleToFilterProjectsByAreas() throws InterruptedException {
        String area = "Mobile";

        mainPage.inputAreaField(area)
                .checkIfAreaIsInEachProject(area);
    }


 */
    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to filter projects by 'Managed by me")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userIsAbleToFilterProjectsByManagedByMe(){
        mainPage.managedByMeOptionSelect()
                .checkIfManagedByMeProjectListIsEmpty();
    }

    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to filter projects by account and project name")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userIsAbleToFilterProjectsByAccountAndProjectName(){
        String accountName = "Dell";
        String projectName = "Retail Edge";

        mainPage.inputProjectField(projectName)
                .checkIfFirstProjectCorrespondFilter(accountName + '\n' + projectName);
    }

    /*
    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to filter projects with many areas")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void userAbleToFilterProjectsWithManyAreas() throws InterruptedException {
        String area1 = "BigData Analytics";
        String area2 = "Management area";

        List<String> areas = Arrays.asList(area1, area2);
        mainPage.inputAreaField(area2)
                .inputAreaField(area1)
                .checkIfDashboardContainsProjectsWithAreas(areas);
    }


    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to filter projects by area and technology")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void userAbleToFilterProjectsByAreaAndTechnology() throws InterruptedException {
        String area = "Fraud Protection";
        String technology = "Typescript";

        mainPage.inputAreaField(area)
                .inputTechnologyField(technology)
                .checkIfEachProjectFromListContainsAreaAndRandomProjectContainsTechnology
                        (area,technology,projectPage);
    }

     */

    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to filter projects with many technologies")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userAbleToFilterProjectsByManyTechnologies(){
        String technology1 = "Java";
        String technology2 = "OpenCV";
        String technology3 = "React";

        List<String> technologies = Arrays.asList(technology1, technology2, technology2);


        mainPage.inputTechnologyField(technology1)
                .inputTechnologyField(technology2)
                .inputTechnologyField(technology3);
        mainPage.checkIfEachProjectsFromListHasSelectedTechnologies(technologies, projectPage);
    }


    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("If user click on project, he should be redirected to the it's project page")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void userAbleToBeRedirectedToCorrectProjectPage(){
        String accountName = "Coleman";

        mainPage.inputAccountField(accountName)
                .clickOnAccountsProjectName(accountName);
        projectPage.checkIfPageContainsAccountName(accountName);
    }


    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("Amount of projects on each page should be <= the number, displayed into the top-right corner")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void checkAmountOfProjectsOnDashboardOnDifferentPages(){
        mainPage.checkAmountOfProjectsOnPage(1, 20);
        mainPage.checkAmountOfProjectsOnPage(4, 200);
        mainPage.checkAmountOfProjectsOnPage(34, 50);
    }

    /**
     * Tests below were created just to check functions API (delete)
     */

    /*

    @Test
    public void test() throws InterruptedException {
        String projectName = "Advertisement Platforms";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();
        projectPage.clickOnBackToProjectsBtn();
        deleteCaseStudyViaAPI(110);
        mainPage.reloadPage();

        System.out.println("test done");
    }

    @Test
    public void test1() throws InterruptedException {
        String projectName = "Advertisement Platforms";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName();
        projectPage.clickOnBackToProjectsBtn();
        int i = getIdOfCaseStudyByCaseStudyName("New Test Case Study");
        System.out.println(i);
        mainPage.reloadPage();

        System.out.println("test done");
    }

     */
}
