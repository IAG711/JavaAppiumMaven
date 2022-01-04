package Lib.UI.Factories;

import Lib.Platform;
import Lib.UI.NavigationUI;
import Lib.UI.android.AndroidNavigationUi;
import Lib.UI.ios.IosNavigationUi;
import io.appium.java_client.AppiumDriver;

public class NavigationUiFactory {
    public static NavigationUI get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidNavigationUi(driver);
        }
        else {
            return new IosNavigationUi(driver);
        }
    }
}
