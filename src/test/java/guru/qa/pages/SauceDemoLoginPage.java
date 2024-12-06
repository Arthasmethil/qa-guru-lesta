package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SauceDemoLoginPage {
    private final SelenideElement usernameInput = $("#user-name");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement loginButton = $("#login-button");
    private final SelenideElement logo = $(".login_logo");

    @Step("Open login page")
    public SauceDemoLoginPage openPage() {
        open("");
        logo.shouldHave(text("Swag Labs"));
        return this;
    }

    @Step("Fills up a username {0}")
    public SauceDemoLoginPage setUsername(String value) {
        usernameInput.setValue(value);
        return this;
    }

    @Step("Fills up a password {0}")
    public SauceDemoLoginPage setPassword(String value) {
        passwordInput.setValue(value);
        return this;
    }

    @Step("login")
    public void logIn() {
        loginButton.click();
    }

    @Step("Login page is opened")
    public void checkLoginPageOpened() {
        logo.shouldBe(visible);
        usernameInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        loginButton.shouldBe(visible);
    }
}
