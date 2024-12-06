package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.data.SauceDemoProduct;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SauceDemoCatalogPage {
    private final ElementsCollection catalogItems = $$(".inventory_item");
    private final SelenideElement basketButton = $(".shopping_cart_link");
    private final SelenideElement basketBadge = $(".shopping_cart_badge");

    private final SelenideElement burgerMenu = $("#react-burger-menu-btn");

    private final SelenideElement logoutButton = $("#logout_sidebar_link");

    @Step("Find an item via description {0}")
    public SauceDemoCatalogPage findItemViaDescription(String description) {
        catalogItems.findBy(text(description)).$(".inventory_item_description")
                .shouldHave(text(description));
        return this;
    }

    @Step("Add an item via description {0}")
    public SauceDemoCatalogPage addItemViaDescription(String description) {
        catalogItems.findBy(text(description)).$(".btn").click();
        return this;
    }
    @Step("Open an item card {0}")
    public void openItemCard(String description) {
        catalogItems
                .findBy(text(description))
                .find(".inventory_item_name ")
                .click();
    }

    @Step("Check basket not empty")
    public void checkBasketNotEmpty() {
        basketBadge.shouldBe(visible);
    }

    @Step("Check catalog is not empty")
    public void checkCatalogNotEmpty() {
        Assertions.assertThat(catalogItems.size()).isGreaterThan(1);
    }

    @Step("Check title is Swag Labs")
    public void checkTitle(String title) {
        Assertions.assertThat(title()).isEqualTo(title);
    }

    @Step("Open side menu")
    public SauceDemoCatalogPage openSideMenu() {
        burgerMenu.click();
        return this;
    }

    @Step("Logout")
    public void logout() {
        logoutButton.click();
    }

    @Step("Add items {0}")
    public SauceDemoCatalogPage addItemsToBasket(SauceDemoProduct[] products) {
        for (SauceDemoProduct product : products) {
            catalogItems.findBy(text(product.getProductName())).$(".btn").click();
        }
        return this;
    }
    public void goToBasket() {
        basketButton.click();
    }
}
