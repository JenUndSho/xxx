package mainPageTests;

import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.GridLoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.*;


public class MainPageTests {
    private MainPage mainPage;
    private GridLoginPage gridLoginPage;

    @BeforeClass
    public void setup(){
     //   Configuration.holdBrowserOpen = true;

        gridLoginPage = new GridLoginPage();
        mainPage = new MainPage();

    }

    @BeforeMethod
    @Parameters("base.url")
    public void start(String baseURL){
        open(baseURL);
    }


    @Epic("Test CSMA site")
    @Feature("Main Page")
    @Description("User is able to search projects by project name")
    @Severity(SeverityLevel.NORMAL)
  //  @Story("")

    @Test
    @Parameters({"email", "password"})
    public void UserIsAbleToSearchProjectsByProjectName(String email, String password) throws InterruptedException {
        String projectName = "2 Degrees";
        gridLoginPage.clickOnLoginButton()
                     .EnterAccount(email, password);

        mainPage.inputProjectField(projectName)
                .checkIfPageContainsProjectName(projectName);
    }
}
