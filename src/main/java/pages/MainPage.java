package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class MainPage {
   private SelenideElement inputProjectField = Selenide.$(By.xpath("//div[@class='styles_projectsSearchItem__3p1ng'][2]//input[@type='text']"));
   private SelenideElement sectionWithProjects = Selenide.$(".styles_contentWrapper__1tkbn");

    @Step("Input into project field project {0}")
    public MainPage inputProjectField(String projectName){
        inputProjectField.setValue(projectName);
        Selenide.$(Selectors.byText("2 Degrees")).click();
        return this;
    }

    @Step("Check if page contains project name {0}")
    public MainPage checkIfPageContainsProjectName(String projectName){
        sectionWithProjects.shouldHave(Condition.text(projectName));
        return this;
    }

}
