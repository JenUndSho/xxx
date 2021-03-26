package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CCSPage {
    private SelenideElement goProjectPageButton = $(By.xpath("//div[@class='styles_backButton__1V0qz']"));

    @Step("Check if CCSp contains project name {0}")
    public CCSPage checkIfCCSpContainsProjectName(String projectName){
        goProjectPageButton.shouldHave(text(projectName));
        return this;
    }
}
