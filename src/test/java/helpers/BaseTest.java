package helpers;

import config.WebConfig;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;
import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.fail;

public class BaseTest {
    public static String basePageUrl;//="https://demoqa.com/automation-practice-form";

    @BeforeAll
    static void setup( ) {
        addListener("AllureSelenide", new AllureSelenide( ).screenshots(true).savePageSource(true));

        final WebConfig config = ConfigFactory.create(WebConfig.class, getProperties());
        browser = config.getBrowser();
        browserVersion=config.getBrowserVersion();
        startMaximized = true;
        basePageUrl = config.getBaseUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities( );
            capabilities.setCapability("enableVNC", config.isEnableVnc());
            capabilities.setCapability("enableVideo", config.isEnableVideo());
            browserCapabilities = capabilities;
            remote = config.getRemoteDriver();

             getProperties().forEach((key, value) -> out.println("key: "+ key+ "value "+ value));

    }



    @Step("Here will be in purpose failed test.")
    public void failStep( ) {
        fail("This step fails test.");
    }

    @AfterEach
    public void afterEach( ) {
        attachScreenshot("Last screenshot");
        attachPageSource( );
        attachAsText("Browser console logs", getConsoleLogs( ));
        if (getProperty("video_storage") != null)
            attachVideo( );
        closeWebDriver( );
    }

}