package Lib.UI.Factories;

import Lib.Platform;
import Lib.UI.NavigationUI;
import Lib.UI.android.AndroidNavigationUi;
import Lib.UI.ios.IosNavigationUi;
import Lib.UI.mobile_web.MWNavigationUi;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUiFactory {
    public static NavigationUI get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidNavigationUi(driver);
        }
        else if (Platform.getInstance().isIos()){
            return new IosNavigationUi(driver);
        }
        else {
            return new MWNavigationUi(driver);
        }
    }
}
