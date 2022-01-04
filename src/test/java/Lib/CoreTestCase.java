package Lib;
import Lib.UI.WelcomePageObject;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.skipWelcomePageForIosApp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        driver.quit();
    }

    private void skipWelcomePageForIosApp(){
        if (Platform.getInstance().isIos()){
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();
        }
    }


}
