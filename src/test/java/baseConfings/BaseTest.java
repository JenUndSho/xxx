package baseConfings;

import static io.restassured.RestAssured.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.Cookie;
import static org.hamcrest.Matchers.*;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.open;

@Listeners({ScreenShooter.class, SoftAsserts.class})
public class BaseTest {
    protected MainPage mainPage;
    protected GridLoginPage gridLoginPage;
    protected ProjectPage projectPage;
    protected CCSPage ccsPage;
    protected String  csNameToBeDeleted;


    @BeforeClass
    @Parameters({"email", "password", "base.url"})
    public void setup(String email, String password, String baseURL){
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
    public void start(String baseURL, String email, String password){
        open(baseURL);
      //  System.out.println("\n" + url() + "\n");
        for(int i=0;i<=500;i++){
            if(url().contains("sso")){
                login(email, password);
                open(baseURL);
                break;
            }
        }

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

   // @AfterGroups("deleteAPIcs")
    public void deleteCaseStudyViaAPI(int id){
       // int id = getIdOfCaseStudyByCaseStudyName(csNameToBeDeleted);
        baseURI = "https://csma-staging.griddynamics.net/api/graphql";
        String deleteQuery = "mutation {\n" +
                "  deleteCaseStudy(caseStudyId: "+id+")\n" +
                "}\n";

        JSONObject request = new JSONObject();
        request.put("query", deleteQuery);

        Set<Cookie> c = WebDriverRunner.getWebDriver().manage().getCookies();
        Iterator i = c.iterator();
        String firstCookie = i.next().toString();

        RequestSpecification httpRequest = given();
      //  String cookies = httpRequest.get().header("Cookie");

        httpRequest.header("Cookie", firstCookie);
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(request.toJSONString());

        Response response = httpRequest.post();
        ResponseBody body = response.body();

        System.out.println(body.asString());
    }


    public int getIdOfCaseStudyByCaseStudyName(String nameCS){
        baseURI = "https://csma-staging.griddynamics.net/api/graphql";
        String listOfCaseStudiesQuery = "{\n" +
                "  caseStudies {\n" +
                "    id\n" +
                "    name\n" +
                "  }\n" +
                "}";

        JSONObject request = new JSONObject();
        request.put("query", listOfCaseStudiesQuery);

        Set<Cookie> c = WebDriverRunner.getWebDriver().manage().getCookies();
        Iterator i = c.iterator();
        String firstCookie = i.next().toString();

        RequestSpecification httpRequest = given();
        //  String cookies = httpRequest.get().header("Cookie");

        httpRequest.header("Cookie", firstCookie);
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(request.toJSONString());

        Response response = httpRequest.post();
        ResponseBody body = response.body();

        String bodyAsString = body.asString();
        System.out.println(bodyAsString);

        JsonPath jsonPath = response.jsonPath();
        List<HashMap<String, Object>> data = jsonPath.getList("data.caseStudies");
        for (HashMap<String, Object> singleObject : data) {
            if (singleObject.get("name").equals(nameCS)) {
                System.out.println(singleObject.get("id"));
                return  (Integer) singleObject.get("id") ;
            }
        }

        return 0;
    }

/*
    @AfterMethod(dependsOnGroups = {"d1"})
    @Parameters({"base.url"})
    public void deleteCS(String baseURL){
        open(baseURL);
        deleteCaseStudyViaAPI(getIdOfCaseStudyByCaseStudyName(csNameToBeDeleted));
    }

    @AfterMethod(dependsOnGroups = {"d2"})
    @Parameters({"base.url"})
    public void deleteCS2(String baseURL){
        open(baseURL);
        deleteCaseStudyViaAPI(getIdOfCaseStudyByCaseStudyName(csNameToBeDeleted));
    }

 */

}