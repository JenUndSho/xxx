package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class GridLoginPage {
    private SelenideElement loginButton = $(Selectors.byText("Sign in with login and password"));
    private SelenideElement emailField = $(By.xpath("//input[@id='login']"));
    private SelenideElement passwordField = $(By.xpath("//input[@id='password']"));
    private SelenideElement signInNowButton = $(".ingrid-button__button");

    @Step("Click on login button")
    public GridLoginPage clickOnLoginButton(){
        loginButton.click();
        return this;
    }

    @Step("Enter account with email {0} and password {1}")
    public GridLoginPage EnterAccount(String email, String password){
        emailField.setValue(email);
        passwordField.setValue(password);
        signInNowButton.click();
        return this;
    }


}
