package pages;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class MainPage {
   private SelenideElement inputProjectField = $(By.xpath("//div[@class='styles_projectsSearchItem__3p1ng'][2]//input[@type='text']"));
   private SelenideElement sectionWithProjects = $(".styles_contentWrapper__1tkbn");
   private SelenideElement inputAccountField = $(By.xpath("//div[@class='styles_projectsSearchItem__3p1ng'][1]//input[@type='text']"));
   private SelenideElement firstProjectFromDashboard = $$(By.xpath("//a/h6")).get(0);
   private SelenideElement boxWithAccountNameAndProjectNameInFirstProject = $$(By.xpath("//div[@class='styles_container__mut_C styles_accountProjectBlock__2lfW_']")).get(0);
   private SelenideElement nextPageBtn = $(By.xpath("//button[@aria-label='Go to next page']"));


    @Step("Input into project field project {0}")
    public MainPage inputProjectField(String projectName){
        inputProjectField.setValue(projectName);
        $(byText(projectName)).click();
        return this;
    }

    @Step("Check if page contains project name {0}")
    public MainPage checkIfPageContainsProjectName(String projectName){
        sectionWithProjects.shouldHave(text(projectName));
        return this;
    }

    @Step("Input into account field account name {0}")
    public MainPage inputAccountField(String accountName){
        inputAccountField.setValue(accountName);
        $(byText(accountName)).click();

        return this;
    }

    @Step("Click on 1-st project that have account name {0}")
    public MainPage clickOnAccountsProjectName(String projectName){
        firstProjectFromDashboard.shouldBe(visible).click();
        return this;
    }

    @Step("Check if 1-st project have account name {0}")
    public MainPage checkIfFirstProjectCorrespondFilter(String accountName){
        boxWithAccountNameAndProjectNameInFirstProject.shouldHave(text(accountName));
        return this;
    }

    @Step("Go to page {0}")
    public MainPage goToPage(int n){
        String pageNumberXpath = "//button[normalize-space()='" + n + "']";
        SelenideElement pageNumberBtn = $(By.xpath(pageNumberXpath));
        pageNumberBtn.click();
        return this;
    }



}
