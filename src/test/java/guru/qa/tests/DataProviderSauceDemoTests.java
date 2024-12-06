package guru.qa.tests;

import guru.qa.data.SauceDemoProduct;
import guru.qa.pages.SauceDemoCatalogPage;
import guru.qa.pages.SauceDemoItemCardPage;
import guru.qa.pages.SauceDemoLoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DataProviderSauceDemoTests extends TestBase {

    SauceDemoCatalogPage sauceDemoCatalogPage = new SauceDemoCatalogPage();
    SauceDemoItemCardPage sauceDemoItemCardPage = new SauceDemoItemCardPage();

    SauceDemoLoginPage loginPage = new SauceDemoLoginPage();

    @ValueSource(strings = {
            "Sauce Labs Backpack",
            "Sauce Labs Bike Light",
            "Sauce Labs Bolt T-Shirt"
    })
    @ParameterizedTest(name = "Adding {0} to a basket")
    @Tag("REGRESS")
    void addOneItemToBasketViaValueSourceTest(String item) {
        sauceDemoCatalogPage
                .findItemViaDescription(item)
                .addItemViaDescription(item)
                .checkBasketNotEmpty();
    }

    @EnumSource(SauceDemoProduct.class)
    @Tag("REGRESS")
    @ParameterizedTest(name = "Use enum as a data provider - {0} Card")
    void openItemCardAndCheckNameTest(SauceDemoProduct item) {

        sauceDemoCatalogPage.openItemCard(item.getProductName());

        sauceDemoItemCardPage.checkItemNameIsCorrect(item.getProductName());
    }

    @Tag("SMOKE")
    @Tag("REGRESS")
    @Test
    void ensureCatalogNotEmptyTest() {
        sauceDemoCatalogPage.checkCatalogNotEmpty();
    }

    @Tag("SMOKE")
    @Tag("REGRESS")
    @ValueSource(strings = {
            "Swag Labs"
    })
    @ParameterizedTest(name = "Title is equal to {0}")
    void ensureTitleIsCorrectTest(String title) {
        sauceDemoCatalogPage.checkTitle(title);
    }

    @Tag("SMOKE")
    @Tag("REGRESS")
    @Test
    void logoutTest() {
        sauceDemoCatalogPage
                .openSideMenu()
                .logout();

        loginPage.checkLoginPageOpened();
    }
}
