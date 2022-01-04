package Lib.UI.Factories;

import Lib.Platform;
import Lib.UI.MyListsPageObject;
import Lib.UI.android.AndroidMyListsPageObject;
import Lib.UI.ios.IosMyListsPageObject;
import io.appium.java_client.AppiumDriver;

public class MyListsPageObjectFactory {
    public static MyListsPageObject get(AppiumDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidMyListsPageObject(driver);
        }
        else {
            return new IosMyListsPageObject(driver);
        }
    }
}
