package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

public class GridLoginPage {
    private SelenideElement loginButton = $(By.xpath("//div[@class='auth-page__auth-toggle']"));
    private SelenideElement emailField = $(By.xpath("//input[@id='login']"));
    private SelenideElement passwordField = $(By.xpath("//input[@id='password']"));
    private SelenideElement signInNowButton = $(".ingrid-button__button");

    @Step("Click on login button")
    public GridLoginPage clickOnLoginButton(){
        loginButton.shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }

    @Step("Enter account with email {0} and password {1}")
    public GridLoginPage EnterAccount(String email, String password){
        emailField.setValue(email);
        passwordField.setValue(password);
        signInNowButton.shouldBe(visible, Duration.ofSeconds(5)).click();
        return this;
    }


}
