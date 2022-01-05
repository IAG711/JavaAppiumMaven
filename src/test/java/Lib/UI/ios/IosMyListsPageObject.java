package Lib.UI.ios;

import Lib.UI.MyListsPageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IosMyListsPageObject extends MyListsPageObject {

    static {
        element_delete_article_after_swipe = By.id("swipe action delete");
    }

    public IosMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
