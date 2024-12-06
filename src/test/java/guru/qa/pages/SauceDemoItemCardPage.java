package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SauceDemoItemCardPage {
    private final SelenideElement basketButton = $(".inventory_details_name");

    @Step("Add item {0} is correct")
    public void checkItemNameIsCorrect(String name) {
        basketButton.shouldHave(text(name));
    }
}
