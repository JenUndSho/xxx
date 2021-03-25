package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class GridLoginPage {
    private SelenideElement loginButton = Selenide.$(Selectors.byText("Sign in with login and password"));
    private SelenideElement emailField = Selenide.$(By.xpath("//input[@id='login']"));
    private SelenideElement passwordField = Selenide.$(By.xpath("//input[@id='password']"));
    private SelenideElement signInNowButton = Selenide.$(".ingrid-button__button");

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
