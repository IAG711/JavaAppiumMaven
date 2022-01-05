package Lib.UI.Factories;

import Lib.Platform;
import Lib.UI.ArticlePageObject;
import Lib.UI.android.AndroidArticlePageObject;
import Lib.UI.ios.IosArticlePageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObjectFactory {
    public static ArticlePageObject get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid()){
            return new AndroidArticlePageObject(driver);
        }
        else {
            return new IosArticlePageObject(driver);
        }
    }
}
