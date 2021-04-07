package baseConfings;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import pages.CCSPage;
import pages.GridLoginPage;
import pages.MainPage;
import pages.ProjectPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected MainPage mainPage;
    protected GridLoginPage gridLoginPage;
    protected ProjectPage projectPage;
    protected CCSPage ccsPage;

    @BeforeClass
    @Parameters({"email", "password", "base.url"})
    public void setup(String email, String password, String baseURL){
        //   Configuration.holdBrowserOpen = true;
        Configuration.startMaximized = true;

        gridLoginPage = new GridLoginPage();
        mainPage = new MainPage();
        projectPage = new ProjectPage();
        ccsPage = new CCSPage();

        open(baseURL);
        login(email, password);

    }

    @BeforeMethod
    @Parameters("base.url")
    public void start(String baseURL){
        open(baseURL);
    }


    public void login(String email, String password){
        gridLoginPage.clickOnLoginButton()
                .EnterAccount(email, password);
    }

    public void deleteArea(String area) {
        projectPage.clickOnPenIconButton()
                   .deleteAreaFromContainer(area);
    }

    public void deleteTechnology(String technology) {
        projectPage.clickOnPenIconButton()
                   .deleteTechnologyFromContainer(technology);

    }
}
