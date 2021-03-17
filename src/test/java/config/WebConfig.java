package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${env}.properties")
public interface WebConfig extends Config {

    @Key("enable.vnc")
    @DefaultValue("true")
    boolean isEnableVnc();

    @Key("enable.video")
    @DefaultValue("true")
    boolean isEnableVideo();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser( );

    @Key("browser.version")
    @DefaultValue("89")
    String getBrowserVersion( );

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com/automation-practice-form")
    String getBaseUrl( );

    @Key("remote.driver")
   String getRemoteDriver();


}
