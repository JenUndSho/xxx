package mainPageTests;

import baseConfings.BaseTest;
import io.qameta.allure.*;
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
    public void userIsAbleToSearchProjectsByProjectName() throws InterruptedException {
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
    public void resultsCorrespondFiltersAfterVisitingProjectPage() throws InterruptedException {
        String accountName = "Jump Ramp Games";

        mainPage.inputAccountField(accountName)
                .clickOnAccountsProjectName();
        projectPage.clickOnBackToProjectsBtn();
        Thread.sleep(3000);
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
    public void userIsAbleToGetTheListOfProjectsChoosingExistingAccountName() throws InterruptedException {
        String accountName = "Macys";

        mainPage.goToPage(5)
                .goToPage(6)
                .checkIfFirstProjectCorrespondFilter(accountName);

        mainPage.goToPage(1)
                .inputAccountField(accountName);
        Thread.sleep(1000);
        mainPage.checkIfFirstProjectCorrespondFilter(accountName);

    }

    @Epic("Test CSMA site")
    @Feature("Main Page")
   // @Story("")
    @Description("User is able to filter projects by 'With case studies only'")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void userAbleToFilterProjectsByWithCaseStudiesOnly() throws InterruptedException {
            mainPage.withCaseStudyOnlyOptionSelect()
                    .checkIfCaseStudiesNotEmptyForProjects();
    }


    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to filter projects by 'Only active projects'")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void userIsAbleToFilterProjectsByOnlyActiveProjects() throws InterruptedException {
        mainPage.onlyActiveProjectsOptionSelect()
                .checkIfStatusesAreActiveForProjects();
    }


    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to filter projects by account name")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void userIsAbleToFilterProjectsByAccountName() throws InterruptedException {
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
    public void userIsAbleToFilterProjectsByTechnologies() throws InterruptedException {
        String technology = "Azure";

        mainPage.inputTechnologyField(technology)
                .clickOnAccountsProjectName();
        projectPage.checkIfBoxTechnologyContainsTechnology(technology);

    }

    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to get the list of projects not by one account")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void userIsAbleToGetListOfProjectsNotByOneAccount() throws InterruptedException {
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
    public void userIsAbleToFilterProjectsByManagedByMe() throws InterruptedException {
        mainPage.managedByMeOptionSelect()
                .checkIfManagedByMeProjectListIsEmpty();
    }

    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("User is able to filter projects by account and project name")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void userIsAbleToFilterProjectsByAccountAndProjectName() throws InterruptedException {
        String accountName = "Dell";
        String projectName = "Retail Edge";

        mainPage
                .inputProjectField(projectName)
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
    public void userAbleToFilterProjectsByManyTechnologies() throws InterruptedException {
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
    public void userAbleToBeRedirectedToCorrectProjectPage() throws InterruptedException {
        String accountName = "Coleman";

        mainPage.inputAccountField(accountName)
                .clickOnAccountsProjectName();
        projectPage.checkIfPageContainsAccountName(accountName);
    }


    @Epic("Test CSMA site")
    @Feature("Main Page")
    // @Story("")
    @Description("Amount of projects on each page should be <= the number, displayed into the top-right corner")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void checkAmountOfProjectsOnDashboardOnDifferentPages() throws InterruptedException {
        mainPage.checkAmountOfProjectsOnPage(1, 20);
        mainPage.checkAmountOfProjectsOnPage(4, 200);
        mainPage.checkAmountOfProjectsOnPage(34, 50);
    }

}
