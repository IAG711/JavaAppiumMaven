package Lib;
import Lib.UI.WelcomePageObject;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.util.Properties;

public class CoreTestCase{

    protected RemoteWebDriver driver;

    @Before
    @Step("Run driver and session")
    public void setUp() throws Exception {
        driver = Platform.getInstance().getDriver();
        this.createAllurePropertyFile();
        this.skipWelcomePageForIosApp();
        this.openWikiWebPageForMW();
    }

    @After
    @Step("Remove driver and session")
    public void tearDown() {
        driver.quit();
    }

    @Step("Skipping welcome screen on Ios app")
    private void skipWelcomePageForIosApp(){
        if (Platform.getInstance().isIos()){
            AppiumDriver driver = (AppiumDriver) this.driver;
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }

    @Step("Opening web page for mobile web version(do nothing for Android and Ios)")
    protected void openWikiWebPageForMW(){
        if (Platform.getInstance().isMW()){
            driver.get("https://en.m.wikipedia.org");
        } else  System.out.println("Method openWikiWebPageForMW() do nothing for platforms " + Platform.getInstance().getPlatformVar());
    }

    private void createAllurePropertyFile(){
        String path = System.getProperty("allure.results.directory");
        try {
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path +  "/environment.properties");
            props.setProperty("Environment", Platform.getInstance().getPlatformVar());
            props.store(fos, "See https://docs.qameta.io/allure/#_environment");
            fos.close();
        } catch (Exception e) {
            System.err.println("IO problem when writing allure properties file");
            e.printStackTrace();
        }
    }


}