package ccsPageTests;

import baseConfings.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class CreatingCaseStudyPageTests extends BaseTest {

    @Epic("Test CSMA site")
    @Feature("Creating Case Study Page")
    @Description("On the top of CCSp should be diplayed project's and account's name")
    @Severity(SeverityLevel.NORMAL)

    @Test
    public void OnTheTopOfCCSpShouldBeDisplayedProjectsAndAccountsName() throws InterruptedException {
        String projectName = "Advertisement Platforms";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName)
                .clickOnAccountsProjectName(projectName);

        projectPage.clickOnCreateCaseStudyButton();

        ccsPage.checkIfCCSpContainsProjectName(projectName);
        Thread.sleep(5000);
    }
}
