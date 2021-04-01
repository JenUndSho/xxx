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


}
