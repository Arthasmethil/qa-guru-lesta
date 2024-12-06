package guru.qa.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class SauceDemoBasketPage {


    private final ElementsCollection basketItems = $$(".cart_item");
    @Step("Check basket not empty")
    public void checkBasketNotEmpty() {
        basketItems.shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
}
