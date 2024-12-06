package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.SauceDemoLoginPage;
import guru.qa.utils.PropertiesProvider;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static guru.qa.helpers.Attach.*;

public class TestBase {

    private final SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
    private final PropertiesProvider propertiesProvider = new PropertiesProvider();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.timeout = 10000;
        Configuration.remote = System.getProperty("remoteHost");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListenerAndSetup() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        sauceDemoLoginPage
                .openPage()
                .setUsername(propertiesProvider.getLogin())
                .setPassword(propertiesProvider.getPassword())
                .logIn();
    }

    @AfterEach
    void addAttachmentsAndCloseWebdriver() {
        screenshotAs("Screenshot");
        pageSource();
        browserConsoleLogs();
        addVideo();
        Selenide.closeWebDriver();
    }

}

