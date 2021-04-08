package baseConfings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static com.codeborne.selenide.WebDriverRunner.*;
import org.testng.annotations.*;
import pages.CCSPage;
import pages.GridLoginPage;
import pages.MainPage;
import pages.ProjectPage;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.open;

@Listeners({ScreenShooter.class})
public class BaseTest {
    protected MainPage mainPage;
    protected GridLoginPage gridLoginPage;
    protected ProjectPage projectPage;
    protected CCSPage ccsPage;


    @BeforeClass
    @Parameters({"email", "password", "base.url"})
    public void setup(String email, String password, String baseURL) throws MalformedURLException {
        //   Configuration.holdBrowserOpen = true;
        Configuration.startMaximized = true;

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false));

        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;

        gridLoginPage = new GridLoginPage();
        mainPage = new MainPage();
        projectPage = new ProjectPage();
        ccsPage = new CCSPage();

        open(baseURL);
        login(email, password);

    }

    @BeforeMethod
    @Parameters({"base.url", "email", "password"})
    public void start(String baseURL, String email, String password) throws InterruptedException {
        open(baseURL);
        Thread.sleep(2000);
        String urlActual = url();

        if(urlActual.contains("sso"))
            login(email, password);
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