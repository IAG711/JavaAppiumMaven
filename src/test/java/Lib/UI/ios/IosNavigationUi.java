package Lib.UI.ios;

import Lib.UI.NavigationUI;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IosNavigationUi extends NavigationUI {
    static {
        element_open_reading_list_screen_btn = By.id("Saved");
        element_reading_lists_container = By.xpath("//XCUIElementTypeCollectionView");
    }

    public IosNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }
}
