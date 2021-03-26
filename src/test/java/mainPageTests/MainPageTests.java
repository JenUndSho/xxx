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
    public void UserIsAbleToSearchProjectsByProjectName(){
        String projectName = "2 Degrees";

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName);
    }


}
