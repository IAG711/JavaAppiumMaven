package Lib.UI.ios;

import Lib.UI.MyListsPageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class IosMyListsPageObject extends MyListsPageObject {

    static {
        element_delete_article_after_swipe = By.id("swipe action delete");
    }

    public IosMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
