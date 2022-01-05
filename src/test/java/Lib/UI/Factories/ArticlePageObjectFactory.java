package Lib.UI.Factories;

import Lib.Platform;
import Lib.UI.ArticlePageObject;
import Lib.UI.android.AndroidArticlePageObject;
import Lib.UI.ios.IosArticlePageObject;
import Lib.UI.mobile_web.MWArticlePageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory {
    public static ArticlePageObject get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidArticlePageObject(driver);
        }
        else if (Platform.getInstance().isIos()){
            return new IosArticlePageObject(driver);
        }
        else {
            return new MWArticlePageObject(driver);
        }

    }
}
