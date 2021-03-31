package mainPageTests;

import baseConfings.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GridLoginPage;
import pages.MainPage;

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
                .clickOnAccountsProjectName(accountName);
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
    public void UserIsAbleToGetTheListOfProjectsChoosingExistingAccountName() throws InterruptedException {
        String accountName = "Macys";

        mainPage.goToPage(5)
                .goToPage(6)
                .checkIfFirstProjectCorrespondFilter(accountName);

        mainPage.goToPage(1)
                .inputAccountField(accountName);
        Thread.sleep(1000);
        mainPage.checkIfFirstProjectCorrespondFilter(accountName);

    }


}
