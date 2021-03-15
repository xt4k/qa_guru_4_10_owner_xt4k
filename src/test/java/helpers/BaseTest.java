package helpers;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;
import static java.lang.System.getProperty;
import static java.lang.System.setProperty;
import static org.junit.jupiter.api.Assertions.fail;

public class BaseTest {
    protected static String basePageUrl = "https://demoqa.com/automation-practice-form";

    @BeforeAll
    static void setup( ) {
        addListener("AllureSelenide", new AllureSelenide( ).screenshots(true).savePageSource(true));
        Configuration.browser = getProperty("browser", "chrome");
        startMaximized = true;
        if (System.getProperty("remote_driver") != null) {
            // config for Java + Selenide
            DesiredCapabilities capabilities = new DesiredCapabilities( );
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = System.getProperty("remote_driver");

            Properties properties = new Properties( );
            try {
                properties.load(new FileReader("src/test/resources/properties/common.properties"));
            } catch (IOException e) {
                e.printStackTrace( );
            }
            setProps(properties);
        }
    }

    private static void setProps(Properties properties) {
        properties.forEach((key, value) -> setProperty((String) key, (String) value));
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
        if (System.getProperty("video_storage") != null)
            attachVideo( );
        closeWebDriver( );
    }

}